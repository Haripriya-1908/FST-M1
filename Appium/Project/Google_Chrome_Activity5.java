package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Google_Chrome_Activity5 {
	// Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;
 
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
 
        // Server Address
        URL serverURL = new URL("http://localhost:4723/");
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        // Open the page in Chrome
        driver.get("https://v1.training-support.net/selenium");
    }
    
    @Test
    public void chromeTest() {
    	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
    	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(14)"));
    	 driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form  Please sign in. \"]")).click();
    	 
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Login Form\"]")));
    	////Enter valid credential
    	 driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]\r\n"
    	 		+ "")).sendKeys("admin");
    	 driver.findElement(AppiumBy.xpath("	\r\n"
    	 		+ "//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	 
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")));
    	 String SucessMsg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
    	 
    	// Assertion
         Assert.assertEquals(SucessMsg, "Welcome Back, admin");
         
       //Enter invalid credential
         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]\r\n"
     	 		+ "")).clear();
         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]\r\n"
     	 		+ "")).sendKeys("admin_user");
         
         
         driver.findElement(AppiumBy.xpath("	\r\n"
     	 		+ "//android.widget.EditText[@resource-id=\"password\"]")).clear();
         driver.findElement(AppiumBy.xpath("	\r\n"
     	 		+ "//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password123");
         driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")));
         String ErrorMsg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]\r\n"
         		+ "")).getText();
         
         
      // Assertion
         Assert.assertEquals(ErrorMsg, "Invalid Credentials");
         
    	 
    }
    
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}
