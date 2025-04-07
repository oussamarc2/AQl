# TP1 Palindrome - Notes

## Redondance
Les tests pour la couverture des lignes, des branches et des conditions se recoupent fortement. Les tests de branches couvrent déjà la majorité des lignes, et ceux des conditions déclenchent aussi les branches.

## Bug détecté
Un bug a été détecté dans la méthode originale `isPalindrome` : les indices étaient mal mis à jour (`j++`, `i--` au lieu de `i++`, `j--`).

## Correction proposée
Voir le fichier `Palindrome_Correction.class` contenant la version corrigée de la méthode.
