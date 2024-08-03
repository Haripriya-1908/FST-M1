package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstExample extends BaseClass{
	
	@BeforeAll
	public static void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	
	@Given("^user is on the training website$")
	public void openTSHomePage(){
		
		driver.get("https://v1.training-support.net");
		Assertions.assertEquals("Training Support", driver.getTitle());
	}
	

	@When("^user clicks on the About us link$")
		public void clickAboutLink() {
		driver.findElement(By.id("about-link")).click();
	}
	
	@Then("^the user redirect to About us page$")
	public void verifyAboutPage() {
		Assertions.assertEquals("About Training Support", driver.getTitle());
}
	
	
	
	@AfterAll
	public static void tearDown() {	
		driver.quit();
	}

}
