package com.switchfully;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
public class PersonIT {

    @Test
    void name() {
        ResponseBodyExtractionOptions body = given()
                .when()
                .get("/persons")
                .then()
                .statusCode(200)
                .extract().body();

        System.out.println(Arrays.toString(body.as(PersonDTO[].class)));
    }
}
