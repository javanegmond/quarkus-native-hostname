package io.quarkus.reproducer;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() throws UnknownHostException {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from host " + InetAddress.getLocalHost()
                                                      .getHostName()));
    }

}
