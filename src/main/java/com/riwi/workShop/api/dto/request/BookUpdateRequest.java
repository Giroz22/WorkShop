package com.riwi.workShop.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookUpdateRequest {
    private String title;
    private String author;
    private String publicationYear;
    private String genre;
    private String isbn;
}
