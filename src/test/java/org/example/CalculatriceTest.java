package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatriceTest {
    private Calculatrice calculatrice;

    @BeforeEach
    void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    @DisplayName("Test addition de deux nombres positifs")
    void testAdditionnerNombresPositifs() {
        // Given
        int a = 2;
        int b = 3;
        int expected = 5;

        // When
        int result = calculatrice.additionner(a, b);

        // Then
        assertEquals(expected, result, "L'addition de " + a + " et " + b + " devrait donner " + expected);
        assertEquals(expected, calculatrice.getResult(), "Le résultat stocké devrait être " + expected);
    }

    @Test
    @DisplayName("Test addition avec zéro")
    void testAdditionnerAvecZero() {
        // Given
        int a = 0;
        int b = 5;
        int expected = 5;

        // When
        int result = calculatrice.additionner(a, b);

        // Then
        assertEquals(expected, result, "L'addition de " + a + " et " + b + " devrait donner " + expected);
    }

    @Test
    @DisplayName("Test addition de nombres négatifs")
    void testAdditionnerNombresNegatifs() {
        // Given
        int a = -2;
        int b = -3;
        int expected = -5;

        // When
        int result = calculatrice.additionner(a, b);

        // Then
        assertEquals(expected, result, "L'addition de " + a + " et " + b + " devrait donner " + expected);
    }

    @Test
    @DisplayName("Test addition avec nombres maximaux")
    void testAdditionnerNombresMaximaux() {
        // Given
        int a = Integer.MAX_VALUE;
        int b = 1;

        // When & Then
        assertThrows(ArithmeticException.class, () -> {
            calculatrice.additionner(a, b);
        }, "L'addition devrait lever une exception en cas de dépassement");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "2, 3, 5",
        "0, 0, 0",
        "-1, 1, 0",
        "10, -5, 5",
        "100, 200, 300"
    })
    @DisplayName("Test addition avec plusieurs cas")
    void testAdditionnerParametre(int a, int b, int expected) {
        // When
        int result = calculatrice.additionner(a, b);

        // Then
        assertEquals(expected, result, () -> String.format("%d + %d devrait donner %d", a, b, expected));
    }

    @Test
    @DisplayName("Test état initial de la calculatrice")
    void testEtatInitial() {
        // Then
        assertEquals(0, calculatrice.getResult(), "Le résultat initial devrait être 0");
    }
} 