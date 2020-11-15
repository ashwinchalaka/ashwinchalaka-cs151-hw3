package com.ashwinchalaka.hw3.exercise1;

import java.util.Random;

public class TestExercise1 {
    public static void main(String[] args) {
        FilterType1 filter = new FilterType1();

        String[] test1String = new String[20];
        for (int i = 0; i < 20; i++) {
            test1String[i] = TestExercise1.getSaltString();
        }

        int[] test1Int = new int[20];
        for (int j = 0; j < 20; j++) {
            test1Int[j] = TestExercise1.getSaltInt();
        }

        System.out.println("\nBefore");
        TestExercise1.toString(test1String);
        TestExercise1.toString(test1Int);

        String[] longStrings = filter.filter(test1String,filter);
        int[] positiveNumbers = filter.filter(test1Int,filter);

        System.out.println("\nAfter");
        TestExercise1.toString(longStrings);
        TestExercise1.toString(positiveNumbers);
    }

    private static void toString(Object[] a) {
        String str = "[";
        for (Object o: a) {
            str += o.toString() + ",";
        }
        str = str.substring(0,str.length()-1);
        str += "]";
        System.out.println(str);
    }

    private static void toString(int[] a) {
        String str = "[";
        for (int i: a) {
            str += i + ",";
        }
        str = str.substring(0,str.length()-1);
        str += "]";
        System.out.println(str);
    }

    private static String getSaltString() {
        Random rand = new Random(); //instance of random class
        int upperbound = 20;
        //generate random values from 0 to 24
        int int_random = rand.nextInt(upperbound);
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < int_random) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    private static int getSaltInt() {
        Random rand = new Random(); //instance of random class
        int upperbound = 100;
        int int_random = rand.nextInt(upperbound) - 50;
        //generate random values from -50 to 50
        return int_random;
    }
}
