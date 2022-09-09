package com.example.bookstore.service.serviceImpl;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookServiceI {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(BookDto newBook) {
        if (newBook == null) return null;

        Book book = BookDto.getBook(newBook);

        return BookDto.getBookDto(bookRepository.save(book));
    }

    @Override
    public BookDto findBookById(Integer id) throws BookNotFoundException{
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(BookDto::getBookDto).orElseThrow(() -> new BookNotFoundException(id));
    }


    @Override
    public List<BookDto> getBooks() {
        List<Book> bookList = bookRepository.findAll();

        List<BookDto> bookDtoList = new ArrayList<BookDto>();
        bookList.forEach(book -> bookDtoList.add(BookDto.getBookDto(book)));
        return bookDtoList;
    }

    @Override
    public BookDto modifyBook(Integer id, BookDto newBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isEmpty())return null;

        Book book = optionalBook.get();

//        book.setId(newBook.getId());
        book.setTitle(newBook.getTitle());
        book.setNumberOfBooks(newBook.getNumberOfBooks());
        book.setPublication(newBook.getPublication());
        book.setDescription(newBook.getDescription());
        book.setAuthorName(newBook.getAuthorName());

        return BookDto.getBookDto(bookRepository.save(book));
    }

    @Override
    public void removeBook(Integer id) throws BookNotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) throw new BookNotFoundException(id);
        bookRepository.deleteAllById(Collections.singleton(id));
    }


    @Override
    public List<BookDto> findBookByTitle(String bookTitle) throws BookNotFoundException {
        List<Book> bookList = bookRepository.findByTitle(bookTitle);

        if(bookList.isEmpty()) return null;

        List<BookDto> bookDtoList = new ArrayList<BookDto>();
        bookList.forEach(book -> bookDtoList.add(BookDto.getBookDto(book)));
        return bookDtoList;
    }

}
