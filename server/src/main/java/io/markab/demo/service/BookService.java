package io.markab.demo.service;
import org.springframework.stereotype.Component;
import io.markab.demo.model.Book;

@Component
public class BookService {
    public Book bookById(String id) {
        return Book.getById(id);
    }
}
