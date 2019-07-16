package com.company.SaraMoujahedU1M5Summative.dao;

import com.company.SaraMoujahedU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    Book getBookByAuthor(int authorID);

    void deleteBookByAuthor(int authorID);

    void updateBook(Book book);

    void deleteBook(int id);
}
