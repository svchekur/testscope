package AutomationTest.BrightTalkTest;

import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

/*
Helper class for API operations
 */
public class APIHelper {

    /**
     * Makes API Post Call and returns the response
     * @param requestSpecification Request Specification of Rest-Assured
     * @param dt Data Table(Optional Parameter)
     * @param path API Path
     * @return Response of API call
     */
    public static Response postRequest(RequestSpecification requestSpecification, String path,DataTable... dt ){
        if(dt.length>0)  //To Check optional parameter passed or not
            //dt[0] is the complete DataTable passed
            requestSpecification.body(JSONHelper.generateJSONfromDataTable(dt[0]));
            requestSpecification.header("content-type", "application/json");
        return requestSpecification.post(path);
    }

    /**
     * To call API with GET method
     * @param requestSpecification Request Specification for API
     * @param path PATH for the API Call
     * @return Response of the API call
     */
    public static Response getRequest(RequestSpecification requestSpecification, String path){
        return requestSpecification.when().get(path);
    }

    /**
     * Set Configuration for the Request Specification
     * @param requestSpecification Request Specification
     * @param connectionTimeout Maximum wait time to establish connection
     * @param scoketTimeout Maximum wait time to get response
     * @return Request Specification with Configuration set
     */
    public static RequestSpecification setConfig(RequestSpecification requestSpecification
            , int connectionTimeout, int scoketTimeout){
        RestAssuredConfig restAssuredConfig = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", connectionTimeout)
                        .setParam("http.socket.timeout", scoketTimeout));
        return requestSpecification.config(restAssuredConfig);
    }

    /**
     * Validates the response code
     * @param response Response
     * @param responseCode Expected Response Code
     * @return Validatable Response on matching the expected response code
     */
    public static ValidatableResponse validateResponseCode(Response response,int responseCode){
       return response.then().statusCode(responseCode);
    }

    /**
     * Get the number of objects in an Array
     * @param validatableResponse Validatable Response
     * @param sArrayName Array Name for which user wants to get count
     * @return Number og objects in an Array
     */
    public static int getCountofArray(ValidatableResponse validatableResponse,String sArrayName){
        return validatableResponse
                .extract().response()
                .jsonPath().getList(sArrayName).size();
    }

    /**
     * Validates the value for specific Filed
     * @param validatableResponse Validatable Response
     * @param sFieldName Field Name
     * @param sFiledValue Filed Value as numeric
     */
    public static void assertFieldValue(ValidatableResponse validatableResponse,String sFieldName, int sFiledValue){
        validatableResponse.body(sFieldName,equalTo(sFiledValue));
    }
    /**
     * Validates the value for specific Filed
     * @param validatableResponse Validatable Response
     * @param sFieldName Field Name
     * @param sFiledValue Filed Value as string
     */
    public static void assertFieldValue(ValidatableResponse validatableResponse,String sFieldName, String sFiledValue){
        validatableResponse.body(sFieldName,equalTo(sFiledValue));
    }

    /**
     * Validates All the Values of data table matching with JSON response
     * @param validatableResponse Validatable Response
     * @param dt Data Table with expected Data
     * @param arrayName (Optional) Name of the JSOn array
     */
    public static void assertFieldValuesWithDataTable(ValidatableResponse validatableResponse,
                                                      DataTable dt,String... arrayName ){
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for(String header: list.get(0).keySet())
            Assert.assertEquals(
                    validatableResponse.extract().response()
                            .jsonPath().get(
                            (arrayName.length>0?arrayName[0]+"."+header:header))
                    ,list.get(0).get(header));
    }

    /**
     * Verify specific Key exist in JSON
     * @param validatableResponse Validatable Response
     * @param fieldName Field Name to verify
     */
    public static void verifyFieldNameExist(ValidatableResponse validatableResponse,String fieldName){
        validatableResponse.body("$", hasKey(fieldName));
    }

    /**
     * Verify ALL Keys mentioned in data table exist in JSON
     * @param validatableResponse Validatable Response
     * @param dt Data table with list of Headers to validate
     */
    public static void verifyAllFieldNamesExist(ValidatableResponse validatableResponse,DataTable dt){
        List<String> list = dt.asList(String.class);
        for (String filed:list) {
            verifyFieldNameExist(validatableResponse,filed);
        }
    }

    /**
     * Verify value of specific filed is unique
     * @param validatableResponse  Validatable Response
     * @param sFieldName Field Name for which value is expected to be unique
     * @param sArrayName Array name
     */
     public static void verifyValueOfFieldUnique(ValidatableResponse validatableResponse, String sFieldName,
                                         String sArrayName){
        int numberofRecords = getCountofArray(validatableResponse,"data");
        List<Integer> ids = new ArrayList<Integer>();
        for(int i=0;i<numberofRecords;i++)
            ids.add(Integer.parseInt(validatableResponse.extract().jsonPath()
                    .getMap(sArrayName+"["+i+"]").get(sFieldName).toString()));
        // HashSet helps here to get only DISTINCT values
        Assert.assertEquals(ids.size(),(new HashSet<Integer>(ids)).size(),"User Ids should be unique");
    }
}
