package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoTemplateImpl implements GameDao {

    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_GAME_SQL =
            "insert into game (title, esrb_rating, description, price, studio, quantity) values (?,?,?,?,?,?)";

    public static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    public static final String SELECT_GAME_BY_STUDIO_SQL =
            "select * from game where studio = ?";

    public static final String SELECT_GAME_BY_RATING =
            "select * from game where esrb_rating = ?";

    public static final String SELECT_GAME_BY_TITLE =
            "select * from game where title = ?";

    public static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    public static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    public static final String DELETE_GAME_SQL =
            "delete from game where game_id = ?";

    @Autowired
    public GameDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
         jdbcTemplate.update(
                INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity()
                );
         game.setGameId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
         return game;
    }

    @Override
    public Game getGame(int gameId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, gameId);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<Game> getGamesByStudio(String studio) {
            return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio);

    }

    @Override
    public List<Game> getGamesByRating(String rating) {
        return jdbcTemplate.query(SELECT_GAME_BY_RATING, this::mapRowToGame, rating);

    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE, this::mapRowToGame, title);

    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);

    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId());

    }

    @Override
    public void deleteGame(int gameId) {
        jdbcTemplate.update(DELETE_GAME_SQL, gameId);

    }

    private Game mapRowToGame(ResultSet resultSet, int i) throws SQLException {
        Game game = new Game();
        game.setGameId(resultSet.getInt("game_id"));
        game.setTitle(resultSet.getString("title"));
        game.setEsrbRating(resultSet.getString("esrb_rating"));
        game.setDescription(resultSet.getString("description"));
        game.setPrice(resultSet.getBigDecimal("price"));
        game.setStudio(resultSet.getString("studio"));
        game.setQuantity(resultSet.getInt("quantity"));

        return game;
    }
}
