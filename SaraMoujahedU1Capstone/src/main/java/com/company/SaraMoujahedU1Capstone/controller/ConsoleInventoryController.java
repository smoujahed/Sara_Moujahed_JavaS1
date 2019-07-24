package com.company.SaraMoujahedU1Capstone.controller;

import com.company.SaraMoujahedU1Capstone.exception.NotFoundException;
import com.company.SaraMoujahedU1Capstone.service.InvoiceInventoryService;
import com.company.SaraMoujahedU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/console")
public class ConsoleInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel console){
        return inventoryService.saveConsole(console);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId){
        ConsoleViewModel consoleViewModel = inventoryService.findConsole(consoleId);
        if(consoleViewModel == null)
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
        return consoleViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId){
        inventoryService.removeConsole(consoleId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel){
        if(consoleViewModel.getConsoleId() == 0)
            consoleViewModel.setConsoleId(consoleId);
        if(consoleId != consoleViewModel.getConsoleId()){
            throw new IllegalArgumentException("Console ID on path must match the ID in the Console object");
        }
        inventoryService.updateConsole(consoleViewModel);

    }
}
