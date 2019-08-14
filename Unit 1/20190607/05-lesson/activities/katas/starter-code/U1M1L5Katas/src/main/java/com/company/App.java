package com.company;

public class App {

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int result = a - b;
        if(result < 0) {
            return 0;
        }else{
            return result;
        }
    }

    public static int max(int a, int b, int c) {
        int[] maxArray = new int[4];
        maxArray[0] = a;
        maxArray[1] = b;
        maxArray[2] = c;

        int max = maxArray[0];
        for (int i = 0; i < maxArray.length; i++) {
            if (maxArray[i] > max) {
                max = maxArray[i];
            }
        }
        return max;
    }

    public static int min(int a, int b, int c) {
        int num;

        if (a < b) {
            num = a;
        } else {
            num = b;
        }

        if (num < c) {
            return num;
        } else {
            return c;
        }
    }

    public static boolean isLarger(int a, int b) {
        if(a > b) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        subtract(6, 3);

        subtractOrZero(12, 7);

        max(12, 4, 6);

        min(9, 2, 6);

        isLarger(6, 7);
    }

}