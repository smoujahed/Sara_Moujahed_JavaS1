package com.company.SaraMoujahedU1M5Summative.dao;

import com.company.SaraMoujahedU1M5Summative.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_AUTHOR_SQL =
            "insert into author (first_name, last_name, street, city, state, postal_code, phone, email) values (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_AUTHOR_SQL =
            "select * from author where author_id = ?";

    private static final String SELECT_ALL_AUTHOR_SQL =
            "select * from author";

    private static final String UPDATE_AUTHOR_SQL =
            "update author set first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where author_id = ?";

    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id = ?";

    @Autowired
    public AuthorDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL, author.getFirstName(), author.getLastName(), author.getStreet(),
                                                author.getCity(), author.getState(), author.getPostalCode(), author.getPhone(), author.getEmail());
        author.setAuthorID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return author;
    }

    @Override
    public Author getAuthor(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private Author mapRowToAuthor(ResultSet resultSet, int i) throws SQLException {
        Author author = new Author();
        author.setAuthorID(resultSet.getInt("author_id"));
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));
        author.setStreet(resultSet.getString("street"));
        author.setCity(resultSet.getString("city"));
        author.setState(resultSet.getString("state"));
        author.setPostalCode(resultSet.getString("postal_code"));
        author.setPhone(resultSet.getString("phone"));
        author.setEmail(resultSet.getString("email"));
        return author;
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SELECT_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,  author.getFirstName(), author.getLastName(),
                                                author.getStreet(), author.getCity(), author.getState(), author.getPostalCode(),
                                                author.getPhone(), author.getEmail(), author.getAuthorID());

    }

    @Override
    public void deleteAuthor(int id) {
        jdbcTemplate.update(DELETE_AUTHOR_SQL, id);
    }
}
