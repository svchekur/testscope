package AutomationTest.BrightTalkTest;

import cucumber.api.DataTable;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/*
Helper class for JSON operations
 */
public class JSONHelper {
    /**
     * Converts Data table to JSON in Sting format
     * @param dt DataTable
     * @return JSON in string format
     */
    public static String generateJSONfromDataTable(DataTable dt){
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        JSONObject jsonObject = new JSONObject();
        for(String header: list.get(0).keySet()){
            jsonObject.put(header.toLowerCase(),list.get(0).get(header));
        }
        return jsonObject.toString();
    }


}
