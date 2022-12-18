# Projet de session pour le cours A11

## Auteurs
Samuel Grenier  
Jonathan Rompré

## Présenté à
Soraya Ferdenache

### *Pour support*
Samuel étant présentement en vacance, il est possible de contacter Jonathan sur son courriel personnel au romprejonathan@gmail.com ou par MIO, quoi que cette dernière option soit moins fiable.

## __Principales fonctionalités__

### <u>Création de compte</u>
À partir de la page d'accueil ou de la page de connexion, il est possible de créer un compte en utilisant le lien Signup et Register/S'enregistrer, respectivement.

### <u>connexion</u>
À partir de la page d'accueil, en utilisant le lien Log in, ou suite à une création de compte, il est possible de se connecter.
- Note: quelques comptes sont créés lors du démarrage de l'application. Voici les informations pour se connecter en utilisant un de ces comptes:
  - Courriel: LGendron@site.com
  - Mot de passe: PwLucGendron
- Note 2: Les mots de passe sont hashé. Il n'est pas possible de récupérer un mot de passe oublié et il n'est pas possible de changer le mot de passe d'un compte sans être connecté.

### <u>filtrer les produits</u>
Une barre de filtres est située à la gauche de la page d'accueil. Les filtres sont générés dynamiquement. Lorsqu'un filtre est appliqué, les filtres et produits sont regénérés et placés dans la page en utilisant Ajax et JQuery.

### <u>Ajouter les produits au panier</u>
Lorsque connecté, appuyer sur le bouton "add to cart" ajoutera le produit au panier. Appuyer plusieurs fois sur le bouton ajoutera le produit plusieurs fois. Un badge est affiché avec l'icone de panier, en haut à droite de la page, et indique le nombre de produits distincts dans le panier.

### <u>Gestion du panier</u>
À partir de la page d'accueil, il est possible d'accéder au panier en appuyant sur le lien "Cart" en haut à droite de la page. 
Sur cette page sont affichés tous les produits ajoutés au panier. il est possible de changer la quantité de produits dans le panier ainsi que supprimer un produit du panier.
Les prix total pour un produit donnée ainsi que le grand total sont mis à jour en utilisant Ajax.  
Si au moins un produit est dans le panier, un bouton "checkout" sera visible à côté du grand total. Suite à une confirmation, appuyer sur ce bouton fermera le panier et générera une facture.
Les paniers sont enregistrés en base de donnée et sont propre à l'utilisateur. Un utilisateur peut se déconnecter et, lorsqu'il se connectera à nouveau, les produits dans son panier seront conservés.

### <u>Gestion de profil</u>
Lorsque connecté, appuyer sur le bouton de profil situé à la droite de "Log out". Sur cette page, il est possible de modifier le prénom, nom de famille et le courriel. Il est aussi possible de changer le mot de passe pour le compte.

### <u>Administration</u>
Pour accéder aux outils d'administration, à partir de la page d'accueil et sans être connecté, appuyer sur "Log in". Sur la page de connexion, utiliser le lien "Administration" en bas à droite du formulaire de connexion.  
Sur la page d'administration, il est possible de changer le mot de passe du compte administrateur, suspendre ou réactiver un compte utilisateur, ajouter un produit, rendre un produit indisponible et supprimer un produit.  
- note: Le mot de passe par défaut du compte administrateur est "admin". 

## __Informations supplémentaires__

### <u>Internationalisation</u>
Les pages de connexion et d'enregistrement sont internationalisées. La langue par défaut est l'anglais.

### <u>Navigation</u>
il est possible d'appuyer sur l'image avec le chien dans la banière pour retourner à l'accueil. Sinon, toutes les pages ont un lien pour retourner à la page d'accueil.