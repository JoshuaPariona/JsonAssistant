package JsonObjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import JsonObjects.JsonValues.JsonDict;
import JsonObjects.JsonValues.JsonObject;

public class JsonFile {
    private String path;
    private String content = "";
    //private boolean ready = false;
    private File file;
    private JsonObject root; //could be Dict or Array

    //-------------------------Private----------------------------------------
    private JsonFile(String path) {
        this.path = path;
        this.file = new File(path);
    }

    private boolean load() {
        char r = content.charAt(0);
        if (r == '{') {
            root = new JsonDict();
        }
            //root is dict & property expected
        else if (r == '[') {

        }
            //root is array & json object is expected
        else
            return false;
        return true;
    }

    private boolean read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            content = jsonContent.toString();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //-------------------------public-----------------------------------------
    
    public void init() {
        if (!read())
            throw new IllegalStateException("The json file is in a used state or is no longer reachable");
        if (!load())
            throw new IllegalArgumentException("The json file is not in the correct format");
    }

    //-------------------------methods----------------------------------------
    
    public JsonObject getRoot() {
        return root;
    }

    public String getPath() {
        return path;
    }

    //--------------------------static----------------------------------------
    
    private static boolean isJson(File file) {
        String name = file.getPath();
        int pIdx = name.lastIndexOf(".");
        if (pIdx > 0 && pIdx < name.length() - 1)
            if (name.substring(pIdx + 1).equals("json"))
                return true;
        return false;
    }
    
    private static boolean isGood(File file) {
        try {
            if (file.exists() && file.isFile() && isJson(file) &&
                file.canRead() && file.canWrite()) //logical order for short circuit
                return true;
            else
                return false;
        }
        catch (SecurityException e) {
            return false;
        }
    }

    public static JsonFile getJsonFile(String path) {
        if (path == null)
            throw new NullPointerException("The path to the file cannot be null");
        if (!isGood(new File(path)))
            throw new IllegalStateException("The file is not reachable: does not exist, is not a json file, or does not have sufficient permissions");
        return new JsonFile(path);
    }

}