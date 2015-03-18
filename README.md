#Installation du projet d'edition de CDM de l'ENSSAT

##Prérequis: Distribution Linux (Ubuntu 14.04 dans notre cas)

###Maven

Dans un premier temps veuillez vous assurer que Maven soit installé sur votre système et que sa version est au moins 3.0.5. Dans le cas contraire, veuillez vous assurer de desinstaller votre version de maven et d'installer la plus récente

###Base de données

Ce projet nécessite l'utilisation d'une base de données, et donc d'un système de gestion de base de données qui est 
MySQL.Il faut utiliser le fichier *script_bdd.sql* afin de créer la base de données et sa structure.

**Commandes terminal** :

Allez dans le repertoire où vous avez cloné les sources du dépôt 
```
cd chemin_sources_git
mysql -u root -p
source script_bdd.sql
```
La base de données est maintenant installée.

###Construction et lancement de l'application
```
cd java
mvn clean
mvn package
```

Et lancez ensuite l'application via la commande :
```
java -jar target/dependency/webapp-runner.jar target/ENSSAT-1.0.war
```

Vous pouvez maintenant l'interroger via un client REST comme POSTman,Advanced REST Client (Chrome,Chromium) ou RESTClient (Mozilla Firefox) 

*Exemple de requête : http://localhost:8080/"à changer"/rest/CDMs*
