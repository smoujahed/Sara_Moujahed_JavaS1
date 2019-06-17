package com.company;

public class Pbd {
    public static void main(String[] args) {
        System.out.println(closeFar(1,2,10));
    }
    public static boolean closeFar(int a, int b, int c) {
        int gap1 = Math.abs(a-b);
        int gap2 = Math.abs(b-c);
        int gap3 = Math.abs(c-a);
        if (Math.abs(gap1 - gap <=1
                && Math.abs(gap2 - gap3) >= 2
                && Math.abs(gap3 - gap1) >=2) {
            return true;
        } else {
            return false;
        }

    }
}
