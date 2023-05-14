package com.sabarish.projects.RESTSpringLibrary.Service;

import com.sabarish.projects.RESTSpringLibrary.Domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {
    //save book
    Book saveBook(Book book);

    //find if book exists
    boolean isBookExists(String isbn);

    //get Books
    List<Book> listBooks();

    //get specific book
    Optional<Book> findBookByID(String isbn);

    //delete book
    void deleteBook(String isbn);
}
