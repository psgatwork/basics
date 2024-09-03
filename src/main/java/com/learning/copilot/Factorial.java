package com.learning.copilot;
import java.math.BigInteger;

public class Factorial {
   public static BigInteger calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        
        return factorial;
    }

    public static void main(String[] args) {
        int number = 455; // Example number
        BigInteger result = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}