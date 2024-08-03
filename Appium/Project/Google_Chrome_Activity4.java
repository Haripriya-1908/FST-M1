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

public class Google_Chrome_Activity4 {
	
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
    // Test method
    @Test
    public void chromeTest() {
    	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
    	// Wait for page to load
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
        
        // Scroll using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(5)"));
        
        driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"To-Do List  Elements get added at run time \"]\r\n"
        		+ "")).click();
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"To-Do List\"]")));
        //add Add tasks to list
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]\r\n"
        		+ "")).click();
        
        //add Get number of tasks
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]\r\n"
        		+ "")).click();
        
        // add Clear the list task
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]\r\n"
        		+ "")).click();
        
        // Find all the image elements on the page
        List<WebElement> TaskList = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]"));
     // Print the number of images
        System.out.println("Before clear: " + TaskList.size());
        
        //Click on each of the tasks added to strike them out.
        driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Add tasks to list\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Get number of tasks\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Clear the list\"]")).click();
      
        //Finally, clear the list.
        driver.findElement(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]")).click();
        
        // Find all the image elements on the page
        List<WebElement> TaskListafterclear = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]"));
     // Print the number of images
        System.out.println("After clear: " + TaskListafterclear.size());
        
        if(TaskListafterclear.size()== 0) {
        	System.out.println("Test is passed");
        	
        	Assert.assertTrue(true, "Test is passed");
        }
        else
        {
        
        	Assert.assertFalse(true, "Test is fail");
        }
    }
    
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }


}
