package org.example.game;

import org.example.game.exception.JeuFermeException;
import org.example.game.exception.DebitImpossibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JeuTest {

    @Mock
    private Banque banque;

    @Mock
    private Joueur joueur;

    @Mock
    private De de1;

    @Mock
    private De de2;

    private Jeu jeu;

    @BeforeEach
    void setUp() {
        jeu = new Jeu(banque);
    }

    @Test
    @DisplayName("Test jeu fermé")
    void testJeuFerme() {
        // Given
        jeu.fermer();

        // When & Then
        JeuFermeException exception = assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(joueur, de1, de2);
        });

        assertEquals("Le jeu est fermé", exception.getMessage());
        verifyNoInteractions(joueur, de1, de2, banque);
    }

    @Test
    @DisplayName("Test joueur insolvable")
    void testJoueurInsolvable() throws DebitImpossibleException {
        // Given
        int mise = 100;
        when(joueur.mise()).thenReturn(mise);
        doThrow(new DebitImpossibleException("Solde insuffisant")).when(joueur).debiter(mise);

        // When & Then
        assertDoesNotThrow(() -> jeu.jouer(joueur, de1, de2));

        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verifyNoMoreInteractions(joueur);
        verifyNoInteractions(de1, de2, banque);
    }

    @Test
    @DisplayName("Test pari perdant")
    void testPariPerdant() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = 100;
        when(joueur.mise()).thenReturn(mise);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(3);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(banque).crediter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verifyNoMoreInteractions(joueur, banque);
        assertTrue(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test pari gagnant")
    void testPariGagnant() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = 100;
        int gain = mise * 2;
        when(joueur.mise()).thenReturn(mise);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        when(banque.est_solvable()).thenReturn(true);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(banque).crediter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur).crediter(gain);
        verify(banque).debiter(gain);
        verify(banque).est_solvable();
        assertTrue(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test banque insolvable après gain")
    void testBanqueInsolvableApresGain() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = 100;
        int gain = mise * 2;
        when(joueur.mise()).thenReturn(mise);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        when(banque.est_solvable()).thenReturn(false);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(banque).crediter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur).crediter(gain);
        verify(banque).debiter(gain);
        verify(banque).est_solvable();
        assertFalse(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test mise nulle")
    void testMiseNulle() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = 0;
        when(joueur.mise()).thenReturn(mise);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(banque).crediter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verifyNoMoreInteractions(joueur, banque);
        assertTrue(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test mise négative")
    void testMiseNegative() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = -50;
        when(joueur.mise()).thenReturn(mise);

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            jeu.jouer(joueur, de1, de2);
        });

        verify(joueur).mise();
        verifyNoMoreInteractions(joueur);
        verifyNoInteractions(de1, de2, banque);
    }

    @Test
    @DisplayName("Test banque null")
    void testBanqueNull() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            new Jeu(null);
        });
    }

    @Test
    @DisplayName("Test joueur null")
    void testJoueurNull() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            jeu.jouer(null, de1, de2);
        });
    }

    @Test
    @DisplayName("Test dé null")
    void testDeNull() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            jeu.jouer(joueur, null, de2);
        });
    }
} 