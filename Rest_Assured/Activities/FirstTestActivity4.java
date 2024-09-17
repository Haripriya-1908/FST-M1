package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {

    String baseURI ="https://petstore.swagger.io/v2/pet";
    @Test
    public void getWithQueryParameters()
    {
        Response response =
                given().header("Content-Type","application/json")
                        .queryParam("status","sold").
                        when().get(baseURI + "/findByStatus");

       // System.out.println(response.asString());
        System.out.println(response.asPrettyString());
        System.out.println(response.getHeaders().asList());

        // Extract properties from response
        String petStatus = response.then().extract().path("[1].status");
        System.out.println("Status of pet is : "+petStatus);

        Assert.assertEquals(petStatus,"sold");

        response.then().statusCode(200).body("[1].status", equalTo("sold"));

    }

    @Test
    public void getWithPathParam(){

        given().header("Content-Type","application/json").pathParams("petId","1").log().all().
                when().get(baseURI + "/{petId}").then().statusCode(200).
                body("status", equalTo("available")).log().all();
    }
}

