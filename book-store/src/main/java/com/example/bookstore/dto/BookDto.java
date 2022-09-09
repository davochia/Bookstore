package com.example.bookstore.dto;

import com.example.bookstore.model.Book;
import lombok.Data;

import java.util.Date;

@Data
public class BookDto {

    private Integer id;
    private String title;
    private String authorName;
    private String description;
    private Date publication;
    private int numberOfBooks;

    public static Book getBook(BookDto bookDto){
        Book book  = new Book();

        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setAuthorName(bookDto.getAuthorName());
        book.setPublication(bookDto.getPublication());
        book.setNumberOfBooks(bookDto.getNumberOfBooks());

        return book;
    }

    public static BookDto getBookDto(Book book){
        BookDto bookDto  = new BookDto();

        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setDescription(book.getDescription());
        bookDto.setAuthorName(book.getAuthorName());
        bookDto.setPublication(book.getPublication());
        bookDto.setNumberOfBooks(book.getNumberOfBooks());

        return bookDto;
    }
}
