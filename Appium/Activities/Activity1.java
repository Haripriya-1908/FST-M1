package Example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    //Declare driver
    AppiumDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
                options.setAutomationName("UiAutomator2");
                options.setAppPackage("com.android.calculator2");
                options.setAppActivity(".Calculator");
                options.noReset();

                //Server URL
        URL serverURL =new URL("http://localhost:4723/wd/hub");
        driver =new AndroidDriver(serverURL,options);

    }
    @Test
    public void additionTest()
    {
        //Find digit 6 and tap
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        //Find plus button and tap
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        //Find digit 9 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        //Click on equals
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        // Assertion to verify if the result matches the expected result
        String result =driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        System.out.println("Result of addition: " + result);
        Assert.assertEquals(result, "15", "Addition result is incorrect.");
    }
    @AfterClass
    public void closeApp()
    {
driver.quit();
    }
}