package org.example.api;

import org.example.model.Utilisateur;
import org.example.exception.ServiceException;

public interface UtilisateurApi {
    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;
    
    /**
     * Récupère un utilisateur par son identifiant
     * @param id l'identifiant de l'utilisateur
     * @return l'utilisateur correspondant à l'identifiant
     * @throws ServiceException si l'utilisateur n'existe pas ou en cas d'erreur
     */
    Utilisateur getUserById(Long id) throws ServiceException;
} 