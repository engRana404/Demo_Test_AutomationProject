package com.swagLabs.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.jayway.jsonpath.JsonPath;

import java.io.FileReader;

public class JsonUtils {
    private static final String JSON_FILE_PATH = "src/test/resources/";
    String jsonReader;
    String jsonFileName;
    public JsonUtils(String jsonFileName){
        this.jsonFileName = jsonFileName;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(JSON_FILE_PATH + jsonFileName + ".json"));
            jsonReader = data.toJSONString();
        } catch (Exception e) {
            LogsUtil.error("Failed to read JSON file: " + jsonFileName + " - " + e.getMessage());
            jsonReader = "{}"; // Default to empty JSON object on error
        }
    }
    public String getJsonData(String jsonPath) {
        String testData = "";
        try{
            testData = JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            LogsUtil.error("Failed to read JSON data from path: " + jsonPath + " - " + e.getMessage());
        }
        return testData;
    }

}
