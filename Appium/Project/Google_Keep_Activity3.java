package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Google_Keep_Activity3 {
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
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
 
        // Server Address
        URL serverURL = new URL("http://localhost:4723/");
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
    }
    
 // Test method
    @Test
    public void AddaNote() {
    	
    	 driver.findElement(AppiumBy.accessibilityId("New text note")).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
    	 driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test Note");
    	 driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is first Test Note");
    	
    	 driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
    	 
    	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]\r\n"
    	 		+ "")).click();
    	 
    	 driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
    	 driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
    	// wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
    	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/title\" and @text=\"Reminders\"]\r\n"
    	 		+ "")).click();
    	 
    	 
    	 String Reminder_Note = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
    	 
    	// Assertion
         Assert.assertEquals(Reminder_Note, "Test Note");
    }
    
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }


}
