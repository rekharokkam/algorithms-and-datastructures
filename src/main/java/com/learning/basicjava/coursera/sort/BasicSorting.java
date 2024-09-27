package com.learning.basicjava.coursera.sort;

import java.util.Arrays;

public class BasicSorting {

    public static void sort (Integer[] toBeSorted){
        int length = toBeSorted.length;
        int smallest = toBeSorted[0];
        int index = 0;

        for (int i = 0; i < length - 1; i ++) {
            smallest = toBeSorted [i];
            index = i;
            for (int j = i + 1; j < length; j ++) {
                if (toBeSorted[j] < smallest) {
                    smallest = toBeSorted[j];
                    index = j;
                }
            }
            toBeSorted[index] = toBeSorted [i];
            toBeSorted [i] = smallest;
        }
    }


    public static void main(String[] args) {
        Integer[] testArrayToBeSorted  = new Integer[]{10, 2, 5, 1, 8, 3};
        BasicSorting.sort(testArrayToBeSorted);

        Arrays.stream(testArrayToBeSorted).forEach(i -> System.out.print("\t" + i));

    }
}
