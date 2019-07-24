package com.company.SaraMoujahedU1Capstone.controller;

import com.company.SaraMoujahedU1Capstone.dao.InvoiceDao;
import com.company.SaraMoujahedU1Capstone.dao.SalesTaxDao;
import com.company.SaraMoujahedU1Capstone.exception.NotFoundException;
import com.company.SaraMoujahedU1Capstone.exception.OrderQuantityException;
import com.company.SaraMoujahedU1Capstone.service.InvoiceInventoryService;
import com.company.SaraMoujahedU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    SalesTaxDao salesTaxDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel invoice){
        int stockQuantity = invoiceDao.getInvoice(invoice.getInvoiceId()).getQuantity();
        if(stockQuantity==0){
            throw new OrderQuantityException("Item stock is 0");
        } else if(stockQuantity<invoice.getQuantity()){
            throw new OrderQuantityException("Item stock is less than requested order quantity");
        } else if(salesTaxDao.getTaxByState(invoice.getState()).getRate() == null){
            throw new NotFoundException("State format invalid or state doesn't exist, please use initials");
        }
        InvoiceViewModel invoiceViewModel = inventoryService.saveInvoice(invoice);
        inventoryService.executeBusinessLogic(invoiceDao.getInvoice(invoiceViewModel.getInvoiceId()), invoiceViewModel);
        return invoiceViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable("id") int id){
        InvoiceViewModel invoice = inventoryService.findInvoice(id);
        if(invoice == null){
            throw new NotFoundException("Invoice could not be retrieved for id " + id);

        }
        return invoice;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id){
        inventoryService.removeInvoice(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable("id") int invoiceId, @RequestBody @Valid InvoiceViewModel invoiceViewModel){
        if(invoiceViewModel.getInvoiceId() == 0)
            invoiceViewModel.setInvoiceId(invoiceId);
        if(invoiceId != invoiceViewModel.getInvoiceId()) {
            throw new IllegalArgumentException("Invoice ID on path must match the ID in the Invoice object");
        }
        inventoryService.updateInvoice(invoiceViewModel);

    }
}
