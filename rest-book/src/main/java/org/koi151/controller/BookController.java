package org.koi151.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.koi151.client.NumberProxy;
import org.koi151.entity.Book;

import java.time.Instant;

@Path("/api/books")
@Tag(name = "Book REST endpoint")
public class BookController {

    @Inject
    NumberProxy numberProxy;
    @Inject
    Logger logger;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
        summary = "Creates a Book",
        description = "Creates a Book with an ISBN number"
    )
    public Response createABook(
        @FormParam("title") String title,
        @FormParam("author") String author,
        @FormParam("year") int yearOfPublication,
        @FormParam("genre") String genre
    ) {
        Book book = Book.builder()
            .isbn13(numberProxy.generateIsbnNumbers().isbn13)
            .title(title)
            .author(author)
            .yearOfPublication(yearOfPublication)
            .genre(genre)
            .creationDate(Instant.now())
            .build();
            logger.info("Book created: " + book);
        return Response.status(201).entity(book).build();
    }
}
