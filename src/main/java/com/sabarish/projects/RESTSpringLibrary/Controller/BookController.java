package com.sabarish.projects.RESTSpringLibrary.Controller;

import com.sabarish.projects.RESTSpringLibrary.Domain.Book;
import com.sabarish.projects.RESTSpringLibrary.Domain.BooksEntity;
import com.sabarish.projects.RESTSpringLibrary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    // @PutMapping = @RequestMapping(method= RequestMethod.PUT)
    @PutMapping("books/{isbn}")
     public ResponseEntity<Book> createBook(@PathVariable final String isbn, @RequestBody Book book)
    {
        book.setIsbn(isbn);
        boolean isBookExists = bookService.isBookExists(isbn);
        Book savedBook = bookService.saveBook(book);

        //update is happening here as book is already exisiting. So response is 200
        if(isBookExists)
        {
            return  new ResponseEntity<>(savedBook, HttpStatus.OK);

        }
        else
            return new ResponseEntity<>(savedBook,HttpStatus.CREATED);

    }

    // get book details from isbn
    @GetMapping("books/{isbn}")
    public ResponseEntity<Book> retrieveBook(@PathVariable final String isbn)
    {
        final var retrievedBookList = bookService.findBookByID(isbn);
        return retrievedBookList.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    //get all books
    @GetMapping("books")
    public ResponseEntity<List<Book>> retrieveAllBooks()
    {
        List<Book> bookList = bookService.listBooks();
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }

    @DeleteMapping("books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable final String isbn)
    {
        bookService.deleteBook(isbn);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
