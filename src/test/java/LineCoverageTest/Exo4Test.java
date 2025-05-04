package LineCoverageTest;

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
}
