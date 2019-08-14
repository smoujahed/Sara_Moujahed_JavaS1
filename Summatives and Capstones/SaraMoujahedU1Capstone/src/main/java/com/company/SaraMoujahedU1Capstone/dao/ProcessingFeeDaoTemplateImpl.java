package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.ProcessingFee;
import com.company.SaraMoujahedU1Capstone.model.SalesTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class ProcessingFeeDaoTemplateImpl implements ProcessingFeeDao {

    private JdbcTemplate jdbcTemplate;

    public static final String SELECT_FEE_BY_TYPE =
            "select * from processing_fee where product_type = ?";

    @Autowired
    public ProcessingFeeDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee getProcessingFeeByType(String productType) {
        try {
            return jdbcTemplate.queryForObject(SELECT_FEE_BY_TYPE, this::mapToFee, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private ProcessingFee mapToFee(ResultSet resultSet, int i) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(resultSet.getString("product_type"));
        processingFee.setFee(resultSet.getBigDecimal("fee"));
        return processingFee;
    }


}
