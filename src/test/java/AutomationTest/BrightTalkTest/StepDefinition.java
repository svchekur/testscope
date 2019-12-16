package AutomationTest.BrightTalkTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static AutomationTest.BrightTalkTest.HomePage.homePage;
import static AutomationTest.BrightTalkTest.APIHelper.*;

public class StepDefinition {
    private Response response;
    private ValidatableResponse validatableResponse;
    private RequestSpecification requestSpecification;

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        homePage();
    }

    @Given("^I get the default list of users for on 1st page$")
    public void iGetTheDefaultListofusers(){
       requestSpecification = RestAssured.given();
    }
    @When("I get the list of all users")
    public void iGetTheListOfAllUsers(){
        response = getRequest(requestSpecification,"/users/");
    }
    @Then("I should see total users count equals to number of user ids")
    public void iShouldMatchTotalCount(){
        validatableResponse = validateResponseCode(response,200);
        int sNumberOfUsersReturned = getCountofArray(validatableResponse,"data");
        assertFieldValue(validatableResponse,"per_page",sNumberOfUsersReturned);
    }


    @Given("I make a search for user (.*)")
    public void iMakeASearchForUser(String sUserID){
        requestSpecification = RestAssured.given();
        response = getRequest(requestSpecification,"/users/"+sUserID);
    }
    @Then("I should see following user data")
    public void IShouldSeeFollowingUserData(DataTable dt){
        validatableResponse = validateResponseCode(response,200);
        assertFieldValuesWithDataTable(validatableResponse,dt,"data");
    }

    // This has the Same Given I make a search for user with invalid ID
    @Then("I receive error code (.*) in response")
    public void iReceiveErrorCodeInResponse(int responsecode){
        validatableResponse = validateResponseCode(response,responsecode);
    }

    @Given("I create user with following (.*) (.*)")
    public void iCreateUserWithFollowing (String sUsername,String sJob){
        requestSpecification= RestAssured.given();
        JSONObject userinfo = new JSONObject();
        userinfo.put("name",sUsername);
        userinfo.put("job",sJob);
        requestSpecification.body(userinfo.toString());
        response = postRequest(requestSpecification,"/users");
        validatableResponse = validateResponseCode(response,201);
    }

    @Then("response should contain following data")
    public void iReceiveErrorCodeInResponse(DataTable dt){
        verifyAllFieldNamesExist(validatableResponse,dt);
    }

    @Given("I login succesfully with following data")
    public void iLoginSuccesfullyWithFollowingData (DataTable dt){
        requestSpecification = RestAssured.given();
        response = postRequest(requestSpecification,"/login",dt);
        validatableResponse = validateResponseCode(response,200);
        verifyFieldNameExist(validatableResponse,"token");
    }

    @Given("I login unsuccesfully with following data")
    public void iLoginUnsuccesfullyWithFollowingData (DataTable dt){
        requestSpecification = RestAssured.given();
        response = postRequest(requestSpecification,"/login",dt);
        validatableResponse = validateResponseCode(response,400);
        assertFieldValue(validatableResponse,"error","Missing password");
    }

    @Given("^I wait for user list to load$")
    public void iWaitForUserListToLoad(){
        requestSpecification = RestAssured.given();
        requestSpecification = setConfig(requestSpecification,1000,7000);
        response = getRequest(requestSpecification,"/users?delay=5");
    }
    @Then("I should see that every user has a unique id")
    public void iShouldSeeThatEveryUserHasAUniqueID(){
        validatableResponse = validateResponseCode(response,200);
        verifyValueOfFieldUnique(validatableResponse,"id","data");
    }
}
