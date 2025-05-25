package org.emp.gl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciShouldReturnZeroForNEqualZero() {
        assertEquals(0, Fibonacci.fibonacci(0));
    }

    @Test
    void fibonacciShouldReturnOneForNEqualOne() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void fibonacciShouldReturnCorrectValueForPositiveN() {
        assertEquals(1, Fibonacci.fibonacci(2));
        assertEquals(2, Fibonacci.fibonacci(3));
        assertEquals(3, Fibonacci.fibonacci(4));
        assertEquals(5, Fibonacci.fibonacci(5));
        assertEquals(8, Fibonacci.fibonacci(6));
    }

    @Test
    void fibonacciShouldThrowExceptionForNegativeN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
        assertEquals("n must be positive", exception.getMessage());
    }
}
