package ConditionCoverageTest;

import org.example.exo2.Anagram;
import org.example.exo2.AnagramCorrection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {
    // Tests for buggy version
    @Test
    void testBuggyNullInput() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    @Test
    void testBuggyEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    void testBuggyDifferentLengths() {
        assertFalse(Anagram.isAnagram("hello", "hell"));
    }

    @Test
    void testBuggyValidAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
    }

    @Test
    void testBuggyValidAnagramWithSpaces() {
        assertTrue(Anagram.isAnagram("debit card", "bad credit"));
    }

    @Test
    void testBuggyValidAnagramWithDifferentCases() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
    }

    @Test
    void testBuggyInvalidAnagram() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }

    @Test
    void testBuggyAnagramWithSpecialCharacters() {
        assertTrue(Anagram.isAnagram("dormitory", "dirty room"));
    }

    @Test
    void testBuggyAnagramWithRepeatedCharacters() {
        assertTrue(Anagram.isAnagram("aabbcc", "ccbbaa"));
    }

    @Test
    void testBuggyAnagramWithNonAlphabeticCharacters() {
        assertTrue(Anagram.isAnagram("a1b2c3", "3c2b1a"));
    }

    @Test
    void testBuggyAnagramWithMixedCharacters() {
        assertTrue(Anagram.isAnagram("A1B2C3", "3c2b1a"));
    }

    // Tests for corrected version
    @Test
    void testCorrectedNullInput() {
        assertThrows(NullPointerException.class, () -> AnagramCorrection.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> AnagramCorrection.isAnagram("test", null));
        assertThrows(NullPointerException.class, () -> AnagramCorrection.isAnagram(null, null));
    }

    @Test
    void testCorrectedEmptyStrings() {
        assertTrue(AnagramCorrection.isAnagram("", ""));
    }

    @Test
    void testCorrectedDifferentLengths() {
        assertFalse(AnagramCorrection.isAnagram("hello", "hell"));
    }

    @Test
    void testCorrectedValidAnagram() {
        assertTrue(AnagramCorrection.isAnagram("listen", "silent"));
    }

    @Test
    void testCorrectedValidAnagramWithSpaces() {
        assertTrue(AnagramCorrection.isAnagram("debit card", "bad credit"));
    }

    @Test
    void testCorrectedValidAnagramWithDifferentCases() {
        assertTrue(AnagramCorrection.isAnagram("Listen", "Silent"));
    }

    @Test
    void testCorrectedInvalidAnagram() {
        assertFalse(AnagramCorrection.isAnagram("hello", "world"));
    }

    @Test
    void testCorrectedAnagramWithSpecialCharacters() {
        assertTrue(AnagramCorrection.isAnagram("dormitory", "dirty room"));
    }

    @Test
    void testCorrectedAnagramWithRepeatedCharacters() {
        assertTrue(AnagramCorrection.isAnagram("aabbcc", "ccbbaa"));
    }

    @Test
    void testCorrectedAnagramWithNonAlphabeticCharacters() {
        assertTrue(AnagramCorrection.isAnagram("a1b2c3", "3c2b1a"));
    }

    @Test
    void testCorrectedAnagramWithMixedCharacters() {
        assertTrue(AnagramCorrection.isAnagram("A1B2C3", "3c2b1a"));
    }
}
