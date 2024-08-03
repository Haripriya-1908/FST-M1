package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	
	WebDriver driver;	
	  @BeforeClass
	    public void beforeClass() {
	        // Set up the Firefox driver
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	 
	        //Open browser
	        driver.get("https://alchemy.hguy.co/lms/");
	        
	    }
	  
	  @Test
	    public void My_Account_and_Login_Page()
      {
		
		  driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();
		  String Page_title = driver.getTitle();
		  System.out.println("Title of the Page is : " + Page_title);
		  driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click(); 
		  driver.findElement(By.id("user_login")).sendKeys("root");
		  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		  driver.findElement(By.id("wp-submit")).click();
		  String Display_Username =  driver.findElement(By.className("display-name")).getText();
		  Assert.assertEquals("root", Display_Username );
      }

	  @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
