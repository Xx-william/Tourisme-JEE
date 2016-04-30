### Objectifs du projet
Réalisation d’un site web permettant le traitement et l’affichage de statistiques générales concernant le tourisme dans le monde

### Fonctionnalités principales et utilisateurs

![image](https://github.com/Xx-william/Tourisme-JEE/blob/master/Img/usercase.jpg)
    
    Figure 1: Diagramme UML de cas d'utilisation
    
![image](https://github.com/Xx-william/Tourisme-JEE/blob/master/Img/front-page.jpg)
    
    Figure 2: Page d'accueil du site
    
Lorsque l’utilisateur arrive sur le site, la première page affichée est la page illustrée sur la figure 2. L’utilisateur doit identifier son statut en cliquant sur un des boutons :
* Professionnel du tourisme
* Développeur
* Curieux
* Pas de réponse

Lorsqu’il clique sur le bouton son choix est sauvegardé dans la base de données et utilisé pour faire des statistiques. Le fait que le choix de l’utilisateur ne doit être enregistré qu’une fois par visiteur est facultatif.

Si l’utilisateur clique sur « je ne désire pas répondre », aucun enregistrement n’est fait et l’utilisateur continue sur le site.
Si l’utilisateur s’identifie comme administrateur, un champ de saisie de mot de passe apparait à côté du bouton « Admin ».
La page d’administration contient les statistiques utilisateurs (nombre de développeurs, curieux etc…) ainsi qu’un bouton de mis à jour des données et de déconnexion.
Les principales fonctionnalités du site sont regroupées sur 2 onglets comme affichés sur la figure 3 :
* Onglet « Aperçu graphique » permettant à l’utilisateur de voir l’évolution chronologique du nombre de touristes ou de recettes pour un pays ou deux pays ou un pays et une région de 1980 à 2012. L’utilisateur a le choix entre 20 pays et 5 régions.
La liste des pays et des régions se trouve sur les onglets « recettes 20 pays» et « arrivée régions mondiales » du fichier Excel contenant les données.
* Onglet « Carte du monde » permettant à l’utilisateur de voir une carte avec un dégradé de couleur illustrant l’arrivée de touriste ou le montant des recettes pour une année donné
 ![image](https://github.com/Xx-william/Tourisme-JEE/blob/master/Img/page1.jpg)
    Figure 3: Première page du site

La première page du site apparait sur la figure 3. Par défaut, l’évolution du nombre de touriste et des recettes par ans pour la France s’affiche. L’utilisateur sélectionné s’il veut afficher l’évolution du nombre de touriste ou les recettes en cochant le champ comme indiqué sur l’IHM.

![image](https://github.com/Xx-william/Tourisme-JEE/blob/master/Img/page1.jpg)
    Figure 4: Détails des statistiques
    
En cliquant sur « Détails », un tableau des données s’affiche avec le détail de tous les chiffres ayant servis à faire la courbe.
Par exemple, sur la figure 4, l’utilisateur a choisis de comparer 2 pays (France et Chine) et affiche le détail des données de cette comparaison.

![image](https://github.com/Xx-william/Tourisme-JEE/blob/master/Img/page1.jpg)
    Figure 5: Visualisation graphique des statistiques
    
En cliquant sur l’onglet « carte du monde », l’utilisateur pourra visualiser les statistiques de manière graphique à l’aide d’une carte. Un dégradé de couleur verte montrera le pourcentage par rapport au monde de l’arrivée des touristes ou des recettes pour 5 régions (Europe, Asie et Pacifique, Amérique, Afrique et Moyen Orient) ou 5 pays (France, Chine, Espagne et Italie). Plus l’arrivée ou les recettes

seront conséquentes, plus la couleur sera foncée. Une liste déroulante proposera les choix « Régions » et « Pays » selon si l’utilisateur veut visualiser les données des 5 pays ou des 5 régions.
L’utilisateur choisira soit l’arrivée soit les recettes mais pas les deux. Il aura aussi le choix d’une année entre 1980 et 2012 dans une liste déroulante.

### Contraintes générales
L’utilisation d’une base de données relationnelle est obligatoire. Une importation des données du fichier Excel fournis doit être faite ainsi qu’une mise à jour régulière par l’administrateur tous les mois.

### Contraintes mémoire
La base de données doit avoir assez de mémoire pour l’ajout de l’intégralité des données comprises dans le fichier EXCEL fourni.

### Temps de réponse
Chaque page du site doit être en mesure de répondre en moins de 4 secondes à chaque requête du client. Les requêtes SQL doivent s’exécuter en moins d’une seconde

### Cout
Nombre de jours homme : 9. 
L’application nécessitera 9 jours de développement.

### Tech

* [JAVA] 
* [JAVA Servlet] 
* [JSP] 
* [HTML] 
* [JQuery] 
* [Ajax] 
* [BootStrap] 
* [Font-Awesome]
* [HighChart]
* [HighMaps]
* [bootstrap-validator]

### Environment
* Eclipse Mars.1 Release(4.5.1)
* MySql V 14.14 Distrib 5.7.11
* Tomcat V 8.0
* JAVA V 1.8

### Installation

```sh
1. Import the project to Eclipse.
2. Import the DataBase to MySQL.
3. In the project, under the /Tourism/WebContent/META-INF/context.xml, you need to change the setting of your own database.
```
Now you are ready to go!!!

License
----

MIT


  

   [JAVA]: <https://www.java.com/en/download/whatis_java.jsp>
   [JAVA Servlet]: <http://www.oracle.com/technetwork/java/index-jsp-135475.html>
   [JSP]: <http://www.oracle.com/technetwork/java/javaee/jsp/index.html>
   [HTML]: <http://www.w3schools.com/tags/default.asp>
   [JQuery]: <https://jquery.com/>
   [Ajax]: <http://api.jquery.com/jquery.ajax/>
   [BootStrap]: <http://getbootstrap.com/>
   [bootstrap-select]: <https://github.com/silviomoreto/bootstrap-select>
  [bootstrap-validator]: <https://github.com/1000hz/bootstrap-validator>
  [Font-Awesome]:  <https://fortawesome.github.io/Font-Awesome/>
  [HighChart]: <http://www.highcharts.com/>
  [HighMaps]: <http://www.highcharts.com/>

