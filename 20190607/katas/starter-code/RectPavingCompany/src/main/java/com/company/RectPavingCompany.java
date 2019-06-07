package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        float width = Float.parseFloat(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        float length = Float.parseFloat(scan.nextLine());



        System.out.print("What is the cost of cement per square foot? ");
        float cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");
        float framingCost = Float.parseFloat(scan.nextLine());

        float area = length * width;
        float perimeter = (2*length) + (2*width);

        System.out.format("The area of the driveway is %f.%n square feet.", area);
        System.out.format("The perimeter of the driveway is %f.%n square feet.", perimeter);

        System.out.format("The cost of the cement is %f.%n", area*cementCost);
        System.out.format("The cost of the framing/footers is %f.%n", perimeter*framingCost);
    }
}
