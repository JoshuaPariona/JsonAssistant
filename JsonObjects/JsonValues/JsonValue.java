package JsonObjects.JsonValues;

public class JsonValue<T> implements JsonObject {
    private T value; //Numeric(Integer, Double), String, Boolean;
    
    private boolean isValidType(T value) {
        return value instanceof Long || value instanceof Double || value instanceof String || value instanceof Boolean;
    }

    protected JsonValue(T value, int i) {
        this.value = value;
    }

    public JsonValue(T value) {
        if (!isValidType(value))
            throw new IllegalArgumentException("invalid type for JsonValue (Long,Double,String,Boolean))");
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return  String.valueOf(value);
    }

}
