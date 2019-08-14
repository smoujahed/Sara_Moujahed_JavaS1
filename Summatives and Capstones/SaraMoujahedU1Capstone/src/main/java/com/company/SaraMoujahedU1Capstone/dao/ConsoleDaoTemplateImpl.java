package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoTemplateImpl implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_CONSOLE_SQL =
            "insert into console (model, manufacturer, memory_amount, processor, price, quantity) values (?,?,?,?,?,?)";

    public static final String SELECT_CONSOLE_SQL =
            "select * from console where console_id = ?";

    public static final String SELECT_CONSOLE_BY_MAN_SQL =
            "select * from console where manufacturer = ?";

    public static final String SELECT_ALL_CONSOLES_SQL =
            "select * from console";

    public static final String UPDATE_CONSOLE_SQL =
            "update console set model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? where console_id = ?";

    public static final String DELETE_CUSTOMER_SQL =
            "delete from console where console_id = ?";

    @Autowired
    public ConsoleDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(
                INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());
        console.setConsoleId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return console;
    }

    @Override
    public Console getConsole(int consoleId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, consoleId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return jdbcTemplate.query(SELECT_CONSOLE_BY_MAN_SQL, this::mapRowToConsole, manufacturer);
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(
                UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getConsoleId());

    }

    @Override
    public void deleteConsole(int consoleId) {
        jdbcTemplate.update(DELETE_CUSTOMER_SQL, consoleId);
    }


    private Console mapRowToConsole(ResultSet resultSet, int i) throws SQLException {
        Console console = new Console();
        console.setConsoleId(resultSet.getInt("console_id"));
        console.setModel(resultSet.getString("model"));
        console.setManufacturer(resultSet.getString("manufacturer"));
        console.setMemoryAmount(resultSet.getString("memory_amount"));
        console.setProcessor(resultSet.getString("processor"));
        console.setPrice(resultSet.getBigDecimal("price"));
        console.setQuantity(resultSet.getInt("quantity"));

        return console;
    }
}