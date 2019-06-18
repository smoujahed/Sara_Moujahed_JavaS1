package com.trilogyed;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, Integer> heights = new HashMap<>();

        heights.put("Joe", 72);
        heights.put("sally", 63);
        heights.put("abby", 75);

        System.out.println("Number of entries in the map: " + heights.entrySet());

        int joesHeight = heights.get("Joe");
        System.out.println("Joe is " + joesHeight + " inches tall");

        heights.replace("Joe", 74);
        joesHeight = heights.get("Joe");
        System.out.println("Joe is " + joesHeight + " inches tall");

        heights.put(null, null);
        System.out.println(heights.get(null));
        System.out.println(heights.size());



    }
}
