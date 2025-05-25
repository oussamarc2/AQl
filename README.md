# User Management Service

A Java-based user management service that provides functionality for creating and retrieving users with proper validation and error handling.

## Project Structure

```
src/
├── main/java/org/example/
│   ├── api/
│   │   └── UtilisateurApi.java
│   ├── model/
│   │   └── Utilisateur.java
│   ├── service/
│   │   └── UserService.java
│   └── exception/
│       └── ServiceException.java
└── test/java/org/example/
    └── service/
        └── UserServiceTest.java
```

## Features

- User creation with validation
- User retrieval by ID
- Comprehensive input validation
- Error handling with custom exceptions
- Unit testing with JUnit 5 and Mockito

## Prerequisites

- Java 8 or higher
- Maven

## Dependencies

- JUnit 5
- Mockito
- Maven

## Getting Started

1. Clone the repository
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the tests:
   ```bash
   mvn test
   ```

## Usage

### Creating a User

```java
UserService userService = new UserService(utilisateurApi);
Utilisateur user = new Utilisateur("John", "Doe", "john.doe@email.com");
userService.creerUtilisateur(user);
```

### Retrieving a User

```java
UserService userService = new UserService(utilisateurApi);
Utilisateur user = userService.getUserById(1L);
```

## Validation Rules

The service implements the following validation rules:

- Email must be in a valid format
- First name and last name cannot be empty
- First name and last name cannot contain special characters
- User ID must be positive

## Error Handling

The service throws `ServiceException` in the following cases:

- Invalid user data
- API errors
- User not found
- Invalid user ID

## Tests

Le projet inclut des tests unitaires complets couvrant :

- Création d'utilisateur valide
- Gestion des données utilisateur invalides
- Scénarios d'erreur API
- Récupération d'utilisateur
- Cas limites

### Scénarios de Test et Classes d'Équivalence

#### Tests de Création d'Utilisateur
1. Cas Valides :
   - Données utilisateur complètes et valides
   - Utilisateur avec champs minimaux requis
   - Utilisateur avec champs de longueur maximale

2. Cas Invalides :
   - Champs vides
   - Format d'email invalide
   - Caractères spéciaux dans le nom
   - Valeurs nulles
   - Longueur maximale dépassée

#### Tests de Récupération d'Utilisateur
1. Cas d'ID Valides :
   - ID d'utilisateur existant
   - Premier ID d'utilisateur
   - Dernier ID d'utilisateur

2. Cas d'ID Invalides :
   - ID inexistant
   - ID négatif
   - ID nul
   - ID zéro

#### Tests de Logique de Jeu
1. Tests de Solvabilité du Joueur :
   - Fonds suffisants
   - Fonds insuffisants (insolvabilité)
   - Montant exact requis
   - Solde à zéro

2. Tests de Lancer de Dés :
   - Il s'agit d'un test d'interactions plutôt que d'état
   - Nous vérifions que la logique du jeu ne modifie pas les dés
   - Approche d'implémentation :
     ```java
     @Test
     void testIntegriteDesDes() {
         // Étant donné
         De deOriginal = new De();
         int valeurOriginale = deOriginal.getValeur();
         
         // Quand
         jeu.jouer(deOriginal);
         
         // Alors
         assertEquals(valeurOriginale, deOriginal.getValeur(), 
             "La valeur du dé ne devrait pas être modifiée par le jeu");
     }
     ```

3. Tests d'État du Jeu :
   - État initial
   - Après une partie réussie
   - Après une partie échouée
   - Après plusieurs parties
   - Condition de fin de jeu

### Stratégie de Test

1. Tests d'État :
   - Utilisés pour vérifier l'état final des objets
   - Exemple : Vérification du solde du joueur après une transaction
   - Exemple : Vérification de la persistance des données utilisateur

2. Tests d'Interactions :
   - Utilisés pour vérifier le comportement entre les composants
   - Exemple : Vérification de l'intégrité des dés
   - Exemple : Vérification des appels API
   - Implémentation avec Mockito :
     ```java
     @Test
     void testInteractionJeuDes() {
         // Étant donné
         De de = mock(De.class);
         when(de.lancer()).thenReturn(6);
         
         // Quand
         jeu.jouer(de);
         
         // Alors
         verify(de, times(1)).lancer();
         verifyNoMoreInteractions(de);
     }
     ```

### Directives d'Implémentation des Tests

1. Utiliser des noms de test descriptifs qui expliquent le scénario
2. Suivre le pattern Given-When-Then (Étant donné-Quand-Alors)
3. Tester un scénario spécifique par méthode de test
4. Utiliser les assertions appropriées selon le type de test
5. Simuler les dépendances externes
6. Vérifier à la fois l'état et les interactions lorsque c'est approprié

Exécuter les tests avec :
```bash
mvn test
```

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 
