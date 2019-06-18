package com.trilogyed;

import java.util.*;

public class App {
    public static void main(String[] args) {
        City city1 = new City ("New York", 8654321);
        City city2 = new City ("Los Angeles", 4563218);
        City city3 = new City ("Chicago", 2716520);
        City city4 = new City("Denver", 704621);
        City city5 = new City("Des Moines", 217521);
        City city6 = new City("Atlanta", 486213);
        Map<String, City> largestCities = new HashMap<>();
        largestCities.put("New York", city1);
        largestCities.put("California", city2);
        largestCities.put("Illinois", city3);
        largestCities.put("Colorado", city4);
        largestCities.put("Iowa", city5);
        largestCities.put("Geogia", city6);

        Collection<City> myCities = largestCities.values();

       // Collection<City> myPop = myCities.



        for (Map.Entry<String, City> entry : largestCities.entrySet()){

            System.out.println(entry.getKey() + ", " + entry.getValue().name + ", " + entry.getValue().population);
        }

        System.out.println("=======================");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter population minimum");
        int min = Integer.parseInt(scanner.nextLine());

        for (Map.Entry<String, City> entry : largestCities.entrySet()){
            if(entry.getValue().population > min) {
                System.out.println(entry.getKey() + ", " + entry.getValue().name + ", " + entry.getValue().population);
            }
        }

    }
}
