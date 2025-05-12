package org.koi151.quarkus.microservices;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BookControllerTest {

    @Test
    public void shouldCreateABook() {
        given()
            .formParam("title", "Book Title")
            .formParam("author", "Hababon")
            .formParam("year", 2003)
            .formParam("genre", "IT").
        when()
            .post("/api/books").
        then()
            .statusCode(201)
            .body("isbn_13", startsWith("13-"))
            .body("title", is("Book Title"))
            .body("author", is("Hababon"))
            .body("year_of_publication", is(2003))
            .body("genre", is("IT"))
            .body("creation_date", startsWith("20"));
    }

}