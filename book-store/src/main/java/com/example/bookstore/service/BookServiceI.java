package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.exception.BookNotFoundException;

import java.util.List;

public interface BookServiceI {
    BookDto addBook(BookDto newBook);
    BookDto findBookById(Integer id) throws BookNotFoundException;
    List<BookDto> getBooks();
    BookDto modifyBook(Integer id, BookDto newBook);
    void removeBook(Integer id) throws BookNotFoundException;
    List<BookDto> findBookByTitle(String bookTitle) throws BookNotFoundException;
}
