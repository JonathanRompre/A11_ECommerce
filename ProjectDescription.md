# Cours A11 - TP2
## développement d'un projet web incluant base de donnée, back-end et front-end  
<br>

## Description sommaire
Le projet consiste en un site web proposant des produits pour chiens et chats. Les utilisateurs peuvent se créer un compte. Une fois le compte créé, un utilisateur peut ajouter des items à un panier et sauvegarder le panier, en lieu de checkout et paiement.  
<br>

## Actions possibles
### Sans connexion
- DONE - Création d'un compte utilisateur
- DONE - Login compte utilisateur
- DONE - Visionner le catalogue des produits
- Initialiser un compte administrateur (à la première utilisation)
- DONE - Login compte administrateur

### Avec connexion utilisateur
- DONE - Ajouter des items au panier
- DONE - Supprimer des items du panier
- DONE - Sauvegarder un panier
- DONE - Visionner le panier
- créer une liste d'achats récurrents
- DONE - visionner le profil
- supprimer le compte
- DONE - changer le mot de passe

### Avec connexion admin
- DONE - Visionner la liste des produits
- Modifier la disponibilité des produits (?)
- Modifier le prix d'un produit
- DONE - Ajouter un produit
- DONE - Désactiver un produit
- DONE - Visionner les utilisateurs
- DONE - Suspendre un utilisateur
<br>

## Tables
### Utilisateur
- id
- prenom
- nom
- courriel
- password
- suspendre

### Produit
- id
- nom - Internationalisation:Produit.idProduit.nom
- description (FK, 1-*) - Internationalisation:Produit.idProduit.desc
- image name ?
- quantite
- actif
- recurrent_possible

### Panier
- id
- utilisateur (FK - indexed?, 1-*)
- courrant

### Panier_produit
- id
- id_panier
- id_produit
- quantite
- date_ajout

### Internationalisation - delay for if time allows
- ~id~
- type (ex. Produit)
- idType (ex. idProduit)
- champs (ex. desc)
- locale_fr
- locale_en
- PK: [type, idType, champs]

### Achat récurrent - delay for if time allows
- id
- date_prochain_achat
- frequence_achat
- produit (fk *-*)

### Administrateur
- password
<br>

## Pages
### Accueil
- DONE - Login (link)
- DONE - Logout (link)
- DONE - Profile (link)
- PARTIAL - Panier (sidebar + full view?) (on page + link) - delay for if time allows
- DONE - Affichage des produits

### Login
- DONE - Input username/password
- DONE - créer compte (link)
- recover pw ? (link) - delay for if time allows

### Admin
- DONE - Visionner la liste des utilisateurs
- DONE - Visionner la liste des produits

### Profile
- DONE - Infos utilisateur
- DONE - pw actuel - nouveau pw (pour changer le pw)
- DONE - Modification des autres infos?

### Créer compte
- DONE - Prénom
- DONE - Nom
- DONE - Couriel
- DONE - Pw
- DONE - Pw confirm

### Produit
- Nom produit
- Image
- Description
- Ajouter au panier + qté
- (Opt) Achat récurrent

### Panier
- DONE - Liste des produits
- DONE - Qté
- DONE - Prix / Produit * qté
- DONE - Prix total
- DONE - Sauvegarder panier
- DONE - Checkout (ne serait pas implémenté?)
- Historique des paniers
<br>

## Navigation
<img src="https://i.imgur.com/kXmWd0u.png" alt="navigation screenshot" width="600">