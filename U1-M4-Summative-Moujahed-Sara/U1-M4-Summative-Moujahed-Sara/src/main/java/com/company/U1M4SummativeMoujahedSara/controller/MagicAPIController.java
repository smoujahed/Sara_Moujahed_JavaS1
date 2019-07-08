package com.company.U1M4SummativeMoujahedSara.controller;

import com.company.U1M4SummativeMoujahedSara.model.Magic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class MagicAPIController {

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Magic generateAnswer (@RequestBody String question){
        Magic magic = new Magic();
        magic.setQuestion(question);
        Random rnd = new Random();
        int num = rnd.nextInt(6);
        switch (num){
            case 0:
                magic.setAnswer("It is certain");
                break;
            case 1:
                magic.setAnswer("Ask again later");
                break;
            case 2:
                magic.setAnswer("Don't count on it");
                break;
            case 3:
                magic.setAnswer("Yes");
                break;
            case 4:
                magic.setAnswer("Maybe");
                break;
            case 5:
                magic.setAnswer("No");
                break;
        }
        return magic;

    }
}
