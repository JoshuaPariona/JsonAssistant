import JsonObjects.JsonFile;
import JsonObjects.JsonValues.JsonArray;
import JsonObjects.JsonValues.JsonDict;
import JsonObjects.JsonValues.JsonValue;

public class Main {
    public static void main(String[] args) {
        String path = "test.json";
        JsonFile jf = JsonFile.getJsonFile(path);
        jf.init();
        JsonDict jsO = (JsonDict) jf.getRoot();
        jsO.put("string", new JsonValue<String>("My String"));
        JsonArray jsA = new JsonArray();
        jsA.add(new JsonValue<Long>(12L));
        jsA.add(new JsonValue<String>("Second String"));
        jsO.put("array", jsA);
        System.out.println(jsO);
    }
}
