package com.company;

import java.util.Scanner;

public class CommandLineGram {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //Ask for and store first name
        System.out.println("1. First name");
        String first = myScanner.nextLine();

        //Ask for and store last name
        System.out.println("2. last name");
        String last = myScanner.nextLine();

        //Ask for and store email
        System.out.println("3. email");
        String email = myScanner.nextLine();

        //Ask for and store Twitter handle
        System.out.println("4. Twitter handle");
        String twitter = myScanner.nextLine();

        //Ask for and store age
        System.out.println("5. Age");
        String age = myScanner.nextLine();

        //Ask for and store country
        System.out.println("6. Country");
        String country = myScanner.nextLine();

        //Ask for and store profession
        System.out.println("7. Profession");
        String profession = myScanner.nextLine();

        //Ask for and store favorite operating system
        System.out.println("8. Favorite operating system");
        String opSys = myScanner.nextLine();

        //Ask for and store favorite programming language
        System.out.println("9. Favorite programming language");
        String progLang = myScanner.nextLine();

        //Ask for and store favorite computer scientist
        System.out.println("10. Favorite computer scientist");
        String compSci = myScanner.nextLine();

        //Ask for and store favorite keyboard shortcut
        System.out.println("11. Favorite keyboard shortcut");
        String keyShort = myScanner.nextLine();

        //Ask if user has ever built their own computer, store answer
        System.out.println("12. Have you ever built your own computer?");
        String builtComp = myScanner.nextLine();

        //Ask for and store favorite superhero
        System.out.println("13. If you could be any superhero, who would it be?");
        String hero = myScanner.nextLine();


        //Display collected information
        System.out.println("First Name: " + first);
        System.out.println("Last Name: " + last);
        System.out.println("Email: " + email);
        System.out.println("Twitter: " + twitter);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
        System.out.println("Profession: " + profession);
        System.out.println("Favorite operating system: " + opSys);
        System.out.println("Favorite programming language: " + progLang);
        System.out.println("Favorite computer scientist: " + compSci);
        System.out.println("Favorite keyboard shortcut: " + keyShort);
        System.out.println("Have you ever built your own computer? " + builtComp);
        System.out.println("If you could be any superhero, who would it be?" + hero);


    }
}
