package ConditionCoverageTest;

import org.example.exo1.Palindrome;
import org.example.exo1.PalindromeCorrection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {
    // Tests for buggy version
    @Test
    void testBuggyNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testBuggyEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void testBuggySingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void testBuggyValidPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void testBuggyValidPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testBuggyInvalidPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    void testBuggyInvalidPalindromeWithDifferentCases() {
        assertFalse(Palindrome.isPalindrome("Kayak"));
    }

    @Test
    void testBuggyPalindromeWithSpecialCharacters() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    // Tests for corrected version
    @Test
    void testCorrectedNullInput() {
        assertThrows(NullPointerException.class, () -> PalindromeCorrection.isPalindrome(null));
    }

    @Test
    void testCorrectedEmptyString() {
        assertTrue(PalindromeCorrection.isPalindrome(""));
    }

    @Test
    void testCorrectedSingleCharacter() {
        assertTrue(PalindromeCorrection.isPalindrome("a"));
    }

    @Test
    void testCorrectedValidPalindrome() {
        assertTrue(PalindromeCorrection.isPalindrome("kayak"));
    }

    @Test
    void testCorrectedValidPalindromeWithSpaces() {
        assertTrue(PalindromeCorrection.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testCorrectedInvalidPalindrome() {
        assertFalse(PalindromeCorrection.isPalindrome("hello"));
    }

    @Test
    void testCorrectedInvalidPalindromeWithDifferentCases() {
        assertFalse(PalindromeCorrection.isPalindrome("Kayak"));
    }

    @Test
    void testCorrectedPalindromeWithSpecialCharacters() {
        assertTrue(PalindromeCorrection.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
