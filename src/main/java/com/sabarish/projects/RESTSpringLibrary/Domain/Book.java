package com.sabarish.projects.RESTSpringLibrary.Domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// this class to interact with Service layer, keeping the original BookEntity (Persistence) intact.
@Entity
public class Book {
    @Id
    private String isbn;
    private String name;
    @Column(name = "Author")
    private String author;
}
