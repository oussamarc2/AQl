# TP1 - Tests Unitaires et Couverture du Code

## Objectif
Ce projet vise à mettre en pratique les concepts de tests unitaires et de couverture de code en Java, en utilisant JUnit 5. Il comprend six exercices, chacun présentant des défis spécifiques en termes de tests et de couverture.

## Structure du Projet
```
src/
├── main/java/org/example/
│   ├── exo1/ (Palindrome)
│   ├── exo2/ (Anagram)
│   ├── exo3/ (BinarySearch)
│   ├── exo4/ (QuadraticEquation)
│   ├── exo5/ (RomanNumeral)
│   └── exo6/ (FizzBuzz)
└── test/java/
    ├── LineCoverageTest/
    ├── BranchCoverageTest/
    └── ConditionCoverageTest/
```

## Observations sur les Critères de Couverture

### Exercice 1 - Palindrome
- **Line Coverage vs Branch Coverage**: Les tests sont similaires car chaque ligne de code correspond à une branche unique.
- **Condition Coverage**: Ajoute des tests supplémentaires pour vérifier les conditions spécifiques (i < j, s.charAt(i) != s.charAt(j)).
- **Tests Spécifiques**:
  - Chaînes vides et null
  - Caractères spéciaux et espaces
  - Casse (majuscules/minuscules)
  - Palindromes pairs et impairs

### Exercice 2 - Anagram
- **Line Coverage vs Branch Coverage**: Les tests sont similaires car la structure du code est linéaire avec des conditions simples.
- **Condition Coverage**: Ajoute des tests supplémentaires pour les conditions (s1 == null, s2 == null, s1.length() != s2.length()).
- **Tests Spécifiques**:
  - Chaînes de longueurs différentes
  - Caractères spéciaux et espaces
  - Casse (majuscules/minuscules)
  - Caractères répétés

### Exercice 3 - BinarySearch
- **Line Coverage vs Branch Coverage**: Les tests sont similaires car chaque ligne correspond à une branche unique.
- **Condition Coverage**: Ajoute des tests supplémentaires pour les conditions (low <= high, array[mid] == element, array[mid] < element, array[mid] > element).
- **Tests Spécifiques**:
  - Tableaux null et vides
  - Tableaux à un élément
  - Éléments trouvés et non trouvés
  - Éléments aux limites du tableau

### Exercice 4 - QuadraticEquation
- **Line Coverage vs Branch Coverage**: Les tests sont similaires car la structure du code est linéaire avec des conditions simples.
- **Condition Coverage**: Ajoute des tests supplémentaires pour les conditions (a == 0, delta < 0, delta == 0, delta > 0).
- **Tests Spécifiques**:
  - Équations linéaires (a = 0)
  - Équations constantes (a = b = 0)
  - Discriminants négatifs, nuls et positifs
  - Cas limites du discriminant

### Exercice 5 - RomanNumeral
- **Line Coverage vs Branch Coverage**: Les tests sont similaires car la structure du code est linéaire avec des conditions simples.
- **Condition Coverage**: Ajoute des tests supplémentaires pour les conditions (n < 1, n > 3999, n >= values[i]).
- **Tests Spécifiques**:
  - Nombres de base (I, V, X, L, C, D, M)
  - Notation soustractive (IV, IX, XL, XC, CD, CM)
  - Notation additive (III, VII, XIII, etc.)
  - Cas limites (1, 3999)

### Exercice 6 - FizzBuzz
- **Line Coverage vs Branch Coverage**: Les tests sont similaires car la structure du code est linéaire avec des conditions simples.
- **Condition Coverage**: Ajoute des tests supplémentaires pour les conditions (n <= 0, n % 15 == 0, n % 3 == 0, n % 5 == 0).
- **Tests Spécifiques**:
  - Nombres divisibles par 3 (Fizz)
  - Nombres divisibles par 5 (Buzz)
  - Nombres divisibles par 3 et 5 (FizzBuzz)
  - Nombres non divisibles
  - Cas limites (0, nombres négatifs)

## Bugs Détectés et Corrections

### Exercice 1 - Palindrome
**Bug**: Dans la méthode `isPalindrome`, il y a une erreur dans l'incrémentation/décrémentation des indices :
```java
j++;  // devrait être j--
i--;  // devrait être i++
```

**Correction**: Voir `PalindromeCorrection.java`
- Gestion correcte des indices
- Gestion des caractères spéciaux et espaces
- Gestion de la casse
- Validation des entrées null et vides

### Exercice 2 - Anagram
**Bug**: Dans la méthode `isAnagram`, il y a une erreur dans la boucle for :
```java
for (int i = 0; i <= s1.length(); i++)  // devrait être i < s1.length()
```

**Correction**: Voir `AnagramCorrection.java`
- Correction de la condition de boucle
- Gestion des caractères spéciaux et espaces
- Gestion de la casse
- Gestion des caractères répétés

### Exercice 3 - BinarySearch
**Bug**: Dans la méthode `binarySearch`, il y a une erreur dans la gestion des bornes :
```java
if (array[mid] < element) {
    low = mid;  // devrait être low = mid + 1
} else {
    high = mid;  // devrait être high = mid - 1
}
```

**Correction**: Voir `BinarySearchCorrection.java`
- Correction de la gestion des bornes
- Gestion des tableaux null et vides
- Gestion des éléments aux limites
- Optimisation de la recherche

### Exercice 4 - QuadraticEquation
**Bug**: Dans la méthode `solve`, il y a une erreur dans le calcul des racines :
```java
double root1 = (-b + Math.sqrt(delta)) / (2 * a);  // devrait être (-b + Math.sqrt(delta)) / (2 * a)
double root2 = (-b - Math.sqrt(delta)) / (2 * a);  // devrait être (-b - Math.sqrt(delta)) / (2 * a)
```

**Correction**: Voir `QuadraticEquationCorrection.java`
- Correction du calcul des racines
- Gestion des équations linéaires (a = 0)
- Gestion des équations constantes (a = b = 0)
- Gestion des cas limites du discriminant

### Exercice 5 - RomanNumeral
**Bug**: Dans la méthode `toRoman`, il y a une erreur dans la boucle for :
```java
for (int i = 0; i <= symbols.length; i++)  // devrait être i < symbols.length
```

**Correction**: Voir `RomanNumeralCorrection.java`
- Correction de la condition de boucle
- Implémentation correcte de la notation soustractive
- Implémentation correcte de la notation additive
- Validation des limites (1-3999)

### Exercice 6 - FizzBuzz
**Bug**: Dans la méthode `fizzBuzz`, il y a une erreur dans l'ordre des conditions :
```java
if (n % 3 == 0) {
    return "Fizz";
} else if (n % 5 == 0) {
    return "Buzz";
} else if (n % 15 == 0) {  // devrait être vérifié en premier
    return "FizzBuzz";
}
```

**Correction**: Voir `FizzBuzzCorrection.java`
- Correction de l'ordre des conditions
- Gestion des nombres négatifs et zéro
- Gestion des cas limites
- Optimisation des vérifications de divisibilité

## Outils Utilisés
- JUnit 5 pour les tests unitaires
- JaCoCo pour la couverture de code
- Maven pour la gestion des dépendances

## Comment Exécuter les Tests
```bash
mvn test
```

## Comment Vérifier la Couverture
```bash
mvn clean test jacoco:report
```

