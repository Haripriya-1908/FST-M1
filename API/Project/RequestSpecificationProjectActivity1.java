package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class GitHubProjectTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int keyId;
    String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIG6HH7nLKQY04PNzavo5vf/by0BkuY62L1RUkvqoyLjP";
    @BeforeClass
    public void setUp(){
        //Request Specifications
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user")
                .addHeader("Content-Type","application/json")
                //.setAuth(oauth2("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"))
                .addHeader("Authorization","token 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")
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectBody("key", equalTo(sshkey))
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .build();

    }
    @Test(priority = 1)
    // Post https://api.github.com/user/keys
    public void PostRequest(){
        //create a request body
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("title", "TestKey");
        reqBody.put("key", sshkey);

        //Save the response
        Response response = given().spec(requestSpec).body(reqBody).when().post("/keys");
        keyId = response.then().extract().path("id");
        //Assertions
        response.then().statusCode(201).spec(responseSpec).log().all();//.spec(responseSpec)

    }
    @Test(priority = 2)
    // Get https://api.github.com/user/keys/{keyId}
    public void getRequest(){
        //sent request, get response and assert
        given().spec(requestSpec).pathParam("keyId", keyId).
                when().get("/keys/{keyId}").
                then().spec(responseSpec).statusCode(200);

    }

    @Test(priority = 3)
    // Delete https://api.github.com/user/keys/{keyId}
    public void deleteRequest(){
        //sent request, get response and assert
        given().spec(requestSpec).pathParam("keyId", keyId).
                when().delete("/keys/{keyId}").
                then().statusCode(204);

    }
}