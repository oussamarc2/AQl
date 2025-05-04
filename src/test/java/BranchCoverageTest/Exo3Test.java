package BranchCoverageTest;

import org.example.exo3.BinarySearch;
import org.example.exo3.BinarySearchCorrection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo3Test {
    // Tests for buggy version
    @Test
    void testBuggyNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    @Test
    void testBuggyEmptyArray() {
        int[] array = {};
        assertEquals(-1, BinarySearch.binarySearch(array, 5));
    }

    @Test
    void testBuggySingleElementArray() {
        int[] array = {5};
        assertEquals(0, BinarySearch.binarySearch(array, 5));
        assertEquals(-1, BinarySearch.binarySearch(array, 3));
    }

    @Test
    void testBuggyElementFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(array, 5));
    }

    @Test
    void testBuggyElementNotFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(array, 4));
    }

    @Test
    void testBuggyElementAtStart() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(array, 1));
    }

    @Test
    void testBuggyElementAtEnd() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(4, BinarySearch.binarySearch(array, 9));
    }

    @Test
    void testBuggyElementInMiddle() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(array, 5));
    }

    @Test
    void testBuggyElementLessThanAll() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(array, 0));
    }

    @Test
    void testBuggyElementGreaterThanAll() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(array, 10));
    }

    // Tests for corrected version
    @Test
    void testCorrectedNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearchCorrection.binarySearch(null, 5));
    }

    @Test
    void testCorrectedEmptyArray() {
        int[] array = {};
        assertEquals(-1, BinarySearchCorrection.binarySearch(array, 5));
    }

    @Test
    void testCorrectedSingleElementArray() {
        int[] array = {5};
        assertEquals(0, BinarySearchCorrection.binarySearch(array, 5));
        assertEquals(-1, BinarySearchCorrection.binarySearch(array, 3));
    }

    @Test
    void testCorrectedElementFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearchCorrection.binarySearch(array, 5));
    }

    @Test
    void testCorrectedElementNotFound() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearchCorrection.binarySearch(array, 4));
    }

    @Test
    void testCorrectedElementAtStart() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearchCorrection.binarySearch(array, 1));
    }

    @Test
    void testCorrectedElementAtEnd() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(4, BinarySearchCorrection.binarySearch(array, 9));
    }

    @Test
    void testCorrectedElementInMiddle() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearchCorrection.binarySearch(array, 5));
    }

    @Test
    void testCorrectedElementLessThanAll() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearchCorrection.binarySearch(array, 0));
    }

    @Test
    void testCorrectedElementGreaterThanAll() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearchCorrection.binarySearch(array, 10));
    }
}
