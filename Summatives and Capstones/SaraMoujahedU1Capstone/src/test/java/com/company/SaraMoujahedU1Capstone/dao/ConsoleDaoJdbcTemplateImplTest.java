package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.OnPropertyListCondition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception{
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console i : consoles) {
            consoleDao.deleteConsole(i.getConsoleId());
        }
    }

    @Test
    public void addGetDeleteConsole(){
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console,console1);

        consoleDao.deleteConsole(console.getConsoleId());
        console1 = consoleDao.getConsole(console.getConsoleId());
        assertNull(console1);

    }

    @Test
    public void updateConsole(){
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);

        console = consoleDao.addConsole(console);

        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);
        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console1, console);
    }

    @Test
    public void getAllConsoles(){
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);

        console = consoleDao.addConsole(console);

        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("x86-64 AMD Jaguar");
        console.setPrice(BigDecimal.valueOf(249.99));
        console.setQuantity(10);
        consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getAllConsoles();
        assertEquals(2, consoleList.size());
    }
}
