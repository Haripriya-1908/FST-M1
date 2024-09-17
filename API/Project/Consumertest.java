package Project;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    // Create Map for the headers
    Map<String, String> headers = new HashMap<>();

    @Pact(consumer = "UserConsumer",provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
// Add headers
        headers.put("Content-Type", "application/json");
//Set request ad response
        DslPart requestResponseBody = new PactDslJsonBody().
                numberType("id", 1111).
                stringType("firstName", "hari")
                .stringType("lastName", "priya")
                .stringType("email", "haripriya@example.com");
//Create Contract
        return builder.given("POST Request").
                uponReceiving("request to create").
                method("POST").
                path("/api/users").
                headers(headers)
                .body(requestResponseBody).
                willRespondWith().
                status(201).body(requestResponseBody).
                toPact();
    }
@Test
        @PactTestFor(providerName = "UserProvider",port = "8282")
public void consumerTest() {
    Map<String, Object> reqBody =new HashMap<>();
        reqBody.put("id", 1111);
        reqBody.put("firstName", "hari");
        reqBody.put("lastName", "priya");
        reqBody.put("email", "haripriya@example.com");

        //Post request
        given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all().
                when().post().
                then().statusCode(201).body("email",equalTo("seema@example.com")).log().all();


    }

}