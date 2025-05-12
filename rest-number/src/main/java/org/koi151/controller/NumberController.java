package org.koi151.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.koi151.entity.IsbnNumbers;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name = "Number REST Endpoint")
public class NumberController {

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Generates book number",
        description = "ISBN 13 and ISBN 10 numbers"
    )
    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.isbn13 = "13-" + new Random().nextInt(100_000_000);
        isbnNumbers.isbn10 = "10-" + new Random().nextInt(100_000);
        isbnNumbers.generationDate = Instant.now();

        logger.info("Number generated: " + isbnNumbers);
        return isbnNumbers;
    }
}
