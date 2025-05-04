package ConditionCoverageTest;

import org.example.exo4.QuadraticEquation;
import org.example.exo4.QuadraticEquationCorrection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo4Test {
    // Tests for buggy version
    @Test
    void testBuggyNoRealRoots() {
        double[] roots = QuadraticEquation.solve(1, 2, 3);
        assertNull(roots);
    }

    @Test
    void testBuggyOneRealRoot() {
        double[] roots = QuadraticEquation.solve(1, -2, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertEquals(1.0, roots[0], 0.0001);
    }

    @Test
    void testBuggyTwoRealRoots() {
        double[] roots = QuadraticEquation.solve(1, -3, 2);
        assertNotNull(roots);
        assertEquals(2, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
        assertEquals(1.0, roots[1], 0.0001);
    }

    @Test
    void testBuggyLinearEquation() {
        double[] roots = QuadraticEquation.solve(0, 2, -4);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
    }

    @Test
    void testBuggyConstantEquation() {
        double[] roots = QuadraticEquation.solve(0, 0, 5);
        assertNull(roots);
    }

    @Test
    void testBuggyZeroLinearEquation() {
        double[] roots = QuadraticEquation.solve(0, 0, 0);
        assertNull(roots);
    }

    @Test
    void testBuggyNegativeDiscriminant() {
        double[] roots = QuadraticEquation.solve(1, 1, 1);
        assertNull(roots);
    }

    @Test
    void testBuggyZeroDiscriminant() {
        double[] roots = QuadraticEquation.solve(1, -2, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertEquals(1.0, roots[0], 0.0001);
    }

    @Test
    void testBuggyPositiveDiscriminant() {
        double[] roots = QuadraticEquation.solve(1, -3, 2);
        assertNotNull(roots);
        assertEquals(2, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
        assertEquals(1.0, roots[1], 0.0001);
    }

    @Test
    void testBuggyEdgeCaseDiscriminant() {
        double[] roots = QuadraticEquation.solve(1, -2.0000001, 1);
        assertNotNull(roots);
        assertEquals(2, roots.length);
    }

    @Test
    void testBuggyEdgeCaseLinear() {
        double[] roots = QuadraticEquation.solve(0, 0.0000001, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
    }

    // Tests for corrected version
    @Test
    void testCorrectedNoRealRoots() {
        double[] roots = QuadraticEquationCorrection.solve(1, 2, 3);
        assertNull(roots);
    }

    @Test
    void testCorrectedOneRealRoot() {
        double[] roots = QuadraticEquationCorrection.solve(1, -2, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertEquals(1.0, roots[0], 0.0001);
    }

    @Test
    void testCorrectedTwoRealRoots() {
        double[] roots = QuadraticEquationCorrection.solve(1, -3, 2);
        assertNotNull(roots);
        assertEquals(2, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
        assertEquals(1.0, roots[1], 0.0001);
    }

    @Test
    void testCorrectedLinearEquation() {
        double[] roots = QuadraticEquationCorrection.solve(0, 2, -4);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
    }

    @Test
    void testCorrectedConstantEquation() {
        double[] roots = QuadraticEquationCorrection.solve(0, 0, 5);
        assertNull(roots);
    }

    @Test
    void testCorrectedZeroLinearEquation() {
        double[] roots = QuadraticEquationCorrection.solve(0, 0, 0);
        assertNull(roots);
    }

    @Test
    void testCorrectedNegativeDiscriminant() {
        double[] roots = QuadraticEquationCorrection.solve(1, 1, 1);
        assertNull(roots);
    }

    @Test
    void testCorrectedZeroDiscriminant() {
        double[] roots = QuadraticEquationCorrection.solve(1, -2, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertEquals(1.0, roots[0], 0.0001);
    }

    @Test
    void testCorrectedPositiveDiscriminant() {
        double[] roots = QuadraticEquationCorrection.solve(1, -3, 2);
        assertNotNull(roots);
        assertEquals(2, roots.length);
        assertEquals(2.0, roots[0], 0.0001);
        assertEquals(1.0, roots[1], 0.0001);
    }

    @Test
    void testCorrectedEdgeCaseDiscriminant() {
        double[] roots = QuadraticEquationCorrection.solve(1, -2.0000001, 1);
        assertNotNull(roots);
        assertEquals(2, roots.length);
    }

    @Test
    void testCorrectedEdgeCaseLinear() {
        double[] roots = QuadraticEquationCorrection.solve(0, 0.0000001, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
    }
}
