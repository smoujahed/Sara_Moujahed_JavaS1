package com.company;

public class App {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        splitAtFive(array);
    }

    public static int total (int[] array) {
        int sum = 0;
        for (int i = 0; i<array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static int totalOdd (int[] array) {
        int sum = 0;
        for (int i = 1; i<array.length; i=i+2) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static int totalEven (int[] array) {
        int sum = 0;
        for (int i = 0; i<array.length; i=i+2) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static int secondLargestNumber (int[] array) {
        int ult = array[0];
        int penUlt = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > ult) {
                penUlt = ult;
                ult = array[i];
            } else if (array[i] > penUlt && array[i] != ult) {
                penUlt = array[i];
            }
            if (array.length == 2 && array[0] > array[1]) {
                    penUlt = array[1];
            }
        }

        return penUlt;
    }

    public static String[] swapFirstAndLast (String[] array) {
        //save array length for efficiency
        int lastIndex = array.length-1;

        //initiate variables to store first and last values
        String firstVal = array[0];
        String lastVal = array[lastIndex];

        //swap first and last
        array[lastIndex] = firstVal;
        array[0] = lastVal;
        return array;
    }
    public static int[] reverse (int[] array) {
            for (int i = 0; i<array.length/2; i++) {
                int a = array[i];
                array[i] = array[(array.length - i) - 1];
                array[(array.length - i) - 1] = a;
            }
        return array;
        }
     public static String concatenateString (String[] array) {
        String concat = "";

        for (int i = 0; i<array.length; i++) {
            concat = concat + array[i];
        }

        return concat;
     }

     public static int[] everyThird (int[] array){
            int[] thirdArray = new int[array.length/3];
            for(int i = 2; i < array.length; i+=3) {
                int index = i/3;
                thirdArray[index] = array[i];
         }
            if (array.length<3) {
                return null;
            }
         return thirdArray;
     }
     
     public static int[] lessThanFive (int[] array) {
        int length = 0;
         int j = 0;

         //get length of array
         for (int i = 0; i<array.length; i++){
            if (array[i] < 5){
                length++;

            }
        }

        int[] lessThanFive = new int[length];
        for (int i = 0; i<array.length; i++) {

            if (array[i] < 5){

                lessThanFive[j] = array [i];
                j++;
            }
        }
        if (length == 0) {
            return null;
        }
        return lessThanFive;
     }

     public static int[][] splitAtFive (int[] array){
         int length = 0;
         int lengthOfRest = 0;
         int row1Counter = 0;
         int row2Counter = 0;

         //get length of array
         for (int i = 0; i<array.length; i++){
             if (array[i] < 5){
                 length++;

             } else {
                 lengthOfRest++;
             }
         }

         int[] row1 = new int[length];
         int[] row2 = new int [lengthOfRest];
         //2nd try
         for (int i = 0; i<array.length; i++) {
             if (array[i] < 5) {
                 row1[row1Counter] = array[i];
                 row1Counter++;
             } else if (array[i] >=5) {
                 row2[row2Counter] = array[i];
                 row2Counter++;
             }
         }
         int[][] newArray = {row1, row2};


         //create new array as two dimensional
//         int[][] newArray = new int[2][];
//         newArray[0] = new int[length];
//         newArray[1] = new int[lengthOfRest];

//         //iterate through array
//         for (int i = 0; i<array.length; i++) {
//
//             //compare variables to 5
//             if (array[i] < 5){
//                 newArray[0][row1Counter] = array [i];
//                 row1Counter++;
//             } else if (array[i] >= 5) {
//                 newArray[1][row2Counter] = array[i];
//                 row2Counter++;
//             }
//         }

         //null exception
         if (length == 0) {
             return null;
         }
         return newArray;
     }

     }



