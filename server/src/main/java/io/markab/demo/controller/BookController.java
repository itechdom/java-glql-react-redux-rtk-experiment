package io.markab.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import io.markab.demo.model.Author;
import io.markab.demo.model.Book;
import io.markab.demo.model.Counter;
import io.markab.demo.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.bookById(id);
    }

    @QueryMapping
    public Counter counterById(@Argument String name) {
        return new Counter("count test");
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }

    @SchemaMapping
    // you have to speicify the parent here (Book)
    public Counter totalCount(Book book) {
        return new Counter("name");
    }
}