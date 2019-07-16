package com.company.SaraMoujahedU1M5Summative.dao;

import com.company.SaraMoujahedU1M5Summative.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (name, street, city, state, postal_code, phone, email) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHER_SQL =
            "select * from publisher";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where publisher_id = ?";

    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";

    @Autowired
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(),
                publisher.getState(), publisher.getPostalCode(), publisher.getPhone(), publisher.getEmail());

        publisher.setPublisherID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private Publisher mapRowToPublisher(ResultSet resultSet, int i) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisherID(resultSet.getInt("publisher_id"));
        publisher.setName(resultSet.getString("name"));
        publisher.setStreet(resultSet.getString("street"));
        publisher.setCity(resultSet.getString("city"));
        publisher.setState(resultSet.getString("state"));
        publisher.setPhone(resultSet.getString("phone"));
        publisher.setEmail(resultSet.getString("email"));

        return publisher;
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(),
                publisher.getCity(), publisher.getState(), publisher.getPostalCode(), publisher.getPhone(), publisher.getEmail(), publisher.getPublisherID());

    }

    @Override
    public void deletePublisher(int publisherID) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisherID);
    }
}
