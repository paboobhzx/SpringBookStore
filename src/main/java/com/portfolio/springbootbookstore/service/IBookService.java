package com.portfolio.springbootbookstore.service;

import com.portfolio.springbootbookstore.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
