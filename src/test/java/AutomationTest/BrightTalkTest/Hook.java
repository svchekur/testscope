package AutomationTest.BrightTalkTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

public class Hook extends BasePage {

    BrowserSetup browsersetup = new BrowserSetup();
    private static final int WAIT_SEC = 20;

    /**
     * Executed before each UI tagged scenario
     */
    @Before("@UI")
    public void initializeTest() {
        browsersetup.selectBrowser();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(WAIT_SEC, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAIT_SEC, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WAIT_SEC, TimeUnit.SECONDS);
        new iniClass();
    }

    /**
     * Executed after each UI tagged scenario
     */
    @After("@UI")
    public void screenshot(Scenario scenario) {
        String screenShotFilename = scenario.getName().replace(" ","")
                + new Timestamp(new Date().getTime()).toString().replaceAll("[^a-zA-Z0-9]","")
                +"_"+getproperty("Browser")+".jpg";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,new File(getproperty("ScreenshotLocation")+screenShotFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
        //Handling the NoSuchSessionException with Firefox browser after close
        try {
            driver.quit();
        }
        catch(NoSuchSessionException ex){}
    }

    /**
     * Executed before each API tagged scenario
     */
    @Before("@API")
    public void initializeTestAPI() {
        RestAssured.baseURI =getproperty("APIBasePath");
    }

    /**
     * Executed after each API tagged scenario
     */
    @After("@API")
    public void afterScenario() {
    }
}

