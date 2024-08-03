package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	
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
	    public void title_of_the_first_info_box()
        {
	    
	       String first_box_title =  driver.findElement(By.xpath("//*[contains(text(),'Actionable Training')]")).getText();
	       System.out.println("Title of first box: " + first_box_title);
	       Assert.assertEquals("Actionable Training", first_box_title);	
	    }
	    
	    @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
	    
	    
	    }
	
	


