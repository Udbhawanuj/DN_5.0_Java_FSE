package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("BookService received BookRepository using setter injection.");
        bookRepository.saveBook(bookName);
        System.out.println("Book added successfully.");
    }
}
