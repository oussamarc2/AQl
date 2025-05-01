package org.example.service;

import org.example.api.UtilisateurApi;
import org.example.model.Utilisateur;
import org.example.exception.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    private UserService userService;
    private Utilisateur utilisateurValide;

    @BeforeEach
    void setUp() {
        userService = new UserService(utilisateurApiMock);
        utilisateurValide = new Utilisateur("Jean", "Dupont", "jean.dupont@email.com");
    }

    @Test
    @DisplayName("Test création d'utilisateur valide")
    void testCreerUtilisateurValide() throws ServiceException {
        // Given
        doNothing().when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        // When
        userService.creerUtilisateur(utilisateurValide);

        // Then
        verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateurValide);
        verifyNoMoreInteractions(utilisateurApiMock);
    }

    @Test
    @DisplayName("Test création d'utilisateur avec email invalide")
    void testCreerUtilisateurEmailInvalide() throws ServiceException {
        // Given
        Utilisateur utilisateurInvalide = new Utilisateur("Jean", "Dupont", "email_invalide");

        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateurInvalide);
        });

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    @Test
    @DisplayName("Test création d'utilisateur avec nom vide")
    void testCreerUtilisateurNomVide() throws ServiceException {
        // Given
        Utilisateur utilisateurInvalide = new Utilisateur("", "Dupont", "jean.dupont@email.com");

        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateurInvalide);
        });

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    @Test
    @DisplayName("Test création d'utilisateur avec prénom vide")
    void testCreerUtilisateurPrenomVide() throws ServiceException {
        // Given
        Utilisateur utilisateurInvalide = new Utilisateur("Jean", "", "jean.dupont@email.com");

        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateurInvalide);
        });

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    @Test
    @DisplayName("Test création d'utilisateur avec API en erreur")
    void testCreerUtilisateurApiErreur() throws ServiceException {
        // Given
        doThrow(new ServiceException("Erreur API")).when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        // When & Then
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateurValide);
        });

        assertEquals("Erreur API", exception.getMessage());
        verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateurValide);
    }

    @Test
    @DisplayName("Test création d'utilisateur avec capture d'arguments")
    void testCreerUtilisateurAvecCapture() throws ServiceException {
        // Given
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        doNothing().when(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        // When
        userService.creerUtilisateur(utilisateurValide);

        // Then
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("Jean", utilisateurCapture.getNom());
        assertEquals("Dupont", utilisateurCapture.getPrenom());
        assertEquals("jean.dupont@email.com", utilisateurCapture.getEmail());
    }

    @Test
    @DisplayName("Test création d'utilisateur avec email null")
    void testCreerUtilisateurEmailNull() throws ServiceException {
        // Given
        Utilisateur utilisateurInvalide = new Utilisateur("Jean", "Dupont", null);

        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateurInvalide);
        });

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    @Test
    @DisplayName("Test création d'utilisateur avec caractères spéciaux")
    void testCreerUtilisateurCaracteresSpeciaux() throws ServiceException {
        // Given
        Utilisateur utilisateurInvalide = new Utilisateur("Jean@", "Dupont!", "jean.dupont@email.com");

        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateurInvalide);
        });

        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    @Test
    @DisplayName("Test récupération d'utilisateur existant")
    void testGetUserByIdExistant() throws ServiceException {
        // Given
        when(utilisateurApiMock.getUserById(1L)).thenReturn(utilisateurValide);

        // When
        Utilisateur result = userService.getUserById(1L);

        // Then
        assertNotNull(result);
        assertEquals(utilisateurValide, result);
        verify(utilisateurApiMock, times(1)).getUserById(1L);
    }

    @Test
    @DisplayName("Test récupération d'utilisateur inexistant")
    void testGetUserByIdInexistant() throws ServiceException {
        // Given
        when(utilisateurApiMock.getUserById(999L)).thenReturn(null);

        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.getUserById(999L);
        });
        verify(utilisateurApiMock, times(1)).getUserById(999L);
    }

    @Test
    @DisplayName("Test récupération d'utilisateur avec ID null")
    void testGetUserByIdNull() throws ServiceException {
        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.getUserById(null);
        });
        verify(utilisateurApiMock, never()).getUserById(any());
    }

    @Test
    @DisplayName("Test récupération d'utilisateur avec erreur API")
    void testGetUserByIdErreurApi() throws ServiceException {
        // Given
        when(utilisateurApiMock.getUserById(1L)).thenThrow(new ServiceException("Erreur API"));

        // When & Then
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.getUserById(1L);
        });
        assertEquals("Erreur API", exception.getMessage());
        verify(utilisateurApiMock, times(1)).getUserById(1L);
    }

    @Test
    @DisplayName("Test récupération d'utilisateur avec ID négatif")
    void testGetUserByIdNegatif() throws ServiceException {
        // When & Then
        assertThrows(ServiceException.class, () -> {
            userService.getUserById(-1L);
        });
        verify(utilisateurApiMock, never()).getUserById(any());
    }
} 