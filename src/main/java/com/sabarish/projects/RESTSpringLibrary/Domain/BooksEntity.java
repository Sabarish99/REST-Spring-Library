package com.sabarish.projects.RESTSpringLibrary.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="books")
public class BooksEntity {
    @Id
   private String isbn;
    @Column
   private String name;
    @Column(name = "Author")
   private String author;

}
