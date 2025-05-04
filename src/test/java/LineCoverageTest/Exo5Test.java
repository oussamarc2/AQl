package LineCoverageTest;

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
}
