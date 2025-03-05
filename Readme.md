# Description de l'exercice et des éléments de solution

On considère des plateaux de jeu de type échiquier ou damier, constitués de cases sur lesquelles on peut poser des pièces de différentes couleurs. Les plateaux offrent un ensemble de méthodes qui permettent :
1. d’initialiser le plateau c.-à-d. de disposer les pièces sur le plateau pour un début de partie conformément aux règles du jeu `[initialiser() : void]`
2. d’extraire la disposition courante du plateau c.-à-d. l’ensemble des pièces présentes sur le plateau et les cases qu’elles occupent `[extraire() : Disposition]`
3. de disposer un ensemble de pièces sur des cases dans une disposition particulière donnée `[disposer(Disposition d) : void]`
4. d’obtenir la pièce (avec sa couleur) posée sur une case donnée identifiée par ses coordonnées, ou une indication que la case est vide si c’est le cas `[obtenir(Case c) : Pièce]`
5. étant donné deux cases From et To, de déplacer sur la case To la pièce située dans la case From `[déplacer(Case from, Case to) : void]`
Les trois premières méthodes sont utilisées (invoquées) par un « superviseur » qui supervise le jeu et seulement par celui-ci. Les deux dernières sont utilisées (invoquées) par les « joueurs » et seulement par eux.
        
Un échiquier est un plateau de 8x8 cases. Sur une case, il peut y avoir une pièce de type ROI, REINE, FOU, CAVALIER, TOUR, PION ou bien la case peut être VIDE.
La société M1-DEVELOPPEMENT est chargée de la conception et de la réalisation en Java d’une application qui permet à deux joueurs de s’affronter aux échecs sous le contrôle d’un superviseur. Au déploiement, l’application doit créer deux objets joueurs instances d’une classe `Joueur`, un objet superviseur instance d’une classe `Superviseur` et un objet échiquier.

Ci-dessous les questions posées et les éléments de solutions proposés sont exposés.

## Question 1

> Concevoir l’application de telle sorte que joueurs et superviseur aient seulement accès aux méthodes du plateau qui les concerne. Donner le diagramme de classes (classes Joueur, Superviseur...) avec les éléments de code utiles. Donner le code de configuration.


On trouve dans le paquetage common les interfaces `JPlateau` et `SPlateau` complétées par `Piece` et `Coordonnees`. `Piece` est un élément de l'énoncé, complété d'une méthode concrétisant un peu plus la logique du déplacement d'une pièce. `Coordonnees` est une légère adaptation de l'énoncé pour coller à la réalité des jeux de plateaux.

Naturellement, les spécifications des méthodes des joueurs et des superviseurs définies dans l'énoncé sont déclarées dans les interfaces `JPlateau` et `SPlateau` respectivement. L'emploi de la généricité dans l'interface `SPlateau` permet de retrouver l'abstraction `Disposition` définie dans l'énoncé.

Le jeu d'échec est défini dans le paquetage `echiquier`. Il est structuré en un sous-paquetage `roles` pour les rôles Joueur et Superviseur, un sous-paquetage `plateau` pour la spécification de l'échiquier et deux propositions d'implantation et le sous-paquetage `config` pour la configuration (glue code) de l'ensemble.

Lors de la définition des rôles Joueur et Superviseur, on y constate clairement la *ségrégation des interfaces* du plateau, selon les deux interfaces `JPlateau` et `SPlateau` car le type de l'attribut contraint automatiquement les accès aux méthodes.

L'interface `Echiquier` est facultative. Elle n'es présente que pour abstraire la définition de l'échiquier par rapport aux implantations proposées. 

Voici un diagramme de classes UML résumant la proposition : 

