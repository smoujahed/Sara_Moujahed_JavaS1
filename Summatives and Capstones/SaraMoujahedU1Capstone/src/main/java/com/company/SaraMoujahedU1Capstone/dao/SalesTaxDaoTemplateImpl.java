package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.SalesTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxDaoTemplateImpl implements SalesTaxDao{

    private JdbcTemplate jdbcTemplate;

    public static final String SELECT_TAX_BY_STATE =
            "select * from sales_tax_rate where state = ?";

    @Autowired
    public SalesTaxDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SalesTax getTaxByState(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TAX_BY_STATE, this::mapRowToTax, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private SalesTax mapRowToTax(ResultSet resultSet, int i) throws SQLException {
        SalesTax salesTax = new SalesTax();
        salesTax.setState(resultSet.getString("state"));
        salesTax.setRate(resultSet.getBigDecimal("rate"));
        return salesTax;
    }
}
