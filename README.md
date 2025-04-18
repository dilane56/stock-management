# Projet de Gestion de Stock de Produits

## Aperçu
Ce projet est une API RESTful permettant de gérer le stock de produits. Il utilise Spring Boot et Swagger pour la documentation des endpoints. L'API permet d'effectuer des opérations telles que l'ajout, la liste, la modification et la suppression de produits.

## Technologies Utilisées
- **Java 11** ou supérieur
- **Spring Boot** : Framework pour construire l'API
- **Swagger/OpenAPI** : Documentation des endpoints
- **JUnit** : Tests unitaires et d'intégration


## Endpoints de l'API

### Produit Controller

#### 1. Obtenir tous les produits
- **URL** : `/api/v1/produits`
- **Méthode HTTP** : `GET`
- **Description** : Retourne une liste complète de tous les produits disponibles.

#### 2. Obtenir un produit par son ID
- **URL** : `/api/v1/produits/{id}`
- **Méthode HTTP** : `GET`
- **Description** : Retourne les informations d'un produit spécifique à partir de son identifiant.

#### 3. Créer un nouveau produit
- **URL** : `/api/v1/produits`
- **Méthode HTTP** : `POST`
- **Description** : Ajoute un nouveau produit en utilisant les informations fournies dans le corps de la requête.
- **Corps de la requête** :
  ```json
  {
    "nom": "Nom du produit",
    "prix": 100.0,
    "quantite": 50,
  }
  
### 4. Mettre à jour un produit existant
- **URL** : `/api/v1/produits/{id}`
- **Méthode HTTP** : `PUT`
- **Description*** : Modifie les informations d'un produit spécifique à partir de son identifiant.
Corps de la requête :
  
```json
{
  "nom": "Nouveau nom",
  "prix": 120.0,
  "quantite": 30,
 
}
```
### 5. Supprimer un produit par son ID

- **URL** : `/api/v1/produits/{id}`
- **Méthode HTTP** : `DELETE`
- **Description** : Supprime un produit spécifique à partir de son identifiant.

### 6. Produits avec faible quantité

- **URL** : `/api/v1/produits/quantitefaible`
- ***Méthode HTTP** : `GET`
- **Description** : Retourne une liste de produits avec des quantités faibles.
- 
### Installation
Clonez le dépôt :
```bash
git clone https://github.com/votre-utilisateur/gestiondestockproduit.git
```
Accédez au répertoire :
```bash
cd gestiondestockproduit
```
Configurez votre fichier application.properties pour connecter une base de données.

Compilez et lancez l'application :
```bash
./mvnw spring-boot:run
```
L'API sera accessible à l'adresse suivante : http://localhost:8080/api/v1/produits

### Contribution
Les contributions sont les bienvenues ! Pour contribuer :

1. Forkez ce dépôt.
2. Créez une branche pour vos modifications :
```bash
git checkout -b ajout-de-fonctionnalite
```
Poussez vos modifications et soumettez une Pull Request.
Auteurs
dilane56
