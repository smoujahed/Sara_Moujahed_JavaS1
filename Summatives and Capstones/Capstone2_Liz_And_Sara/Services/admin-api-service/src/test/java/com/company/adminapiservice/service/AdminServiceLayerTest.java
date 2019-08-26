package com.company.adminapiservice.service;


import com.company.adminapiservice.util.feign.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceLayerTest {

    @InjectMocks
    AdminServiceLayer service;
    @Mock
    ProductFeignClient productClient;
    @Mock
    CustomerFeignClient customerClient;
    @Mock
    InventoryFeignClient inventoryClient;
    @Mock
    InvoiceFeignClient invoiceClient;
    @Mock
    LevelUpFeignClient levelUpClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        setUpProductClientMock();
        setUpCustomerClientMock();
        setUpInventoryClientMock();
        setUpInvoiceClientMock();
        setUpLevelUpClientMock();
    }

    public void setUpLevelUpClientMock() {

    }

    public void setUpProductClientMock() {

    }

    public void setUpCustomerClientMock() {

    }

    public void setUpInventoryClientMock() {

    }

    public void setUpInvoiceClientMock() {

    }
}
