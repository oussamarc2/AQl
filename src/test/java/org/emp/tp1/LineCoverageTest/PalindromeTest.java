package org.emp.tp1.LineCoverageTest;


import org.emp.tp1.Palindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PalindromeTest {

        @Test
        void testPalindromeSimple() {
            Assertions.assertTrue(Palindrome.isPalindrome("kayak"));
        }

        @Test
        void testPalindromeWithSpacesAndCase() {
            assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
        }

        @Test
        void testNotPalindrome() {
            assertFalse(Palindrome.isPalindrome("bonjour"));
        }

        @Test
        void testEmptyString() {
            assertTrue(Palindrome.isPalindrome(""));
        }

        @Test
        void testNullInput() {
            assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
        }
    }
