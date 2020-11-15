package com.ashwinchalaka.hw3.exercise1;

import com.ashwinchalaka.hw3.exercise1.Filter;

import java.util.ArrayList;

public class FilterType1 implements com.ashwinchalaka.hw3.exercise1.Filter {

    @Override
    public boolean accept(Object x) {
        if (x instanceof String && ((String) x).length() >= 9)
            return true;
        else if (Integer.class.isInstance(x) && ((int) x) >= 0)
            return true;
        else
            return false;
    }

    @Override
    public String[] filter(String[] a, Filter f) {
        ArrayList<String> longStringsTemp = new ArrayList<String>();
        for (String s: a) {
            if (accept(s))
                longStringsTemp.add(s);
        }
        String[] longStrings = new String[longStringsTemp.size()];
        for (int i = 0; i < longStringsTemp.size(); i++) {
            longStrings[i] = longStringsTemp.get(i);
        }
        return longStrings;
    }

    @Override
    public int[] filter(int[] a, Filter f) {
        ArrayList<Integer> positiveNumbersTemp = new ArrayList<Integer>();
        for (int i: a) {
            if (accept(i))
                positiveNumbersTemp.add(i);
        }
        int[] positiveNumbers = new int[positiveNumbersTemp.size()];
        for (int i = 0; i < positiveNumbersTemp.size(); i++) {
            positiveNumbers[i] = positiveNumbersTemp.get(i);
        }
        return positiveNumbers;
    }
}
