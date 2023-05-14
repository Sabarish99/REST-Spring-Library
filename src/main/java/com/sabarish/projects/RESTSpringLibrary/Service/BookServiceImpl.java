package com.sabarish.projects.RESTSpringLibrary.Service;

import com.sabarish.projects.RESTSpringLibrary.Domain.Book;
import com.sabarish.projects.RESTSpringLibrary.Domain.BookStatus;
import com.sabarish.projects.RESTSpringLibrary.Domain.BooksEntity;
import com.sabarish.projects.RESTSpringLibrary.Repository.BookDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService{

    private final BookDataRepository bookDataRepository;
    @Autowired
    public BookServiceImpl(BookDataRepository bookDataRepository)
    {
       this.bookDataRepository = bookDataRepository;
    }


    @Override
    public Book saveBook(Book book) {
        BooksEntity booksEntity = BookTOBookEntity(book);
        bookDataRepository.save(booksEntity);
        return  BooksEntityTOBook(booksEntity);
    }

    private BooksEntity BookTOBookEntity(Book book) {
        return BooksEntity.builder().
                isbn(book.getIsbn())
                .name(book.getName())
                .author(book.getAuthor())
                .build();
    }

    private Book BooksEntityTOBook(BooksEntity booksEntity) {
        return Book.builder()
                .isbn(booksEntity.getIsbn())
                .name(booksEntity.getName())
                .author(booksEntity.getAuthor())
                .build();
    }

    @Override
    public boolean isBookExists(String isbn) {
        var isBookPresent = bookDataRepository.existsById(isbn);
        return isBookPresent;
    }

    @Override
    public List<Book> listBooks() {
        var bookList = bookDataRepository.findAll()
                                .stream()
                                .map(this::BooksEntityTOBook).toList();
        return bookList;
    }

    @Override
    public Optional<Book> findBookByID(String isbn) {
       var bookByID = bookDataRepository.findById(isbn);
       //return bookByID.map(booksEntity -> BooksEntityTOBook(booksEntity));
       return bookByID.map(this::BooksEntityTOBook);
    }

    @Override
    public void deleteBook(String isbn) {
        try {
            bookDataRepository.deleteById(isbn);
        }
        catch (final EmptyResultDataAccessException exception)
        {
            log.debug(exception.getMessage());
            log.debug("Attempted to delete invalid book entry!!! ");
        }

    }
}
