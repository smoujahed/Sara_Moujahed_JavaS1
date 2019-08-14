package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.invoke.empty.Empty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoTemplateImpl implements InvoiceDao{

    private JdbcTemplate jdbcTemplate;

    public static final String INSERT_INVOICE_SQL =
            "insert into invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String SELECT_INVOICE_SQL =
            "select * from invoice where invoice_id = ?";

    public static final String SELECT_ALL_INVOICES_SQL =
            "select * from invoice";

    public static final String UPDATE_INVOICE_SQL =
            "update invoice set name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id = ?, unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ? where invoice_id = ?";

    public static final String DELETE_INVOICE_SQL =
            "delete from invoice where invoice_id = ?";


    @Autowired
    public InvoiceDaoTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(
                INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal());
        invoice.setInvoiceId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return invoice;
    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice, invoiceId);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(
                UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal(),
                invoice.getInvoiceId()
        );
    }

    @Override
    public void deleteInvoice(int invoiceId) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, invoiceId);
    }

    private Invoice mapRowToInvoice(ResultSet resultSet, int i) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(resultSet.getInt("invoice_id"));
        invoice.setName(resultSet.getString("name"));
        invoice.setStreet(resultSet.getString("street"));
        invoice.setCity(resultSet.getString("city"));
        invoice.setState(resultSet.getString("state"));
        invoice.setZipcode(resultSet.getString("zipcode"));
        invoice.setItemType(resultSet.getString("item_type"));
        invoice.setItemId(resultSet.getInt("item_id"));
        invoice.setUnitPrice(resultSet.getBigDecimal("unit_price"));
        invoice.setQuantity(resultSet.getInt("quantity"));
        invoice.setSubtotal(resultSet.getBigDecimal("subtotal"));
        invoice.setTax(resultSet.getBigDecimal("tax"));
        invoice.setProcessingFee(resultSet.getBigDecimal("processing_fee"));
        invoice.setTotal(resultSet.getBigDecimal("total"));
        return invoice;
    }
}
