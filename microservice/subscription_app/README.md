### Exercice MicroService : Système de Gestion des Abonnements et Facturation

#### Contexte  
Une entreprise SaaS souhaite développer une architecture distribuée basée sur plusieurs microservices pour gérer ses abonnements et sa facturation. Le système doit permettre une gestion modulaire et évolutive, avec des services distincts pour chaque domaine fonctionnel : gestion des clients, gestion des abonnements, facturation, et notifications.

---

#### Objectifs  
Créer un système basé sur **Java** et **Spring Boot** composé de plusieurs microservices indépendants, chacun responsable d’une partie du système. Les microservices devront communiquer entre eux via **REST**

---

#### Architecture Proposée  

1. **Microservice `Client-Service`** : Gestion des clients.  
2. **Microservice `Subscription-Service`** : Gestion des abonnements.  
3. **Microservice `Billing-Service`** : Gestion des paiements et factures.  

 
4. **Bonus: Microservice `Notification-Service`** : Gestion des notifications (email et temps réel).

Tous les services utiliseront une base de données dédiée pour assurer une indépendance totale.

---

#### Spécifications Techniques  

### **1. Microservice `Client-Service`**  
Responsable de la gestion des utilisateurs.  
- **Endpoints REST** :  
  - **POST** `/clients`: Créer un client.  
  - **GET** `/clients/{id}`: Récupérer les informations d’un client.  
  - **PUT** `/clients/{id}`: Mettre à jour les informations d’un client.  
  - **DELETE** `/clients/{id}`: Supprimer un client.  

- **Base de données** :  
  - Table `clients`: `id`, `name`, `email`, `phone`.  

---

### **2. Microservice `Subscription-Service`**  
Responsable de la gestion des abonnements.  
- **Endpoints REST** :  
  - **POST** `/subscriptions`: Créer un abonnement pour un client (en utilisant son `client_id`).  
  - **GET** `/subscriptions/{id}`: Récupérer les informations d’un abonnement.  
  - **PUT** `/subscriptions/{id}`: Mettre à jour les informations d’un abonnement (changer de plan, etc.).  
  - **DELETE** `/subscriptions/{id}`: Annuler un abonnement.  

- **Base de données** :  
  - Table `subscriptions`: `id`, `client_id`, `plan_id`, `start_date`, `end_date`, `status`.  
  - Table `plans`: `id`, `name`, `price`, `billing_cycle` (monthly, annual).  

- **Logique Métier** :  
  - Lors de la création d’un abonnement, une requête sera envoyée au `Billing-Service` pour générer une facture initiale.  

---

### **3. Microservice `Billing-Service`**  
Responsable des paiements et de la facturation.  
- **Endpoints REST** :  
  - **POST** `/invoices`: Générer une facture pour un abonnement.  
  - **GET** `/invoices/{id}`: Récupérer une facture.  
  - **POST** `/payments`: Enregistrer un paiement pour une facture.  

- **Base de données** :  
  - Table `invoices`: `id`, `subscription_id`, `issue_date`, `total_amount`, `status` (paid, unpaid).  
  - Table `payments`: `id`, `invoice_id`, `payment_date`, `amount`.  

- **Logique Métier** :  
  - Génération automatique de factures à la fin de chaque cycle d’abonnement.  
  - Notification au `Notification-Service` pour informer le client du statut de la facture.  
  - **Bonus** Intégration d’une bibliothèque comme **iText** pour générer des PDF.  

---

### **Bonus 4. Microservice `Notification-Service`**  
Responsable des notifications par email ou en temps réel.  
- **Endpoints REST** :  
  - **POST** `/notifications`: Envoyer une notification à un client.  

- **Base de données** :  
  - Table `notifications`: `id`, `client_id`, `message`, `type` (email, push), `status`.  

- **Logique Métier** :  
  - Réception des messages des autres microservices via **Rest**.  
  - Envoi d’emails avec **JavaMail** ou une API tierce comme **SendGrid**.  
  - Notification des clients pour :  
    - Nouvelle facture générée.  
    - Paiement confirmé.  
    - Rappel pour un paiement en retard.  

---

#### Communication entre les Services  

1. **REST API** :  
   - Les microservices exposent leurs fonctionnalités principales via des endpoints REST.  
   - Par exemple, le `Subscription-Service` appelle le `Billing-Service` pour générer une facture lors de la création d’un abonnement.  
