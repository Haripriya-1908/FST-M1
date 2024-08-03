package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.lang.Thread;

public class Activity4 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Set up the Firefox driver
		WebDriverManager.firefoxdriver().setup();
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void Title() throws InterruptedException {
		Thread.sleep(1000);
		String ActualText = driver.findElement(By.xpath("//*[text()='Email Marketing Strategies']")).getText();

		Assert.assertEquals(ActualText, "Email Marketing Strategies");

	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.quit();
	}

}
