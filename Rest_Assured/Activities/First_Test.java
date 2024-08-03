package examples;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class First_Test {
	
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
  @Test
  public void getRequestWithQueryParam() {
	 Response response = 
			 given().baseUri("https://petstore.swagger.io/v2/pet").
			 header("Content-Type", "application/json").
			 queryParam("status", "alive").when().get("/findByStatus");	
	         
	   //Print response headers
	 System.out.println(response.getHeaders());
	 //Print response body 
	 System.out.println(response.getBody().asString());
	 System.out.println("-----------------------------");
	 System.out.println(response.getBody().asPrettyString());
	//extracts properties from response
	 String petStatus = response.then().extract().path("[0].status");
	 //TestNG Assertions
	 Assert.assertEquals(petStatus, "alive");
	 //RestAssured Assertion
	 response.then().statusCode(200).body("[0].status", equalTo("alive"));
	 
  }
//GET https://petstore.swagger.io/v2/pet/{petId}
  @Test
	public void getRequestWithPathParam() {
		
		given().baseUri("https://petstore.swagger.io/v2/pet").
		 header("Content-Type", "application/json").pathParam("petId", 77232).log().all().
		 when().get("/{petId}").then().statusCode(200).body("status", equalTo("alive")).
		 body("name", equalTo("Riley"));
		 
	
	}
}
