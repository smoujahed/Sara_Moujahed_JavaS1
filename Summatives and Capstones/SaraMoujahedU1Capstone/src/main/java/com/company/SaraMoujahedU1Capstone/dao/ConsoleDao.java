package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int consoleId);

    List<Console> getConsolesByManufacturer(String manufacturer);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int consoleId);

}
