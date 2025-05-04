package ConditionCoverageTest;

import org.example.exo6.FizzBuzz;
import org.example.exo6.FizzBuzzCorrection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo6Test {
    // Tests for buggy version
    @Test
    void testBuggyFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(12));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(18));
    }

    @Test
    void testBuggyBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(25));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(35));
    }

    @Test
    void testBuggyFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(60));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(75));
    }

    @Test
    void testBuggyNumbers() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("4", FizzBuzz.fizzBuzz(4));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
        assertEquals("8", FizzBuzz.fizzBuzz(8));
        assertEquals("11", FizzBuzz.fizzBuzz(11));
        assertEquals("13", FizzBuzz.fizzBuzz(13));
        assertEquals("14", FizzBuzz.fizzBuzz(14));
    }

    @Test
    void testBuggyInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-3));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-15));
    }

    @Test
    void testBuggyConditionBoundaries() {
        // Test around boundary conditions for Fizz
        assertEquals("2", FizzBuzz.fizzBuzz(2));  // Just before Fizz
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3)); // Boundary for Fizz
        assertEquals("4", FizzBuzz.fizzBuzz(4));  // Just after Fizz
        
        // Test around boundary conditions for Buzz
        assertEquals("4", FizzBuzz.fizzBuzz(4));  // Just before Buzz
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5)); // Boundary for Buzz
        assertEquals("6", FizzBuzz.fizzBuzz(6));  // Just after Buzz
        
        // Test around boundary conditions for FizzBuzz
        assertEquals("14", FizzBuzz.fizzBuzz(14)); // Just before FizzBuzz
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15)); // Boundary for FizzBuzz
        assertEquals("16", FizzBuzz.fizzBuzz(16)); // Just after FizzBuzz
    }

    // Tests for corrected version
    @Test
    void testCorrectedFizz() {
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(6));
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(9));
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(12));
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(18));
    }

    @Test
    void testCorrectedBuzz() {
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(20));
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(25));
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(35));
    }

    @Test
    void testCorrectedFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(30));
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(45));
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(60));
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(75));
    }

    @Test
    void testCorrectedNumbers() {
        assertEquals("1", FizzBuzzCorrection.fizzBuzz(1));
        assertEquals("2", FizzBuzzCorrection.fizzBuzz(2));
        assertEquals("4", FizzBuzzCorrection.fizzBuzz(4));
        assertEquals("7", FizzBuzzCorrection.fizzBuzz(7));
        assertEquals("8", FizzBuzzCorrection.fizzBuzz(8));
        assertEquals("11", FizzBuzzCorrection.fizzBuzz(11));
        assertEquals("13", FizzBuzzCorrection.fizzBuzz(13));
        assertEquals("14", FizzBuzzCorrection.fizzBuzz(14));
    }

    @Test
    void testCorrectedInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(-1));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(-3));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(-5));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(-15));
    }

    @Test
    void testCorrectedConditionBoundaries() {
        // Test around boundary conditions for Fizz
        assertEquals("2", FizzBuzzCorrection.fizzBuzz(2));  // Just before Fizz
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(3)); // Boundary for Fizz
        assertEquals("4", FizzBuzzCorrection.fizzBuzz(4));  // Just after Fizz
        
        // Test around boundary conditions for Buzz
        assertEquals("4", FizzBuzzCorrection.fizzBuzz(4));  // Just before Buzz
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(5)); // Boundary for Buzz
        assertEquals("6", FizzBuzzCorrection.fizzBuzz(6));  // Just after Buzz
        
        // Test around boundary conditions for FizzBuzz
        assertEquals("14", FizzBuzzCorrection.fizzBuzz(14)); // Just before FizzBuzz
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(15)); // Boundary for FizzBuzz
        assertEquals("16", FizzBuzzCorrection.fizzBuzz(16)); // Just after FizzBuzz
    }
}
