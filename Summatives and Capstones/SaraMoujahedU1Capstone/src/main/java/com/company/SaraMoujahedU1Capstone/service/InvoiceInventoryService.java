package com.company.SaraMoujahedU1Capstone.service;

import com.company.SaraMoujahedU1Capstone.dao.*;
import com.company.SaraMoujahedU1Capstone.model.*;
import com.company.SaraMoujahedU1Capstone.viewmodel.ConsoleViewModel;
import com.company.SaraMoujahedU1Capstone.viewmodel.GameViewModel;
import com.company.SaraMoujahedU1Capstone.viewmodel.InvoiceViewModel;
import com.company.SaraMoujahedU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class InvoiceInventoryService {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxDao salesTaxDao;

    @Autowired
    public InvoiceInventoryService(ConsoleDao consoleDao, GameDao gameDao, TShirtDao tShirtDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxDao salesTaxDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxDao = salesTaxDao;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());
        invoice = invoiceDao.addInvoice(invoice);
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());

        return invoiceViewModel;

    }

    public void executeBusinessLogic(Invoice invoice, InvoiceViewModel invoiceViewModel){
        invoice.setTax(salesTaxDao.getTaxByState(invoice.getState()).getRate());
        invoice.setProcessingFee(calculateProcessingFee(invoice.getItemType(), invoice.getQuantity()));
        invoice.setSubtotal(calculateSubtotal(invoice.getItemType(), invoiceViewModel));
        invoice.setTotal(calculateTotal(invoice));

        invoiceViewModel.setTax(salesTaxDao.getTaxByState(invoice.getState()).getRate());
        invoiceViewModel.setProcessingFee(calculateProcessingFee(invoice.getItemType(), invoice.getQuantity()));
        invoiceViewModel.setSubtotal(calculateSubtotal(invoice.getItemType(), invoiceViewModel));
        invoiceViewModel.setTotal(calculateTotal(invoice));
        decrementQuantity(invoiceViewModel.getQuantity(), invoiceViewModel.getItemType(), invoiceViewModel.getInvoiceId());
        invoiceDao.updateInvoice(invoice);
    }

    public void updateInvoice(InvoiceViewModel invoiceViewModel){
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());
        invoiceDao.updateInvoice(invoice);
    }


    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if(invoice == null )
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    public void removeInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }



    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel){
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);
        consoleViewModel.setConsoleId(console.getConsoleId());
        return consoleViewModel;
    }

    public void updateConsole (ConsoleViewModel consoleViewModel){
        Console console = new Console();
        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        consoleDao.updateConsole(console);
    }

    public ConsoleViewModel findConsole(int id){
        Console console = consoleDao.getConsole(id);
        if(console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public void removeConsole(int id){
        consoleDao.deleteConsole(id);
    }

    public GameViewModel saveGame(GameViewModel gameViewModel){
        Game game  = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        game = gameDao.addGame(game);
        gameViewModel.setGameId(game.getGameId());
        return gameViewModel;
    }
    public void updateGame(GameViewModel gameViewModel){
        Game game = new Game();
        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        gameDao.updateGame(game);

    }

    public GameViewModel findGame(int id){
        Game game = gameDao.getGame(id);
        if(game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void removeGame(int id){
        gameDao.deleteGame(id);
    }

    public TShirtViewModel saveTShirt(TShirtViewModel tShirtViewModel){
        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirt = tShirtDao.addTshirt(tShirt);
        tShirtViewModel.settShirtId(tShirt.gettShirtId());

        return tShirtViewModel;
    }

    public void updateTShirt(TShirtViewModel tShirtViewModel){
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(tShirtViewModel.gettShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtDao.updateTshirt(tShirt);
    }

    public TShirtViewModel findTShirt(int id){
        TShirt tShirt = tShirtDao.getTshirt(id);
        if(tShirt == null)
            return null;
        else
            return buildTShirtViewModel(tShirt);
    }

    public void removeTshirt(int id){
        tShirtDao.deleteTshirt(id);
    }

    //helper methods//

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console){
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }

    private TShirtViewModel buildTShirtViewModel(TShirt tShirt){
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.settShirtId(tShirt.gettShirtId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());
        return tShirtViewModel;
    }

    public void decrementQuantity(int quantityBought, String itemType, int itemId){
        if(itemType == "game"){
            int currentQuan = gameDao.getGame(itemId).getQuantity();
            gameDao.getGame(itemId).setQuantity(currentQuan-quantityBought);

        } else if(itemType == "console"){
            int currentQuan = consoleDao.getConsole(itemId).getQuantity();
            consoleDao.getConsole(itemId).setQuantity(currentQuan-quantityBought);

        } else if(itemType == "tshirt"){
            int currentQuan = tShirtDao.getTshirt(itemId).getQuantity();
            tShirtDao.getTshirt(itemId).setQuantity(currentQuan-quantityBought);
        }
    }

    public BigDecimal calculateProcessingFee(String itemType, int quantity){

        BigDecimal extraFee = calculateExtraFee(quantity);

        if(itemType == "game"){
            return processingFeeDao.getProcessingFeeByType("game").getFee().add(extraFee);
        } else if(itemType == "console"){
            return processingFeeDao.getProcessingFeeByType("console").getFee().add(extraFee);
        } else if(itemType == "tshirt"){
            return processingFeeDao.getProcessingFeeByType("t_shirt").getFee().add(extraFee);
        } else {
            return null;
        }
    }

    public BigDecimal calculateExtraFee(int quantity){
        if(quantity >= 10){
            return BigDecimal.valueOf(15.49);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    public BigDecimal calculateSubtotal(String itemType, InvoiceViewModel invoiceViewModel){
        if(itemType == "game"){
            return gameDao.getGame(invoiceViewModel.getItemId()).getPrice();
        } else if(itemType == "console"){
            return consoleDao.getConsole(invoiceViewModel.getItemId()).getPrice();
        } else if(itemType == "tshirt"){
            return tShirtDao.getTshirt(invoiceViewModel.getItemId()).getPrice();
        } else {
            return null;
        }
    }


    public BigDecimal calculateTotal(Invoice invoice){
        BigDecimal total = invoice.getSubtotal().multiply(invoice.getTax()).add(invoice.getProcessingFee());
        return total;
    }


}
