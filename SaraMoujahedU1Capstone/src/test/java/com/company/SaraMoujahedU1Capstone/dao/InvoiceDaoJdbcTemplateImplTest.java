package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Console;
import com.company.SaraMoujahedU1Capstone.model.Invoice;
import com.company.SaraMoujahedU1Capstone.model.ProcessingFee;
import com.company.SaraMoujahedU1Capstone.model.SalesTax;
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
public class InvoiceDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    SalesTaxDao salesTaxDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {

        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console c : consoles) {
            consoleDao.deleteConsole(c.getConsoleId());
        }

        List<Invoice> invoices = invoiceDao.getAllInvoices();
        for (Invoice i : invoices) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }

    }

    @Test
    public void addGetDeleteInvoice(){

        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);

        Invoice invoice = new Invoice();
        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("New York");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(console.getConsoleId());
        invoice.setUnitPrice(console.getPrice());
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(salesTaxDao.getTaxByState("NC").getRate());
        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByType("console").getFee());
        invoice.setTotal(BigDecimal.valueOf(954.83));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.addInvoice(invoice);
        assertEquals(invoice1,invoice);
        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice1);

    }

    @Test
    public void getAllInvoices(){
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);

        Invoice invoice = new Invoice();
        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("New York");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(console.getConsoleId());
        invoice.setUnitPrice(console.getPrice());
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(salesTaxDao.getTaxByState("NC").getRate());
        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByType("console").getFee());
        invoice.setTotal(BigDecimal.valueOf(954.83));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("New York");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(console.getConsoleId());
        invoice.setUnitPrice(console.getPrice());
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(salesTaxDao.getTaxByState("NC").getRate());
        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByType("console").getFee());
        invoice.setTotal(BigDecimal.valueOf(954.83));
        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoices = invoiceDao.getAllInvoices();
        assertEquals(2, invoices.size());
    }

    @Test
    public void updateInvoice (){

        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);
        console = consoleDao.addConsole(console);

        Invoice invoice = new Invoice();
        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("New York");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(console.getConsoleId());
        invoice.setUnitPrice(console.getPrice());
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(salesTaxDao.getTaxByState("NC").getRate());
        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByType("console").getFee());
        invoice.setTotal(BigDecimal.valueOf(954.83));
        invoice = invoiceDao.addInvoice(invoice);

        invoice.setName("John");
        invoice.setStreet("123 main st");
        invoice.setCity("Americaville");
        invoice.setState("New York");
        invoice.setZipcode("12345");
        invoice.setItemType("console");
        invoice.setItemId(console.getConsoleId());
        invoice.setUnitPrice(console.getPrice());
        invoice.setQuantity(5);
        invoice.setSubtotal(BigDecimal.valueOf(502.99));
        invoice.setTax(salesTaxDao.getTaxByState("NC").getRate());
        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByType("console").getFee());
        invoice.setTotal(BigDecimal.valueOf(954.83));
        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice, invoice1);
    }
}
