package com.company.SaraMoujahedU1Capstone.controller;

import com.company.SaraMoujahedU1Capstone.exception.NotFoundException;
import com.company.SaraMoujahedU1Capstone.service.InvoiceInventoryService;
import com.company.SaraMoujahedU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/game")
public class GameInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel game) {
        return inventoryService.saveGame(game);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int gameId) {
        GameViewModel gameViewModel = inventoryService.findGame(gameId);
        if (gameViewModel == null)
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        return gameViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        inventoryService.removeGame(gameId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int gameId, @RequestBody @Valid GameViewModel game) {
        if(game.getGameId() == 0)
            game.setGameId(gameId);
        if(gameId != game.getGameId()){
            throw new IllegalArgumentException("Game ID on path must match the ID in the Game object");
        }
        inventoryService.updateGame(game);
    }
}
