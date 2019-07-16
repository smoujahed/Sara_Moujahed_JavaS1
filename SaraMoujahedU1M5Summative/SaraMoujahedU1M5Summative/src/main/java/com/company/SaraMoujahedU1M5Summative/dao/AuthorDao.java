package com.company.SaraMoujahedU1M5Summative.dao;

import com.company.SaraMoujahedU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {

    Author addAuthor(Author author);

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int id);
}
