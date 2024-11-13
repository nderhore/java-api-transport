# API de Gestion de Flotte de Véhicules de Livraison

Ce projet est une API développée avec Spring Boot et optimisée pour Java 21 avec GraalVM, permettant de gérer une flotte de véhicules pour une entreprise de logistique. L’API permet d'ajouter, consulter, mettre à jour et supprimer des informations sur les véhicules de livraison et leurs conducteurs, avec des fonctionnalités extensibles pour une gestion complète de la flotte.

## Table des matières
1. [Pré-requis](#pré-requis)
2. [Installation](#installation)
3. [Lancer l'application](#lancer-lapplication)
4. [Endpoints de l'API](#endpoints-de-lapi)
5. [Modèles de données](#modèles-de-données)

---

## Pré-requis

- **Java 21 avec GraalVM** : Assurez-vous que Java 21 et GraalVM sont installés. [Télécharger GraalVM](https://www.graalvm.org/downloads/)
- **Maven 3.8+** : Utilisé pour gérer les dépendances. [Télécharger Maven](https://maven.apache.org/download.cgi)
- **Postman** : Utilisé pour tester l'API localement. [Télécharger Postman](https://www.postman.com/downloads/)

## Installation

1. **Cloner le dépôt**
   ```bash
   git clone https://github.com/votre-utilisateur/api-gestion-flotte.git
   cd api-gestion-flotte
   ```

2. **Configurer le projet avec Maven**
    - Téléchargez les dépendances :
      ```bash
      mvn clean install
      ```

3. **Configurer la base de données (optionnel)**
    - Le projet est configuré par défaut pour utiliser une base de données H2 en mémoire. Pour utiliser une autre base, modifiez le fichier `application.properties` dans le dossier `src/main/resources` :
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/gestion_flotte
      spring.datasource.username=USERNAME
      spring.datasource.password=PASSWORD
      ```

## Lancer l'application

Après avoir configuré les dépendances et la base de données, lancez l’application en mode JVM classique ou compilez-la en mode natif avec GraalVM pour des performances optimisées.

1. **Lancer en mode JVM**
   ```bash
   mvn spring-boot:run
   ```
   L'application sera accessible à l'adresse suivante : `http://localhost:8080`.

2. **Compiler et exécuter en mode natif (GraalVM)**
   ```bash
   mvn -Pnative native:compile
   ./target/api-gestion-flotte
   ```

   Ce mode permet d'optimiser l'application pour des déploiements en cloud et des performances accrues.

## Endpoints de l'API

| Méthode | Endpoint               | Description                                         |
|---------|-------------------------|-----------------------------------------------------|
| GET     | `/api/vehicules`        | Récupère la liste des véhicules                     |
| GET     | `/api/vehicules/{id}`   | Récupère les détails d’un véhicule spécifique       |
| POST    | `/api/vehicules`        | Ajoute un nouveau véhicule                          |
| PUT     | `/api/vehicules/{id}`   | Met à jour les informations d’un véhicule           |
| DELETE  | `/api/vehicules/{id}`   | Supprime un véhicule de la flotte                   |
| GET     | `/api/conducteurs`      | Récupère la liste des conducteurs                   |
| POST    | `/api/conducteurs`      | Ajoute un nouveau conducteur                        |

> **Remarque :** Tous les endpoints renvoient des réponses au format JSON.

### Exemple de requêtes

**Ajouter un véhicule**
   ```http
   POST /api/vehicules
   ```
   **Body :**
   ```json
   {
       "marque": "Renault",
       "modele": "Kangoo",
       "annee": 2020,
       "immatriculation": "AB-123-CD"
   }
   ```

## Modèles de données

### Véhicule

| Champ             | Type     | Description                  |
|-------------------|----------|------------------------------|
| `id`              | Long     | Identifiant unique           |
| `marque`          | String   | Marque du véhicule           |
| `modele`          | String   | Modèle du véhicule           |
| `annee`           | Integer  | Année de fabrication         |
| `immatriculation` | String   | Immatriculation unique       |

### Conducteur

| Champ       | Type     | Description                  |
|-------------|----------|------------------------------|
| `id`        | Long     | Identifiant unique           |
| `nom`       | String   | Nom du conducteur            |
| `prenom`    | String   | Prénom du conducteur         |
| `vehiculeId`| Long     | ID du véhicule assigné       |
