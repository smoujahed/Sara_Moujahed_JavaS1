package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {
    public static void main(String[] args) {

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            List<Television> televisionList;
            televisionList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            for (Television tv : televisionList) {

                System.out.println(tv.getBrand());
                System.out.println(tv.getModel());
                System.out.println(tv.getPrice());
                System.out.println(tv.getScreenSize());
                System.out.println("===========================");
            }

        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        }

    }
}
