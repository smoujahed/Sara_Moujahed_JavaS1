package com.company.SaraMoujahedU1M5Summative.dao;

import com.company.SaraMoujahedU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_BOOK_SQL =
            "insert into book (isbn, publish_date, author_id, title, publisher_id, price) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";
    private static final String SELECT_BOOK_BY_AUTHOR_SQL =
            "select * from book where author_id = ?";

    private static final String SELECT_ALL_BOOK_SQL =
            "select * from book";

    private static final String UPDATE_BOOK_SQL =
            "update book set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? where book_id = ?";

    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id = ?";

    public static final String DELETE_BOOK_BY_AUTHOR =
            "delete from book where author_id = ?";

    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL, book.getIsbn(), book.getPublishDate(), book.getAuthorID(), book.getTitle(),
                book.getPublisherID(), book.getPrice());
            book.setBookID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return book;
    }

    @Override
    public Book getBook(int bookID) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, bookID);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOK_SQL, this::mapRowToBook);
    }

    @Override
    public Book getBookByAuthor(int authorID){
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_BY_AUTHOR_SQL, this::mapRowToBook, authorID);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL, book.getBookID(), book.getIsbn(), book.getPublishDate(), book.getAuthorID(),
                book.getTitle(), book.getPublisherID(), book.getPrice());

    }

    @Override
    public void deleteBook(int bookID) {
        jdbcTemplate.update(DELETE_BOOK_SQL, bookID);

    }
    @Override
    public void deleteBookByAuthor(int authorID){
        jdbcTemplate.update(DELETE_BOOK_BY_AUTHOR, authorID);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookID(rs.getInt("book_id"));
        book.setPublishDate(rs.getString("publish_date"));
        book.setAuthorID(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherID(rs.getInt("publisher_id"));
        book.setPrice(rs.getDouble("price"));

        return book;
    }
}
