package JsonObjects.JsonValues;

import java.util.HashMap;

public class JsonDict extends HashMap<String,JsonObject> implements JsonObject{

    @Override
    public Object getValue() {
        return this;
    }
    
}
