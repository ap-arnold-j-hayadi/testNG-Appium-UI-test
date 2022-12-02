package first_test;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.*;


public class BrowserStackTestNGTest {
    public AndroidDriver driver = null;
    public JavascriptExecutor jse;
    @BeforeClass(alwaysRun=true)
    public void setUp() throws Exception {
        System.out.println("Setting Up Test. . . .");
        Driver singleton = Driver.getInstance();
        System.out.println(singleton.getDriver().toString());
        driver = singleton.getDriver();
    }

    @AfterSuite(alwaysRun=true)
    public void tearDown() throws Exception {
        // Invoke driver.quit() to indicate that the test is completed. 
        // Otherwise, it will appear as timed out on BrowserStack.
        System.out.println("Ending Appium session. . . .");
//        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Ending Appium Session . . .\", \"level\": \"info\"}}");
        driver.quit();
    }

    @AfterMethod
    public void closeApp() throws InterruptedException {
//        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"AfterMethod: Closing App . . .\", \"level\": \"info\"}}");
        System.out.println("AfterMethod: Closing App. . . .");
//        driver.wait(5000);
        driver.terminateApp("com.ada.astrapayupdate");
    }

    @BeforeMethod
    public void openApp() throws InterruptedException {
//        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"BeforeMethod: Launching App . . .\", \"level\": \"info\"}}");
        System.out.println("BeforeMethod: Launching App. . . .");
//        driver.wait(5000);
        driver.launchApp();
    }
}
