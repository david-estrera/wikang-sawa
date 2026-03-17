public final class RuntimeValue {
    public enum Type {
        NUMBER,
        DECIMAL,
        STRING,
        BOOLEAN,
        ARRAY,
        NULL
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

    public boolean isNumeric() {
        return type == Type.NUMBER || type == Type.DECIMAL;
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

    @Override
    public String toString() {
        return switch (type) {
            case NUMBER -> Long.toString((long) value);
            case DECIMAL -> {
                double d = (double) value;
                // Keep it simple for demo: avoid trailing .0 when possible
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

