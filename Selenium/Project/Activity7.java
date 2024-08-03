package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://alchemy.hguy.co/lms");
		driver.findElement(By.linkText("All Courses")).click();
		
		List<WebElement> courses = driver.findElements(By.className("attachment-course-thumb"));
		
		System.out.println("Number of courses: " + courses.size());
		
	}

}
