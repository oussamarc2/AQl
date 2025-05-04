package LineCoverageTest;

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
    }

    @Test
    void testBuggyBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
    }

    @Test
    void testBuggyFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    @Test
    void testBuggyNumbers() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("4", FizzBuzz.fizzBuzz(4));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
        assertEquals("8", FizzBuzz.fizzBuzz(8));
    }

    @Test
    void testBuggyInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
    }

    // Tests for corrected version
    @Test
    void testCorrectedFizz() {
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(6));
        assertEquals("Fizz", FizzBuzzCorrection.fizzBuzz(9));
    }

    @Test
    void testCorrectedBuzz() {
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzzCorrection.fizzBuzz(20));
    }

    @Test
    void testCorrectedFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(30));
        assertEquals("FizzBuzz", FizzBuzzCorrection.fizzBuzz(45));
    }

    @Test
    void testCorrectedNumbers() {
        assertEquals("1", FizzBuzzCorrection.fizzBuzz(1));
        assertEquals("2", FizzBuzzCorrection.fizzBuzz(2));
        assertEquals("4", FizzBuzzCorrection.fizzBuzz(4));
        assertEquals("7", FizzBuzzCorrection.fizzBuzz(7));
        assertEquals("8", FizzBuzzCorrection.fizzBuzz(8));
    }

    @Test
    void testCorrectedInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzCorrection.fizzBuzz(-1));
    }
}
