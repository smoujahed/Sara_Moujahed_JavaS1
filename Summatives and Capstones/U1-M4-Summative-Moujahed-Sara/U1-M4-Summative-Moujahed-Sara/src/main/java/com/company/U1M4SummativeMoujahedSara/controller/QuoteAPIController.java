package com.company.U1M4SummativeMoujahedSara.controller;

import com.company.U1M4SummativeMoujahedSara.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class QuoteAPIController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public Quote generateQuote (){
        Random rnd = new Random();
        int num = rnd.nextInt(10);
        Quote quote = new Quote();
        switch(num) {
            case 0:
                quote.setQuote("Read a thousand books, and your words will flow like a river.");
                quote.setAuthor("Lisa See");
                break;
            case 1:
                quote.setQuote("You know you’re in love when you can’t fall asleep because reality is finally better than your dreams.");
                quote.setAuthor("Dr. Suess");
                break;
            case 2:
                quote.setQuote("Get busy living or get busy dying.");
                quote.setAuthor("Stephen King");
                break;
            case 3:
                quote.setQuote("Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do.");
                quote.setAuthor("Mark Twain");
                break;
            case 4:
                quote.setQuote("If you want to be happy, be.");
                quote.setAuthor("Leo Tolstoy");
                break;
            case 5:
                quote.setQuote("Those who dare to fail miserably can achieve greatly.");
                quote.setAuthor("John F. Kennedy");
                break;
            case 6:
                quote.setQuote("Let us always meet each other with smile, for the smile is the beginning of love.");
                quote.setAuthor("Mother Theresa");
                break;
            case 7:
                quote.setQuote("Love is a serious mental disease.");
                quote.setAuthor("Plato");
                break;
            case 8:
                quote.setQuote("It is our choices, that show what we truly are, far more than our abilities.");
                quote.setAuthor("J. K Rowling");
                break;
            case 9:
                quote.setQuote("Only put off until tomorrow what you are willing to die having left undone.");
                quote.setAuthor("Pablo Picasso");
        }
        return quote;
    }
}
