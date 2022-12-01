package com.browserstack.run_first_test;

import java.net.URL;
import java.util.Map;
import java.util.Iterator;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;


public class BrowserStackTestNGTest {
    public AndroidDriver<AndroidElement> driver;
    public JavascriptExecutor jse;
    @BeforeClass(alwaysRun=true)
    public void setUp() throws Exception {
        System.out.println("Setting Up Test. . . .");

        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/com/browserstack/run_first_test/first.conf.json"));

        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONArray envs = (JSONArray) config.get("environments");
        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }
        
        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("username");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("access_key");
        }
        
        String app = System.getenv("BROWSERSTACK_APP_ID");
        if(app != null && !app.isEmpty()) {
          capabilities.setCapability("app", app);
        }

        driver = new AndroidDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
        jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Setting Up Test . . .\", \"level\": \"info\"}}");
        driver.terminateApp("com.ada.astrapayupdate");
    }

    @AfterClass(alwaysRun=true)
    public void tearDown() throws Exception {
        // Invoke driver.quit() to indicate that the test is completed. 
        // Otherwise, it will appear as timed out on BrowserStack.
        System.out.println("Ending Appium session. . . .");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Ending Appium Session . . .\", \"level\": \"info\"}}");
        driver.quit();
    }

    @AfterMethod
    public void closeApp() {
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"AfterMethod: Closing App . . .\", \"level\": \"info\"}}");
        System.out.println("AfterMethod: Closing App. . . .");
        driver.terminateApp("com.ada.astrapayupdate");
    }

    @BeforeMethod
    public void openApp() {
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"BeforeMethod: Launching App . . .\", \"level\": \"info\"}}");
        System.out.println("BeforeMethod: Launching App. . . .");
        driver.launchApp();
    }
}
