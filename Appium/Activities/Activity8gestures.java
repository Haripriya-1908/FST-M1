package Example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static Example.ActionBase.doSwipe;
public class ActionTest {
    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //Server URL
        URL serverURL =new URL("http://localhost:4723/wd/hub");
        driver =new AndroidDriver(serverURL,options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
//open the URL 
        driver.get("https://v1.training-support.net/selenium/sliders");

    }
    @Test
    public void swipetest()
    {
        //get dimentions of screen
        Dimension dims=driver.manage().window().getSize();
        //wait for page to load
       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar[@resource-id = 'slider']")));

        //Set Start and end point
        Point start=new Point((int) (dims.getWidth() * 0.50),(int) (dims.getHeight() * 0.6));

        Point end=new Point((int) (dims.getWidth() * 0.6),(int) (dims.getHeight() * 0.6));
        //perform swipe slider
        doSwipe(driver,start,end,5000);

        //Get text on page and asset
String volumeLevel = driver.findElement(By.xpath("//android.widget.SeekBar[@resource-id = 'slider']/preceding-sibling::android.view.View")).getText();
        Assert.assertEquals(volumeLevel,"Volume Level: 67%");
    }
    @AfterClass
    public void afterClass()
    {
        //close
        driver.quit();
    }
}