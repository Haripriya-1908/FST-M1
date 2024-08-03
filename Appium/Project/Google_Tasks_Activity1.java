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

public class Google_Tasks_Activity1 {
	
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
 
        // Server Address
        URL serverURL = new URL("http://localhost:4723/");
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
    }
    
 // Test method
    @Test
    public void AddTasks() {
       
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.EditText")));
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Complete Activity with Google Tasks");
        //Save the task
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click(); 
        
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.EditText")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        //Save the task
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click(); 
        
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.EditText")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        //Save the task
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click(); 
        
//     // Find all the image elements on the page
//        List<WebElement> taskList = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/tasks_list"));
//        for (WebElement element : taskList) {
//            System.out.println(element.getText());
//        }
        String Task1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Tasks\"]")).getText();
       
        String Task2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Keep\"]\r\n"
        		+ "")).getText();
   
        String Task3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete the second Activity Google Keep\"]")).getText();
        // Assertion
        Assert.assertEquals(Task1, "Complete Activity with Google Tasks");
        Assert.assertEquals(Task2, "Complete Activity with Google Keep");
        Assert.assertEquals(Task3, "Complete the second Activity Google Keep");
        
    }
    
 // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}
