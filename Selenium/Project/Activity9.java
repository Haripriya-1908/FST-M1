package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9 {
	
	WebDriver driver;	
	WebDriverWait wait;
	  @BeforeClass
	    public void beforeClass() {
	        // Set up the Firefox driver
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	     // Initialize wait object
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        //Open browser
	        driver.get("https://alchemy.hguy.co/lms/");
	    }
	  @Test
	    public void Verify_Lesson_Completed() {
		  //Login to application
		  driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();
		  String title = driver.getTitle();
		  System.out.println("Title of the front Page is : " +  title);
		  driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click(); 
		  driver.findElement(By.id("user_login")).sendKeys("root");
		  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		  driver.findElement(By.id("wp-submit")).click();
		  
		  //Select the menu item that says “All Courses” and click it.
		  driver.findElement(By.xpath("//*[contains(text(),'All Courses')]")).click();
		  String Page_title = driver.getTitle();
		  System.out.println("Title of the All Courses Page is : " + Page_title);
		  //Select any course and open it.
		  driver.findElement(By.xpath("//article[@id='post-69']/div[2]/p[2]/a[1]")).click();
		  //Select Developing Strategy from course
		  driver.findElement(By.xpath("//div[contains(text(),' Developing Strategy ')]")).click();
		  String Course_title = driver.getTitle();
		  System.out.println("Title of the course is : " + Course_title);  
		  //Select Lesson from Developing Strategy course
		  driver.findElement(By.xpath("//span[contains(text(),'This is the First Topic')]")).click();
		  String Lesson_title = driver.getTitle();
		  System.out.println("Title of the Lesson is : " + Lesson_title);  
		
	  }
	  
	  
	  
	  @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }

}
