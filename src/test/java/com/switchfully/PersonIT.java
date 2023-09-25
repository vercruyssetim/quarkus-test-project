package com.switchfully;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
public class PersonIT {

    @Test
    void name() {
        PersonDTO[] persons = given()
                .when()
                .get("/persons")
                .then()
                .statusCode(200)
                .extract().as(PersonDTO[].class);

        Assertions.assertThat(persons).contains(new PersonDTO(1, "The Eiffel Tower", "MONUMENT"));
    }
}
