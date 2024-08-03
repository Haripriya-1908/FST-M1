package examples;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

public class SpecificationTest {
	RequestSpecification  RequestSpec;
	ResponseSpecification  ResponseSpec;
	int petId;
	
  @BeforeClass 
  public void setUp() {
	  //Request Specification 
	  RequestSpec = new RequestSpecBuilder().
			  setBaseUri("https://petstore.swagger.io/v2/pet").
			  addHeader("Content-Type", "application/json").
			  build();
		
	  //Response Specification		  
	  ResponseSpec =  new ResponseSpecBuilder().
			  expectStatusCode(200).
			  expectResponseTime(lessThanOrEqualTo(3000L)).
			  build();
			 
  }
  //POST https://petstore.swagger.io/v2/pet
  @Test(priority = 1)
  public void postRequest() {
	  //Create Post Body
	  Map<String,Object> reqbody = new HashMap<String,Object>();
	  reqbody.put("id", "10823");
	  reqbody.put("name", "Google");
	  reqbody.put("status", "alive");
	  
	  Response response = 
				 given().spec(RequestSpec).body(reqbody).when().post();
	  //Extract the pet id
	  petId = response.then().extract().path("id");
	  //Assertion
	  response.then().spec(ResponseSpec).body("status", equalTo("alive"));
				 
  }
  //GET https://petstore.swagger.io/v2/pet/{petId}
  @Test(priority = 2)
  public void getRequest() {
  //send request, get response , assert response
	  given().spec(RequestSpec).pathParam("petId", petId).log().all()
	  .when().get("/{petId}").then().spec(ResponseSpec).body("status", equalTo("alive"));
	  
	  
  }
  //DELETE https://petstore.swagger.io/v2/pet/{petId}
  @Test(priority = 3)
  public void deleteRequest() {
	//send request, get response , assert response
	  given().spec(RequestSpec).pathParam("petId", petId).when().delete("/{petId}").
	  then().spec(ResponseSpec).body("message", equalTo(""+petId));
  }
  }

