package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {
			//Declare WebDriver object
	    	static WebDriver driver;
	    	
	    	@BeforeClass
	    	public void beforeMethod(){
	    		// Set up Firefox driver
	            WebDriverManager.firefoxdriver().setup();
	            // Create a new instance of the Firefox driver
	            driver = new FirefoxDriver();
	    		// Open the browser
	    		driver.get("https://alchemy.hguy.co/lms/");
	    	}
	    	
	    	@Test
	    	public void findNavigationBar() {
	    	
	    		//find the my account navigation bar
	    		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
	    		String Title = driver.getTitle();
	    		// Print the title of the new page
	    		System.out.println("My account page title: " + driver.getTitle());
	    		Assert.assertEquals("My Account – Alchemy LMS", Title );
	    	}
			
			  @AfterClass public void afterMethod() {
				  //close the browser
				  driver.quit();
			  } 
}