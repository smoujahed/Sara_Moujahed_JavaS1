package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoTemplateImpl implements TShirtDao {

    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_TSHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?,?,?,?,?)";

    public static final String SELECT_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    public static final String SELECT_TSHIRT_BY_COLOR =
            "select * from t_shirt where color = ?";

    public static final String SELECT_TSHIRT_BY_SIZE =
            "select * from t_shirt where size = ?";

    public static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";

    public static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    public static final String DELETE_TSHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    @Autowired
    public TShirtDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public TShirt addTshirt(TShirt tShirt) {
        jdbcTemplate.update(
                INSERT_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity()
                );
        tShirt.settShirtId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return tShirt;
    }

    @Override
    public TShirt getTshirt(int tShirtId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapToTShirt, tShirtId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<TShirt> getTshirtByColor(String color) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_COLOR, this::mapToTShirt, color);
    }

    @Override
    public List<TShirt> getTshirtBySize(String size) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_SIZE, this::mapToTShirt, size);
    }

    @Override
    public List<TShirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapToTShirt);
    }

    @Override
    public void updateTshirt(TShirt tShirt) {
        jdbcTemplate.update(
                UPDATE_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.gettShirtId()
        );

    }

    @Override
    public void deleteTshirt(int tShirtId) {
        jdbcTemplate.update(DELETE_TSHIRT_SQL, tShirtId);
    }

    private TShirt mapToTShirt(ResultSet resultSet, int i) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(resultSet.getInt("t_shirt_id"));
        tShirt.setSize(resultSet.getString("size"));
        tShirt.setColor(resultSet.getString("color"));
        tShirt.setDescription(resultSet.getString("description"));
        tShirt.setPrice(resultSet.getBigDecimal("price"));
        tShirt.setQuantity(resultSet.getInt("quantity"));

        return tShirt;
    }
}
