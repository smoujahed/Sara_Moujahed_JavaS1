package com.company.U1M4SummativeMoujahedSara.controller;

import com.company.U1M4SummativeMoujahedSara.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class WordAPIController {

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word generateWord(){
        Random rnd = new Random();
        int num = rnd.nextInt(10);
        Word word = new Word();

        switch (num){
            case 0:
                word.setWord("Lubberly");
                word.setDefinition("clumsy and unskilled");
                break;
            case 1:
                word.setWord("Jocular");
                word.setDefinition("characterized by jokes and good humor");
                break;
            case 2:
                word.setWord("Obbligato");
                word.setDefinition("a part of a musical score that must be performed without change or omission");
                break;
            case 3:
                word.setWord("Stevedore");
                word.setDefinition("a laborer who loads and unloads vessels in a port");
                break;
            case 4:
                word.setWord("Congeries");
                word.setDefinition("a sum total of many heterogenous things taken together");
                break;
            case 5:
                word.setWord("Kittiwake");
                word.setDefinition("a small pearl-grey gull of northern regions");
                break;
            case 6:
                word.setWord("Bollard");
                word.setDefinition("a strong post");
                break;
            case 7:
                word.setWord("Parvenu");
                word.setDefinition("a person who had suddenly risen to a higher economic status");
                break;
            case 8:
                word.setWord("Bowdlerize");
                word.setDefinition("edit by omitting or modifying parts considered indelicate");
                break;
            case 9:
                word.setWord("Quasi");
                word.setDefinition("having some resemblance");
                break;
        }

        return word;
    }

}
