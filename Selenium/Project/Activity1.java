package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://alchemy.hguy.co/lms");
		String title = driver.getTitle();
		System.out.println("The title of the website is: " + title);
		Assert.assertEquals(title, "Alchemy LMS – An LMS Application");

		driver.close();

	}
}
