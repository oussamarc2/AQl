package org.emp.tp1.LineCoverageTest;

import org.emp.tp1.Palindrome_Correction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Palindrome_CorrectionTest {

    @Test
    void testPalindromeSimple() {
        Assertions.assertTrue(Palindrome_Correction.isPalindrome("kayak"));
    }

    @Test
    void testPalindromeWithSpacesAndCase() {
        assertTrue(Palindrome_Correction.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testNotPalindrome() {
        assertFalse(Palindrome_Correction.isPalindrome("bonjour"));
    }

    @Test
    void testEmptyString() {
        assertTrue(Palindrome_Correction.isPalindrome(""));
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome_Correction.isPalindrome(null));
    }

}