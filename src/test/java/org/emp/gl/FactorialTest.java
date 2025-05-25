package org.emp.gl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorialShouldReturnOneForZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void factorialShouldReturnCorrectValuesForPositiveNumbers() {
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void factorialShouldThrowExceptionForNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
        assertEquals("n must be positive", exception.getMessage());
    }
}
