package project;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity2 {
	// Declare the WebDriver object
    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }
    
    @Test
    public void Test1() {
    	 // Check the title of the page
        String title = driver.getTitle();  
        
        //Print the title of the page
        System.out.println("The title of the browser is " + driver.getTitle());
        
        //Get the heading of the page
        WebElement heading = driver.findElement(By.xpath("//h1[contains(@class,'uagb-ifb-title')]"));
        
        //Verify the heading text
        String headingText = heading.getText();
        System.out.println("Header Text is : "  + headingText);
        
        if (headingText.equals("Learn from Industry Experts"))
        {
       //Pass
            System.out.println("Page title contains \"Learn from Industry Experts\" ");
        }
        
        
            	        
    }
            @AfterClass   
        	public void afterClass() {
          
            driver.quit();
        
    }
    
}

 