package com.company.SaraMoujahedU1Capstone.controller;

import com.company.SaraMoujahedU1Capstone.exception.NotFoundException;
import com.company.SaraMoujahedU1Capstone.model.TShirt;
import com.company.SaraMoujahedU1Capstone.service.InvoiceInventoryService;
import com.company.SaraMoujahedU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tshirt")
public class TShirtInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel){
        return inventoryService.saveTShirt(tShirtViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") int tshirtId){
        TShirtViewModel tShirtViewModel = inventoryService.findTShirt(tshirtId);
        if(tShirtViewModel == null)
            throw new NotFoundException("TShirt could not be retrieved for id " + tshirtId);
        return tShirtViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tshirtId){
        inventoryService.removeTshirt(tshirtId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int tshirtId, @RequestBody TShirtViewModel tShirtViewModel){
        if(tShirtViewModel.gettShirtId() ==0 )
            tShirtViewModel.settShirtId(tshirtId);
        if(tshirtId != tShirtViewModel.gettShirtId()){
            throw new IllegalArgumentException("TShirt ID on path must match the ID in the TShirt object");
        }
        inventoryService.updateTShirt(tShirtViewModel);
    }
}
