package ConditionCoverageTest;

import org.example.exo5.RomanNumeral;
import org.example.exo5.RomanNumeralCorrection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo5Test {
    // Tests for buggy version
    @Test
    void testBuggyBasicNumbers() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("X", RomanNumeral.toRoman(10));
        assertEquals("L", RomanNumeral.toRoman(50));
        assertEquals("C", RomanNumeral.toRoman(100));
        assertEquals("D", RomanNumeral.toRoman(500));
        assertEquals("M", RomanNumeral.toRoman(1000));
    }

    @Test
    void testBuggyCompositeNumbers() {
        assertEquals("III", RomanNumeral.toRoman(3));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("VI", RomanNumeral.toRoman(6));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XI", RomanNumeral.toRoman(11));
    }

    @Test
    void testBuggyComplexNumbers() {
        assertEquals("XLV", RomanNumeral.toRoman(45));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("CM", RomanNumeral.toRoman(900));
        assertEquals("MCMXCIX", RomanNumeral.toRoman(1999));
    }

    @Test
    void testBuggyInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testBuggyEdgeCases() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("MMM", RomanNumeral.toRoman(3000));
    }

    @Test
    void testBuggySubtractiveNotation() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("CM", RomanNumeral.toRoman(900));
    }

    @Test
    void testBuggyAdditiveNotation() {
        assertEquals("III", RomanNumeral.toRoman(3));
        assertEquals("VII", RomanNumeral.toRoman(7));
        assertEquals("XIII", RomanNumeral.toRoman(13));
        assertEquals("LXX", RomanNumeral.toRoman(70));
        assertEquals("CC", RomanNumeral.toRoman(200));
        assertEquals("MM", RomanNumeral.toRoman(2000));
    }

    @Test
    void testBuggyConditionBoundaries() {
        // Test around boundary conditions for subtractive notation
        assertEquals("III", RomanNumeral.toRoman(3));  // Just before IV
        assertEquals("IV", RomanNumeral.toRoman(4));   // Boundary for subtractive notation
        assertEquals("V", RomanNumeral.toRoman(5));    // Just after IV
        
        assertEquals("VIII", RomanNumeral.toRoman(8)); // Just before IX
        assertEquals("IX", RomanNumeral.toRoman(9));   // Boundary for subtractive notation
        assertEquals("X", RomanNumeral.toRoman(10));   // Just after IX
        
        assertEquals("XXXIX", RomanNumeral.toRoman(39)); // Just before XL
        assertEquals("XL", RomanNumeral.toRoman(40));    // Boundary for subtractive notation
        assertEquals("XLI", RomanNumeral.toRoman(41));   // Just after XL
    }

    // Tests for corrected version
    @Test
    void testCorrectedBasicNumbers() {
        assertEquals("I", RomanNumeralCorrection.toRoman(1));
        assertEquals("V", RomanNumeralCorrection.toRoman(5));
        assertEquals("X", RomanNumeralCorrection.toRoman(10));
        assertEquals("L", RomanNumeralCorrection.toRoman(50));
        assertEquals("C", RomanNumeralCorrection.toRoman(100));
        assertEquals("D", RomanNumeralCorrection.toRoman(500));
        assertEquals("M", RomanNumeralCorrection.toRoman(1000));
    }

    @Test
    void testCorrectedCompositeNumbers() {
        assertEquals("III", RomanNumeralCorrection.toRoman(3));
        assertEquals("IV", RomanNumeralCorrection.toRoman(4));
        assertEquals("VI", RomanNumeralCorrection.toRoman(6));
        assertEquals("IX", RomanNumeralCorrection.toRoman(9));
        assertEquals("XI", RomanNumeralCorrection.toRoman(11));
    }

    @Test
    void testCorrectedComplexNumbers() {
        assertEquals("XLV", RomanNumeralCorrection.toRoman(45));
        assertEquals("XC", RomanNumeralCorrection.toRoman(90));
        assertEquals("CD", RomanNumeralCorrection.toRoman(400));
        assertEquals("CM", RomanNumeralCorrection.toRoman(900));
        assertEquals("MCMXCIX", RomanNumeralCorrection.toRoman(1999));
    }

    @Test
    void testCorrectedInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(4000));
    }

    @Test
    void testCorrectedEdgeCases() {
        assertEquals("MMMCMXCIX", RomanNumeralCorrection.toRoman(3999));
        assertEquals("I", RomanNumeralCorrection.toRoman(1));
        assertEquals("MMM", RomanNumeralCorrection.toRoman(3000));
    }

    @Test
    void testCorrectedSubtractiveNotation() {
        assertEquals("IV", RomanNumeralCorrection.toRoman(4));
        assertEquals("IX", RomanNumeralCorrection.toRoman(9));
        assertEquals("XL", RomanNumeralCorrection.toRoman(40));
        assertEquals("XC", RomanNumeralCorrection.toRoman(90));
        assertEquals("CD", RomanNumeralCorrection.toRoman(400));
        assertEquals("CM", RomanNumeralCorrection.toRoman(900));
    }

    @Test
    void testCorrectedAdditiveNotation() {
        assertEquals("III", RomanNumeralCorrection.toRoman(3));
        assertEquals("VII", RomanNumeralCorrection.toRoman(7));
        assertEquals("XIII", RomanNumeralCorrection.toRoman(13));
        assertEquals("LXX", RomanNumeralCorrection.toRoman(70));
        assertEquals("CC", RomanNumeralCorrection.toRoman(200));
        assertEquals("MM", RomanNumeralCorrection.toRoman(2000));
    }

    @Test
    void testCorrectedConditionBoundaries() {
        // Test around boundary conditions for subtractive notation
        assertEquals("III", RomanNumeralCorrection.toRoman(3));  // Just before IV
        assertEquals("IV", RomanNumeralCorrection.toRoman(4));   // Boundary for subtractive notation
        assertEquals("V", RomanNumeralCorrection.toRoman(5));    // Just after IV
        
        assertEquals("VIII", RomanNumeralCorrection.toRoman(8)); // Just before IX
        assertEquals("IX", RomanNumeralCorrection.toRoman(9));   // Boundary for subtractive notation
        assertEquals("X", RomanNumeralCorrection.toRoman(10));   // Just after IX
        
        assertEquals("XXXIX", RomanNumeralCorrection.toRoman(39)); // Just before XL
        assertEquals("XL", RomanNumeralCorrection.toRoman(40));    // Boundary for subtractive notation
        assertEquals("XLI", RomanNumeralCorrection.toRoman(41));   // Just after XL
    }
}
