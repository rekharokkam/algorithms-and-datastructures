package com.learning.basicjava.coursera.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyBST {

    //Assuming the array is already sorted
    public static void search (int[] array, int numberToBeSearched) {

        //check the length of the array.
        // If 1 and that does not match the numberToBeSearched, then number cannot be found
        if (array.length == 1){
            if (array[0] == numberToBeSearched) {
                System.out.println("number was found");
            } else {
                System.out.println("Number was not found");
            }
            return;
        }
        int arrayMidLength = array.length/2;

//        if the center element is the greater than the numberToBeSearched, then fetch only the left side
        int[] newArray = new int[arrayMidLength];
        if (numberToBeSearched < array[arrayMidLength]) {
            newArray = Arrays.copyOfRange(array, 0, arrayMidLength);
        } else {
            newArray = Arrays.copyOfRange(array, arrayMidLength, array.length);
        }
        search(newArray, numberToBeSearched);
    }

    public static void main(String[] args) {
//        MyBST.search(new int[] {0, 1, 2, 3, 4, 5}, 5);

        Set<Integer> mySet = new HashSet<>(3);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(6);

        System.out.println(mySet);
    }
}
