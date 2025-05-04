package org.example.exo6;

public class FizzBuzzCorrection {
    public static String fizzBuzz(int n) {
        if (n < 1) { // correction : < 1 au lieu de <= 1
            throw new IllegalArgumentException("n must be positive");
        }
        if (n % 15 == 0) {
            return "FizzBuzz";
        }
        if (n % 3 == 0) {
            return "Fizz";
        }
        if (n % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(n);
    }
}
