package activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

	AndroidDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
		options.noReset();
		
		URL serverUrl = new URL("http://localhost:4723/");
		
		driver = new AndroidDriver(serverUrl, options);
	} 
	// Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_4")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
 
        // Assertion
        Assert.assertEquals(result, "20");
    }
 
    @Test
    public void multiplyTestLocators() {
        // Perform the calculation
     
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@resource-id, 'digit5') AND (@text = '5')]")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_4")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
 
        // Assertion
        Assert.assertEquals(result, "20");
    }
    
    @Test
    public void listElements() {
        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            AppiumBy.className("android.webkit.WebView")
        ));
 
        // Find all text elements on the page
        List<WebElement> textItems = driver.findElements(
            AppiumBy.xpath("//android.view.View/android.widget.Button")
        );
        System.out.println(textItems.size());
        for (WebElement textItem : textItems) {
            System.out.println(textItem.getText());
        }
    }
 
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}