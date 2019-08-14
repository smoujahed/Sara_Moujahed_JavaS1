package com.company.SaraMoujahedU1Capstone.service;

import com.company.SaraMoujahedU1Capstone.dao.*;
import com.company.SaraMoujahedU1Capstone.model.Console;
import com.company.SaraMoujahedU1Capstone.model.Game;
import com.company.SaraMoujahedU1Capstone.model.Invoice;
import com.company.SaraMoujahedU1Capstone.model.TShirt;
import com.company.SaraMoujahedU1Capstone.viewmodel.ConsoleViewModel;
import com.company.SaraMoujahedU1Capstone.viewmodel.GameViewModel;
import com.company.SaraMoujahedU1Capstone.viewmodel.InvoiceViewModel;
import com.company.SaraMoujahedU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvoiceInventoryServiceLayerTest {
    ConsoleDao consoleDao;
    GameDao gameDao;
    TShirtDao tShirtDao;
    SalesTaxDao salesTaxDao;
    ProcessingFeeDao processingFeeDao;
    InvoiceDao invoiceDao;
    InvoiceInventoryService invoiceInventoryService;


    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceMock();

        invoiceInventoryService = new InvoiceInventoryService(consoleDao, gameDao, tShirtDao, invoiceDao, processingFeeDao, salesTaxDao);
    }

    private void setUpConsoleDaoMock(){
        consoleDao = mock(ConsoleDaoTemplateImpl.class);

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);

        Console console1 = new Console();
        console1.setModel("PS4");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("8GB");
        console1.setProcessor("x86-64 AMD Jaguar");
        console1.setPrice(BigDecimal.valueOf(249.99));
        console1.setQuantity(10);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getConsolesByManufacturer("Sony");
        doReturn(consoleList).when(consoleDao).getAllConsoles();
    }

    private void setUpGameDaoMock(){
        gameDao = mock(GameDaoTemplateImpl.class);

        Game game = new Game();
        game.setGameId(2);
        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);

        Game game1 = new Game();
        game1.setTitle("Skyrim");
        game1.setEsrbRating("M");
        game1.setDescription("Dragons n stuff");
        game1.setPrice(BigDecimal.valueOf(59.99));
        game1.setStudio("Bethesda");
        game1.setQuantity(7);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(2);
        doReturn(gameList).when(gameDao).getGamesByRating("M");
        doReturn(gameList).when(gameDao).getGamesByStudio("Bethesda");
        doReturn(gameList).when(gameDao).getGamesByTitle("Skyrim");
        doReturn(gameList).when(gameDao).getAllGames();
    }

    private void setUpTShirtDaoMock(){
        tShirtDao = mock(TShirtDaoTemplateImpl.class);
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(3);
        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("medium");
        tShirt1.setColor("red");
        tShirt1.setDescription("Nike check");
        tShirt1.setPrice(BigDecimal.valueOf(25.99));
        tShirt1.setQuantity(15);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTshirt(tShirt1);
        doReturn(tShirt).when(tShirtDao).getTshirt(3);
        doReturn(tShirtList).when(tShirtDao).getTshirtByColor("red");
        doReturn(tShirtList).when(tShirtDao).getTshirtBySize("medium");
        doReturn(tShirtList).when(tShirtDao).getAllTshirts();
    }

    private void setUpInvoiceMock(){
        invoiceDao = mock(InvoiceDaoTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(10);
        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("NY");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(4);
        invoice.setUnitPrice(BigDecimal.valueOf(500));
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(BigDecimal.valueOf(0.07));
        invoice.setProcessingFee(BigDecimal.valueOf(15.99));
        invoice.setTotal(BigDecimal.valueOf(954.83));

        Invoice invoice1 = new Invoice();
        invoice1.setName("John");
        invoice1.setStreet("123 main st");
        invoice1.setCity("Americaville");
        invoice1.setState("NY");
        invoice1.setZipcode("12345");
        invoice1.setItemType("console");
        invoice1.setItemId(4);
        invoice1.setUnitPrice(BigDecimal.valueOf(500));
        invoice1.setQuantity(5);
        invoice1.setSubtotal(BigDecimal.valueOf(502.99));
        invoice1.setTax(BigDecimal.valueOf(0.07));
        invoice1.setProcessingFee(BigDecimal.valueOf(15.99));
        invoice1.setTotal(BigDecimal.valueOf(954.83));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(10);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
    }

    @Test
    public void saveFindConsole(){

        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);

        console = invoiceInventoryService.saveConsole(console);
        ConsoleViewModel fromService  = invoiceInventoryService.findConsole(console.getConsoleId());
        assertEquals(console,fromService);
    }

    @Test
    public void saveFindGame(){
        GameViewModel game = new GameViewModel();
        game.setTitle("Skyrim");
        game.setEsrbRating("M");
        game.setDescription("Dragons n stuff");
        game.setPrice(BigDecimal.valueOf(59.99));
        game.setStudio("Bethesda");
        game.setQuantity(7);

        game = invoiceInventoryService.saveGame(game);
        GameViewModel fromService = invoiceInventoryService.findGame(game.getGameId());
        assertEquals(game, fromService);
    }

    @Test
    public void saveFindTShirt(){
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);

        tShirt = invoiceInventoryService.saveTShirt(tShirt);
        TShirtViewModel fromService = invoiceInventoryService.findTShirt(tShirt.gettShirtId());
        assertEquals(tShirt, fromService);
    }

    @Test
    public void saveFindInvoice(){
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("NY");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(4);
        invoice.setUnitPrice(BigDecimal.valueOf(500));
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(BigDecimal.valueOf(0.07));
        invoice.setProcessingFee(BigDecimal.valueOf(15.99));
        invoice.setTotal(BigDecimal.valueOf(954.83));

        invoice = invoiceInventoryService.saveInvoice(invoice);
        InvoiceViewModel fromService = invoiceInventoryService.findInvoice(invoice.getInvoiceId());
        assertEquals(invoice, fromService);

    }
}
