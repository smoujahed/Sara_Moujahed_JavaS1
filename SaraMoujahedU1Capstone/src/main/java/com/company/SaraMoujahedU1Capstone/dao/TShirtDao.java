package com.company.SaraMoujahedU1Capstone.dao;

import com.company.SaraMoujahedU1Capstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTshirt(TShirt tShirt);

    TShirt getTshirt (int tShirtId);

    List<TShirt> getTshirtByColor(String color);

    List<TShirt> getTshirtBySize(String size);

    List<TShirt> getAllTshirts();

    void updateTshirt(TShirt tShirt);

    void deleteTshirt(int tShirtId);



}
