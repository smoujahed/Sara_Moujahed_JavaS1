package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {


    //1. Find all televisions with a screen size greater than 60 inches. Use the `.forEach` method to print out all entries.
    //1. Group all televisions into a `Map` by `brand`. Print out the list of manufacturers.
    //1. Find and display the average `screenSize`.
    //1. Find and display the largest screen.

    public static void main(String[] args) {


        ObjectMapper mapper1 = new ObjectMapper();
        List<Television> tvList;
        try {


            tvList = mapper1.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            // find all greater than 60 inches

            tvList
                    .stream()
                    .filter(tv -> tv.getScreenSize() > 60)
                    .forEach(t -> {
                        System.out.println("------------");
                        System.out.println(t.getBrand());
                        System.out.println(t.getModel());
                        System.out.println(t.getScreenSize());
                        System.out.println(t.getPrice());
                    });

            // Group all televisions into a `Map` by `brand`. Print out the list of manufacturers.

            Map<String, List<Television>> mapTvList =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = mapTvList.keySet();
            for (String name : keys) {
                System.out.println(name);
            }


            // Find and display the average `screenSize`.

            double screenAvg =
                    tvList
                            .stream()
                            .mapToInt(Television::getScreenSize)
                            //OR mapToInt(b -> b.getScreenSize())
                            .average()
                            .getAsDouble();
            System.out.println("Screen avg size: " + screenAvg);

            // Find and display the largest screen.

            int maxScreen = tvList
                    .stream()
                    .mapToInt(Television::getScreenSize)
                    //OR mapToInt(b -> b.getScreenSize())
                    .max()
                    .getAsInt();

            System.out.println("max screen size: " + maxScreen);


        } catch (IOException e) {
            System.out.println(e);
        }


    }
}