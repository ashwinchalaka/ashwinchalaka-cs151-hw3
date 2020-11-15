package com.ashwinchalaka.hw3.exercise1;

public interface Filter<T> {
    boolean accept(T x);
    public String[] filter(String[] a, Filter<String> f);
    public int[] filter(int[] a, Filter<Integer> f);
}
