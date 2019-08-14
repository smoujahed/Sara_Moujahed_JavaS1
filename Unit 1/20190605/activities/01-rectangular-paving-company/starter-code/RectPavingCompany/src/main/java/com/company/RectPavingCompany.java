package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //Ask for width, store input
        System.out.println("Please enter driveway width in feet");
        int width = Integer.parseInt(myScanner.nextLine());

        //Ask for length, store input
        System.out.println("Please enter driveway length in feet");
        int length = Integer.parseInt(myScanner.nextLine());

        System.out.println("______________________________________");
        System.out.println("Specs");
        System.out.println("______________________________________");

        //Calculate area
        int area = width * length;
        System.out.println("Driveway area is " + area);

        //Calculate perimeter
        int perimeter = (width + length) * 2;
        System.out.println("Driveway perimeter is " + perimeter);

        System.out.println("______________________________________");
        System.out.println("Pricing");
        System.out.println("______________________________________");

        //Calculate cement cost
        float cementCost = area * 12.50f;
        System.out.println("Cost of Cement is $" + cementCost);

        //Calculate framing cost
        float framingCost = perimeter * 8.25f;
        System.out.println("Cost of framing/footers is $" + framingCost);

        System.out.println("______________________________________");
        //Ask for costs
        System.out.println("Enter cost of cement");
        float inputCementCost = Float.parseFloat(myScanner.nextLine());
        System.out.println("Enter cost of framing");
        float inputFramingCost = Float.parseFloat(myScanner.nextLine());

        //Add subtotal
        float cementTotal = (inputCementCost * area);
        System.out.format("Subtotal is $ %.2f", cementTotal);

        float frameTotal = (inputFramingCost * perimeter);
        System.out.format("Subtotal is $ %.2f", frameTotal);
    }
}
