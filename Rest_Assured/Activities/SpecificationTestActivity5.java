package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    int petId;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2/pet").
                addHeader("Content-Type","application/json").
                build();

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThanOrEqualTo(4000L)).
                expectBody("status", equalTo("alive")).
                build();

    }

    @Test(priority = 1)
    public void postRequestTest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id",77232);
        reqBody.put("name","Riley");
        reqBody.put("status","alive");

        Response response = given().spec(requestSpec).body(reqBody).when().post();

        // Extract petId
        petId= response.then().extract().path("id");

        // assertions
        response.then().spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest(){
        given().spec(requestSpec).pathParam("petId",petId).log().all().
                when().get("/{petId}").
                then().spec(responseSpec).log().all();
    }

    @Test(priority = 3)
    public void deleteRequestTest(){
        given().spec(requestSpec).pathParam("petId",petId).log().all().
                when().delete("/{petId}").
                then().statusCode(200).body("message", equalTo(""+petId)).log().all();
    }

}
