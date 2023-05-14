package com.sabarish.projects.RESTSpringLibrary;

import com.sabarish.projects.RESTSpringLibrary.Domain.Book;
import com.sabarish.projects.RESTSpringLibrary.Domain.BooksEntity;

public final class TestDataValues {
    private TestDataValues()
    {

    }

    public static Book testBook()
    {
        return Book.builder()
                .isbn("1234567")
                .name("Two States")
                .author("Chetan Bhagat")
                .build();
    }

    public static BooksEntity testBookEntity()
    {
        return BooksEntity.builder()
                .isbn("1234567")
                .name("Two States")
                .author("Chetan Bhagat")
                .build();
    }
}
