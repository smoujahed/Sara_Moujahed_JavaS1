package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Game;
import com.company.SaraMoujahedU1Capstone.model.Invoice;
import com.company.SaraMoujahedU1Capstone.model.TShirt;
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
public class TShirtDaoJdbcTemplateImplTest {

    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception{
        List<TShirt> tShirts = tShirtDao.getAllTshirts();
        for (TShirt t : tShirts){
            tShirtDao.deleteTshirt(t.gettShirtId());
        }
    }

    @Test
    public void addGetDeleteTShirt(){
        TShirt tShirt = new TShirt();
        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);

        tShirt = tShirtDao.addTshirt(tShirt);
        TShirt tShirt1 = tShirtDao.getTshirt(tShirt.gettShirtId());
        assertEquals(tShirt1,tShirt);

        tShirtDao.deleteTshirt(tShirt.gettShirtId());
        tShirt1 = tShirtDao.getTshirt(tShirt.gettShirtId());
        assertNull(tShirt1);

    }

    @Test
    public void updateTShirt(){
        TShirt tShirt = new TShirt();
        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);

        tShirt = tShirtDao.addTshirt(tShirt);

        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);
        tShirtDao.updateTshirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTshirt(tShirt.gettShirtId());
        assertEquals(tShirt1, tShirt);

    }

    @Test
    public void getAllTShirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);

        tShirt = tShirtDao.addTshirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("medium");
        tShirt.setColor("red");
        tShirt.setDescription("Nike check");
        tShirt.setPrice(BigDecimal.valueOf(25.99));
        tShirt.setQuantity(15);
        tShirtDao.addTshirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getAllTshirts();
        assertEquals(2, tShirtList.size());
    }
}
