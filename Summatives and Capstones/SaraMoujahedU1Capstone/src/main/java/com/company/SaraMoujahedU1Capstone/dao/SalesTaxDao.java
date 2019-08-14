package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.SalesTax;


public interface SalesTaxDao {
    SalesTax getTaxByState(String State);
}
