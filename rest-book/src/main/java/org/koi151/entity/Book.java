package org.koi151.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Builder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Builder
public class Book {
    @JsonbProperty("isbn_13")
    public String isbn13;
    public String title;
    public String author;
    public String genre;

    @JsonbProperty("year_of_publication")
    public int yearOfPublication;

    @JsonbDateFormat("yyyy-MM-dd")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;
}
