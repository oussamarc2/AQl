package org.example.service;

import org.example.api.UtilisateurApi;
import org.example.model.Utilisateur;
import org.example.exception.ServiceException;

public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
    }

    /**
     * Récupère un utilisateur par son identifiant
     * @param id l'identifiant de l'utilisateur
     * @return l'utilisateur correspondant à l'identifiant
     * @throws ServiceException si l'utilisateur n'existe pas ou en cas d'erreur
     */
    public Utilisateur getUserById(Long id) throws ServiceException {
        if (id == null) {
            throw new ServiceException("L'identifiant ne peut pas être null");
        }
        if (id < 0) {
            throw new ServiceException("L'identifiant ne peut pas être négatif");
        }
        
        Utilisateur utilisateur = utilisateurApi.getUserById(id);
        if (utilisateur == null) {
            throw new ServiceException("Utilisateur non trouvé avec l'id: " + id);
        }
        return utilisateur;
    }
} 