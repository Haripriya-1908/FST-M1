package project;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Activity8 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");

	}

	@Test
	public void Contact_us_and_complete_form() {
		driver.findElement(By.xpath("//*[contains(text(),'Contact')]")).click();
		String Page_title = driver.getTitle();
		System.out.println("Title of the Page is : " + Page_title);
		driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Nitish Srivastava");
		driver.findElement(By.id("wpforms-8-field_1")).sendKeys("nitish@sky.com");
		driver.findElement(By.id("wpforms-8-field_3")).sendKeys("TestNG");
		driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Hello World!!");
		driver.findElement(By.id("wpforms-submit-8")).click();
		String Display_message = driver.findElement(By.id("wpforms-confirmation-8")).getText();
		System.out.println("Message after submission : " + Display_message);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}