![](https://www.plantuml.com/plantuml/png/ZPBDJiCm48JFyLEiUYfIMy4PL1Mr79fJfJw1Qs_B2iSRrdQ5WBux-Ic9EO2uH3kPx3UJnAiGjSHKEHLUoDTQT0N6wH0UOnGwf8XRmtvFxmYtIf6FA4Tj47Q4pVL35GTcXzh3MJkokC7QDNQ5FaxNp6BPUyG0H-5g1lcTo3Vtwf8ZovtJ4NLggJsU3n4zoG-I6US6K9oPBDW-LVuHMQXB5hdF8ZiIUOga7OK6jg5GSsWqUx3ZtAQksJaqhNhecYu1y2sA9i7fsAhR-HEKTtaop_IQ2AL5eRTX-22ph6UXYa6SC7xFNMgP6MLcN5JtHw7aX4dWglQfHZbJm2HANQtvV0cJEvZN_N9J2KsO34NKkFFRiqDLjQrgrnq4ygVntHQBpoKCKgtGs_RmVG40)

## Question 2

> Supposons maintenant que la société M1-DEVELOPPEMENT ait choisi d’utiliser une implantation d’un échiquier précédemment développée dans le cadre d’un autre projet : cette implantation est définie par la classe UnEchiquierImpl qui offre les méthodes d’un plateau. Sachant que la société M1- DEVELOPPEMENT s’interdit toute modification de l’existant, en particulier les classes Joueur, Superviseur et UnEchiquierImpl, proposer une solution de conception qui respecte les contraintes d’accès au plateau (méthodes réservées au superviseur ou réservées au joueur). Donner le diagramme de classes avec les éléments de code utiles. Donner le code de configuration.

Le paquetage `uneAutreImplantationEchiquier` regroupe tous les éléments de l'énoncé et de la solution. La classe `UnEchiquierImpl` définit l'implantation (vide car inutile pour la compréhension de l'usage des patterns) donnée et non modifiable.

La classe `DelegatingEchiquierFromImpl` reprend la structure de la classe `DelegatingEchiquier` pour introduire la description de deux classes internes (`EchiquierJoueurAdapter` et `EchiquierSuperviseurAdapter`) et une instance de chacune pour définir un adapteur pour l'interface `Jplateau` et un adaptateur pour l'interface `Splateau`.

On remarque dans `MainQ2` que l'utilisation de l'une ou l'autre des 3 implantations réalisées est complètement transparente.

Le diagramme suivant résume la proposition solvant la question 2 :

![](https://www.plantuml.com/plantuml/png/dLHDRzim33rRluB8gOEROZjl25gqEzId0i5-W2ApBJ5PyYWg6BRblyyVBYCWMvVr9ehYUu_aiw-JM9RSUPE-KkWjsmwSjodTY33jik2zYs5BFn3U6qD1a1-jGtWWT0W_JRMBqQCDiBUUMhp3tW_f3eDStCR8RGm1CS4Zn-uIoXk9xpwQGmdPF7WhQFE8EiF7dM0WBf707Sy3GBMFr48xi_8Pb9Kv59HRfLoGA92GzPG6i3jAVKn370Eqn_F8UXkzHpT6doQb6m3yBco9yK9LpJMl0fLQFhjd-fO9UOJ2q2OTo6MXipAL1ayeB-U9jIaIJP4uc6cZqCICcM69jhb7tbF2pCOigVLw0wiFiExdua4IkhHI8KPh_lfMfPhxhlUJ4IWy7Nkxklgr0GtDekLBqAknR5n7hVkOUgjFHZvFt2rfdRWLzpnVgOSiXU9H5_SuJsKXL-gYkvlMze8CzD94qiPKtBbcgV_bblfSkvnARcB-izgcL7lsrrJ_x-SqIdfbVceIcuLH7wvE5cxAZjvIVusX7VzYlm40)

## Question 3

> On veut maintenant contrôler le jeu des pièces en fonction de leur couleur : au premier coup, on n’autorise que le déplacement d’une pièce blanche, au second seulement celui d’une pièce noire, au troisième celui d’une pièce blanche, et ainsi de suite. Quelle solution permet d’intégrer ce contrôle à l’application sans modifier l’existant ? Pour simplifier, on suppose que si un déplacement n’est pas autorisé, l’opération est ignorée. Donner le diagramme de classes avec les éléments de code utiles. Donner le code de configuration.

Il faut comprendre dans cette question que la problématique porte sur le **contrôle** des déplacements des pièces, selon une référence (tour de rôles qui commence par les blancs). Il s'agit donc de vérifier que chaque coup joué est conforme. Pour cela, un proxy de JPlateau fait tout à fait l'affaire.

Une petite modification est faite sur `JPlateau` pour le rendre générique vis à vis des `Piece` afin de pouvoir définir des 

