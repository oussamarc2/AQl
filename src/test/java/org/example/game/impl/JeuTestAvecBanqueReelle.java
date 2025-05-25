package org.example.game.impl;

import org.example.game.Jeu;
import org.example.game.Joueur;
import org.example.game.De;
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
public class JeuTestAvecBanqueReelle {

    @Mock
    private Joueur joueur;

    @Mock
    private De de1;

    @Mock
    private De de2;

    private Jeu jeu;
    private BanqueImpl banque;
    private static final int FOND_INITIAL = 1000;
    private static final int FOND_MINIMUM = 500;

    @BeforeEach
    void setUp() {
        banque = new BanqueImpl(FOND_INITIAL, FOND_MINIMUM);
        jeu = new Jeu(banque);
    }

    @Test
    @DisplayName("Test pari gagnant avec banque réelle")
    void testPariGagnantAvecBanqueReelle() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = 100;
        when(joueur.mise()).thenReturn(mise);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur).crediter(mise * 2);
        
        assertEquals(FOND_INITIAL - mise, banque.getFond());
        assertTrue(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test banque insolvable après gain avec banque réelle")
    void testBanqueInsolvableApresGainAvecBanqueReelle() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise = 300;
        when(joueur.mise()).thenReturn(mise);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur).crediter(mise * 2);
        
        assertEquals(FOND_INITIAL - mise, banque.getFond());
        assertFalse(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test plusieurs paris consécutifs")
    void testPlusieursParisConsecutifs() throws DebitImpossibleException, JeuFermeException {
        // Given
        int mise1 = 50;
        int mise2 = 75;
        when(joueur.mise())
            .thenReturn(mise1)
            .thenReturn(mise2);
        when(de1.lancer())
            .thenReturn(3)
            .thenReturn(2);
        when(de2.lancer())
            .thenReturn(4)
            .thenReturn(5);

        // When
        jeu.jouer(joueur, de1, de2); // Premier pari gagnant
        jeu.jouer(joueur, de1, de2); // Deuxième pari perdant

        // Then
        verify(joueur, times(2)).mise();
        verify(joueur).debiter(mise1);
        verify(joueur).debiter(mise2);
        verify(joueur).crediter(mise1 * 2);
        verify(de1, times(2)).lancer();
        verify(de2, times(2)).lancer();
        
        assertEquals(FOND_INITIAL - mise1 + mise2, banque.getFond());
        assertTrue(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test banque avec fond initial minimal")
    void testBanqueAvecFondInitialMinimal() throws DebitImpossibleException, JeuFermeException {
        // Given
        banque = new BanqueImpl(FOND_MINIMUM, FOND_MINIMUM);
        jeu = new Jeu(banque);
        int mise = 1;
        when(joueur.mise()).thenReturn(mise);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);

        // When
        jeu.jouer(joueur, de1, de2);

        // Then
        verify(joueur).mise();
        verify(joueur).debiter(mise);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur).crediter(mise * 2);
        
        assertEquals(FOND_MINIMUM - mise, banque.getFond());
        assertFalse(jeu.estOuvert());
    }

    @Test
    @DisplayName("Test banque avec fond initial insuffisant")
    void testBanqueAvecFondInitialInsuffisant() {
        // Given
        int fondInitial = FOND_MINIMUM - 1;

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            new BanqueImpl(fondInitial, FOND_MINIMUM);
        });
    }
} 