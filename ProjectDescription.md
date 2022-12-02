# Cours A11 - TP2
## développement d'un projet web incluant base de donnée, back-end et front-end  
<br>

## Description sommaire
Le projet consiste en un site web proposant des produits pour chiens et chats. Les utilisateurs peuvent se créer un compte. Une fois le compte créé, un utilisateur peut ajouter des items à un panier et sauvegarder le panier, en lieu de checkout et paiement.  
<br>

## Actions possibles
### Sans connexion
- Création d'un compte utilisateur
- Login compte utilisateur
- Visionner le catalogue des produits
- Initialiser un compte administrateur (à la première utilisation)
- Login compte administrateur

### Avec connexion utilisateur
- Ajouter des items au panier
- Supprimer des items du panier
- Sauvegarder un panier
- Visionner le panier
- créer une liste d'achats récurrents
- visionner le profil
- supprimer le compte
- changer le mot de passe

### Avec connexion admin
- Visionner la liste des produits
- Modifier la disponibilité des produits (?)
- Modifier le prix d'un produit
- Ajouter un produit
- Désactiver un produit
- Visionner les utilisateurs
- Suspendre un utilisateur
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
- Login (link)
- Logout (link)
- Profile (link)
- Panier (sidebar + full view?) (on page + link) - delay for if time allows
- Affichage des produits

### Login
- Input username/password
- créer compte (link)
- recover pw ? (link) - delay for if time allows

### Admin
- Visionner la liste des utilisateurs
- Visionner la liste des produits

### Profile
- Infos utilisateur
- pw actuel - nouveau pw (pour changer le pw)
- Modification des autres infos?

### Créer compte
- Prénom
- Nom
- Couriel
- Pw
- Pw confirm

### Produit
- Nom produit
- Image
- Description
- Ajouter au panier + qté
- (Opt) Achat récurrent

### Panier
- Liste des produits
- Qté
- Prix / Produit * qté
- Prix total
- Sauvegarder panier
- Checkout (ne serait pas implémenté?)
- Historique des paniers
<br>

## Navigation
<img src="https://i.imgur.com/kXmWd0u.png" alt="navigation screenshot" width="600">