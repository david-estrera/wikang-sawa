import java.util.LinkedHashMap;
import java.util.Map;

public final class RuntimeValue {
    public enum Type {
        NUMBER,
        DECIMAL,
        STRING,
        BOOLEAN,
        ARRAY,
        NULL,
        /** Reference to a variable name (shallow pointer: &x) */
        REFERENCE,
        /** Struct instance: field name -> value */
        STRUCT
    }

    public final Type type;
    private final Object value;

    private RuntimeValue(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public static RuntimeValue number(long v) {
        return new RuntimeValue(Type.NUMBER, v);
    }

    public static RuntimeValue decimal(double v) {
        return new RuntimeValue(Type.DECIMAL, v);
    }

    public static RuntimeValue string(String v) {
        return new RuntimeValue(Type.STRING, v);
    }

    public static RuntimeValue bool(boolean v) {
        return new RuntimeValue(Type.BOOLEAN, v);
    }

    public static RuntimeValue nullValue() {
        return new RuntimeValue(Type.NULL, null);
    }

    public static RuntimeValue array(java.util.List<RuntimeValue> v) {
        return new RuntimeValue(Type.ARRAY, v);
    }

    /** Pointer: target variable name resolved through the environment stack. */
    public static RuntimeValue reference(String varName) {
        return new RuntimeValue(Type.REFERENCE, varName);
    }

    public static RuntimeValue structInstance(Map<String, RuntimeValue> fields) {
        return new RuntimeValue(Type.STRUCT, fields);
    }

    public boolean isNumeric() {
        return type == Type.NUMBER || type == Type.DECIMAL;
    }

    public String refTargetName() {
        if (type != Type.REFERENCE) throw new IllegalStateException("Not a REFERENCE");
        return (String) value;
    }

    @SuppressWarnings("unchecked")
    public Map<String, RuntimeValue> asStructFields() {
        if (type != Type.STRUCT) throw new IllegalStateException("Not a STRUCT");
        return (Map<String, RuntimeValue>) value;
    }

    public long asLong() {
        if (type == Type.NUMBER) return (long) value;
        throw new IllegalStateException("Not a NUMBER");
    }

    public double asDouble() {
        if (type == Type.DECIMAL) return (double) value;
        if (type == Type.NUMBER) return (double) ((long) value);
        throw new IllegalStateException("Not numeric");
    }

    public boolean asBoolean() {
        if (type == Type.BOOLEAN) return (boolean) value;
        throw new IllegalStateException("Not a BOOLEAN");
    }

    public String asString() {
        if (type == Type.STRING) return (String) value;
        throw new IllegalStateException("Not a STRING");
    }

    @SuppressWarnings("unchecked")
    public java.util.List<RuntimeValue> asArray() {
        if (type == Type.ARRAY) return (java.util.List<RuntimeValue>) value;
        throw new IllegalStateException("Not an ARRAY");
    }

    public boolean isStruct() {
        return type == Type.STRUCT;
    }

    /** Deep-enough copy for assignment (structs are cloned). */
    public RuntimeValue copyValue() {
        return switch (type) {
            case STRUCT -> {
                Map<String, RuntimeValue> m = new LinkedHashMap<>();
                for (var e : asStructFields().entrySet()) {
                    m.put(e.getKey(), e.getValue().copyValue());
                }
                yield structInstance(m);
            }
            case ARRAY -> {
                java.util.List<RuntimeValue> copy = new java.util.ArrayList<>();
                for (RuntimeValue v : asArray()) {
                    copy.add(v.copyValue());
                }
                yield array(copy);
            }
            default -> this;
        };
    }

    @Override
    public String toString() {
        return switch (type) {
            case NUMBER -> Long.toString((long) value);
            case DECIMAL -> {
                double d = (double) value;
                if (d == Math.rint(d)) yield Long.toString((long) d);
                yield Double.toString(d);
            }
            case STRING -> (String) value;
            case BOOLEAN -> ((boolean) value) ? "totoo" : "mali";
            case ARRAY -> {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                java.util.List<RuntimeValue> arr = asArray();
                for (int i = 0; i < arr.size(); i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(arr.get(i).toString());
                }
                sb.append("]");
                yield sb.toString();
            }
            case NULL -> "wala";
            case REFERENCE -> "&" + value;
            case STRUCT -> {
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                int i = 0;
                for (var e : asStructFields().entrySet()) {
                    if (i++ > 0) sb.append(", ");
                    sb.append(e.getKey()).append("=").append(e.getValue().toString());
                }
                sb.append("}");
                yield sb.toString();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RuntimeValue other)) return false;
        if (this.type != other.type) return false;
        if (this.type == Type.NULL) return true;
        return this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        if (type == Type.NULL) return 0;
        return 31 * type.hashCode() + value.hashCode();
    }
}
