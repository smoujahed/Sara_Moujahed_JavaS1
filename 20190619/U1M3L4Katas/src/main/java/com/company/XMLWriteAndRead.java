package com.company;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));
        ObjectMapper mapper = new XmlMapper();
        PrintWriter writer = null;

        try {


            for (Car car : carList) {
                System.out.println("================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
            }

            String jsonCarList = mapper.writeValueAsString(carList);

            System.out.println(jsonCarList);


            writer = new PrintWriter(new FileWriter("cars.xml"));

            writer.println(jsonCarList);


        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
//        } catch (JsonProcessingException e) {
//            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }
}
