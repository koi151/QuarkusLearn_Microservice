package org.koi151.entity;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import lombok.ToString;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Several ISBN formats")
@ToString
public class IsbnNumbers {

    @Schema(required = true)
    @JsonbProperty("isbn_10")
    public String isbn10;

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    public String isbn13;

    @JsonbTransient
    public Instant generationDate;
}