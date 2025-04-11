package org.emp.gl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void constructorShouldInitializeMatrixWithZeros() {
        Matrix matrix = new Matrix(2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertEquals(0, matrix.get(i, j));
            }
        }
    }

    @Test
    void setAndGetShouldWorkCorrectly() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 1, 5);
        assertEquals(5, matrix.get(0, 1));
    }

    @Test
    void addShouldModifyCurrentMatrix() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.set(0, 0, 1);
        m2.set(0, 0, 2);
        m1.add(m2);
        assertEquals(3, m1.get(0, 0));
    }

    @Test
    void multiplyShouldModifyCurrentMatrix() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.set(0, 0, 1); m1.set(0, 1, 2);
        m1.set(1, 0, 3); m1.set(1, 1, 4);
        m2.set(0, 0, 5); m2.set(0, 1, 6);
        m2.set(1, 0, 7); m2.set(1, 1, 8);
        m1.multiply(m2);
        assertEquals(19, m1.get(0, 0));
        assertEquals(22, m1.get(0, 1));
        assertEquals(43, m1.get(1, 0));
        assertEquals(50, m1.get(1, 1));
    }

    @Test
    void transposeShouldSwapRowsAndColumns() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 1, 3);
        matrix.set(1, 0, 5);
        matrix.transpose();
        assertEquals(3, matrix.get(1, 0));
        assertEquals(5, matrix.get(0, 1));
    }

    @Test
    void addShouldThrowOnSizeMismatch() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
    }

    @Test
    void multiplyShouldThrowOnSizeMismatch() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.multiply(m2));
    }
}
