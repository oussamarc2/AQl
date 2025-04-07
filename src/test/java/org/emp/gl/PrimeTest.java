package org.emp.gl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrimeTest {

    @Test
    void isPrimeShouldReturnFalseForNumbersLessThan2() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(-5));
    }

    @Test
    void isPrimeShouldReturnTrueForPrimeNumbers() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(7));
        assertTrue(Prime.isPrime(11));
        assertTrue(Prime.isPrime(13));
    }

    @Test
    void isPrimeShouldReturnFalseForNonPrimeNumbers() {
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(8));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(10));
    }
}
