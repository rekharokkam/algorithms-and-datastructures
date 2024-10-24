package com.learning.basicjava.grokkingthecodinginterviewpattern.random;

import java.util.Scanner;

public class FindingAPrimeNumber {

    public static boolean isPrime (int number) {
        //first check if the number is lesser than 1
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i ++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        boolean isInputPrime = isPrime(input);
        System.out.println("is Input Prime : " + isInputPrime);
    }
}
