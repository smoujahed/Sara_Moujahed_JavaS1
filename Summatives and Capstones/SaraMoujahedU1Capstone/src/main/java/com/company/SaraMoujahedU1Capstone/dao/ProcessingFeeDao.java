package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.ProcessingFee;

import java.math.BigDecimal;

public interface ProcessingFeeDao {
    ProcessingFee getProcessingFeeByType(String productType);
}
