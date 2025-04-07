package org.emp.tp1.BranchCoverageTest;

import org.emp.tp1.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PalindromeTest {
    @Test
    void testPalindromeBranchTrue() {
        assertTrue(Palindrome.isPalindrome("Kayak"));
    }

    @Test
    void testBranchFalse() {
        assertFalse(Palindrome.isPalindrome("test"));
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

}