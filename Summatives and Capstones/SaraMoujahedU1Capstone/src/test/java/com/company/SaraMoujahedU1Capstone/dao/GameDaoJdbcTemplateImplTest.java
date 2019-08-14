package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcTemplateImplTest {
    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception{
        List<Game> games = gameDao.getAllGames();
        for (Game g : games) {
            gameDao.deleteGame(g.getGameId());
        }
    }

    @Test
    public void addGetDeleteGame(){
        Game game = new Game();
        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game1,game);

        gameDao.deleteGame(game.getGameId());
        game1 = gameDao.getGame(game.getGameId());
        assertNull(game1);
    }

    @Test
    public void updateGame(){
        Game game = new Game();
        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);

        game = gameDao.addGame(game);

        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game1,game);
    }

    @Test
    public void getAllGames(){
        Game game = new Game();
        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);

        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);

        gameDao.addGame(game);

        List<Game> games = gameDao.getAllGames();
        assertEquals(2, games.size());
    }
}
