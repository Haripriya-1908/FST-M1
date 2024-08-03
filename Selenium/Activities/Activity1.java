package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Setup the Firefox driver(GeckoDriver)
	    WebDriverManager.firefoxdriver().setup();
	    

	 // Create a new instance of the Firefox driver
	    WebDriver driver = new FirefoxDriver();
	    
	 // Open the browser
	    driver.get("https://v1.training-support.net/");
	    
	  //Verify Page title   
	    System.out.println("Ttilte of the page:"+ driver.getTitle());
	    
	    // Find About Us link using id and click it
        driver.findElement(By.id("about-link")).click();
        // Print the title of the new page
        System.out.println("About page title: " + driver.getTitle());
	    
	 // so it doesn't close too quickly
	    driver.quit();
	}

}
