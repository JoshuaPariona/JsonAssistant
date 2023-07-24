package JsonObjects.JsonValues;

import java.util.ArrayList;

public class JsonArray extends ArrayList<JsonObject> implements JsonObject{
    
    @Override
    public ArrayList<JsonObject> getValue() {
        return this;
    }

    public JsonObject get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera del rango válido: " + index);
        }
        return super.get(index);
    }
    
}
