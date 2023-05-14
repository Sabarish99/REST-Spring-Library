package com.sabarish.projects.RESTSpringLibrary.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookStatus {
    private boolean isBookCreated;
    private Book book;
}
