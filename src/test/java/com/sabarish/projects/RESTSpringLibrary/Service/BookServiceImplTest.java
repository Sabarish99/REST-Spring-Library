package com.sabarish.projects.RESTSpringLibrary.Service;

import com.sabarish.projects.RESTSpringLibrary.Domain.Book;
import com.sabarish.projects.RESTSpringLibrary.Domain.BooksEntity;
import com.sabarish.projects.RESTSpringLibrary.Repository.BookDataRepository;
import static com.sabarish.projects.RESTSpringLibrary.TestDataValues.testBook;
import static com.sabarish.projects.RESTSpringLibrary.TestDataValues.testBookEntity;


import com.sabarish.projects.RESTSpringLibrary.TestDataValues;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static com.sabarish.projects.RESTSpringLibrary.TestDataValues.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {


    @Mock
    private BookDataRepository bookDataRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    // test fo
    @Test
    public void testIfBookIsSaved()
    {
        final Book book = testBook();
        final BooksEntity booksEntity = testBookEntity();

        when(bookDataRepository.save(eq (booksEntity))).thenReturn(booksEntity);
        final Book result = bookService.saveBook(book);

        assertEquals(book, result);

    }


}
