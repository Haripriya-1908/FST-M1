package liveProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RESTAssured_GitHub_Project_Test {
	RequestSpecification  RequestSpec;
	ResponseSpecification  ResponseSpec;
	String SSH_Key = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIMOhGU08wXz/iEKcOzNhzu/DtgRBAfldOSsgqWaeKsyZ azuread\\ratikajain@IBM-PF2M0265";
    int SSH_Key_id ;

	@BeforeClass 
	  public void setUp() {
		  //Request Specification 
		  RequestSpec = new RequestSpecBuilder().
				  setBaseUri("https://api.github.com").
				  addHeader("Content-Type", "application/json")
				  .addHeader("Authorization", "token xxx")
				  .build();
		  
		  //Response Specification		  
		  ResponseSpec =  new ResponseSpecBuilder().
				  expectStatusCode(200).
				  expectResponseTime(lessThanOrEqualTo(3000L)).
				  build();
	      
}
	  //POST https://api.github.com/user/keys
	  @Test(priority = 1)
	  public void postRequest() {
		  //Create Post Body
		  Map<String,Object> reqbody = new HashMap<String,Object>();
		  reqbody.put("title", "TestAPIKey");
		  reqbody.put("key", SSH_Key);
		  
		  Response response = 
					 given().spec(RequestSpec).body(reqbody).when().post("/user/keys");
		  
		  response.prettyPrint();
		  
		  SSH_Key_id  = response.then().extract().path("id");
		  int resopnse_code = response.getStatusCode();
		  //Assertion
		  Assert.assertEquals(resopnse_code , 201 );
		  
					 
	  }
	  //GET https://api.github.com/user/keys/{keyId} 
	  @Test(priority = 2)
	  public void getRequest() {
	  //send request, get response , assert response
		  Response response = given().spec(RequestSpec).pathParam("keyId", SSH_Key_id).log().all()
		  .when().get("/user/keys/{keyId}");
		  Reporter.log(response.prettyPrint());
		  int resopnse_code = response.getStatusCode();
		  Assert.assertEquals(resopnse_code , 200);
		  
	  }
	  //DELETE https://api.github.com/user/keys/{keyId}
	  @Test(priority = 3)
	  public void deleteRequest() {
		//send request, get response , assert response
		  Response response = given().spec(RequestSpec).pathParam("keyId", SSH_Key_id).when().delete("/user/keys/{keyId}");
		  Reporter.log(response.prettyPrint());
		  int resopnse_code = response.getStatusCode();
		  Assert.assertEquals(resopnse_code , 204);
		  
	  }
	
}
