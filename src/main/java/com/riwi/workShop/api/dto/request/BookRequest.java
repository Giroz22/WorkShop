package com.riwi.workShop.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookRequest {
    @NotBlank(message = "El atributo no puede ser vacio")
    private String title;
    @NotBlank(message = "El atributo no puede ser vacio")
    private String author;
    private String publicationYear;
    private String genre;

    @NotBlank(message = "El atributo no puede ser vacio")
    private String isbn;
}
