<h1>!!! La configuration du projet se fera sur l'IDE Intellij (Community, IDEA, Ultimate, ...) et sous un ordinateur avec Windows</h1>


- Télécharger le serveur Tomcat version 9 (le fichier core tar.gz): https://tomcat.apache.org/download-90.cgi
	- -> Extraire les dossiers de l'archive tar.gz préférablement dans le répertoire "Documents" et se souvenir du chemin

- Java Jre 11 (On peut l'installer directement grâce à Intellij ou télécharger une version manuellement)<br/>

- (optionnel) Installer localement maven (voir Document Annexes/Installer maven localement.txt)<br/>

- renseigner sur intellij le sdk 11 -> "File" -> "Project structure" -> SDK: ***-11

- lancer la commande dans le projet mvn clean install (-Dskiptests si jamais les tests ne passent pas) (sur Intelij: ctrl+ctrl pour afficher la console maven)<br/>
![mvnclean](https://github.com/Raider472/QualiteDevTP/assets/60116030/e76f257f-3a66-4cfe-9a4d-0337ce30b03b)

- Configurer Tomcat pour Intellij: Edit Configurations... -> Add New Configuration (ou le bouton "+") -> Tomcat Server -> Local
	- -> Application Server -> Configure... -> Tomcat Home: le chemin du server tomcat extrait du ficher tar.gz (exemple: C:\Users\Gabriel\Documents\Tomcat_server\apache-tomcat-9.0.80)
		- --> Normalement, une fois le chemin renseignait, les autres paramètres s'autocompletent tout seul, sinon, le "Tomcat base directory" s'agit du même chemin ci-dessus
  
    		 ![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/ac781343-6f6e-4431-a31e-a3f72d840367)
        	 ![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/f0df2e26-1554-4afe-9faf-caa77c1b81e2)
    		 ![rougeConfigure](https://github.com/Raider472/QualiteDevTP/assets/60116030/c3e755ff-6345-4881-a37a-927cf8d66e57)
    		 ![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/513da4fb-875e-4c4e-8d04-439716225910)
    
	- -> JRE: jre utilisé pour l'application, default ou jre 11

	- -> Tomcat Server settings: ne pas toucher appart si le port a été modifier sur le serveur
		- --> Cocher la case: "Deploy applications configured in Tomcat instance"

	- -> Before launch: appuyer sur le "+" et ajouter un "Build Artifacts" puis sélectionner _00_ASBank2018:war

	- -> Deployment -> "+" -> Artifacts -> cocher "_00_ASBank2018:war"

	 ![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/306ef2f1-e931-4fe6-8e26-d0fa6d20871e)
   	 ![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/64ff4166-a89c-4501-814a-7a17547d4eb4)

- Télécharger la version actuelle (8.0.34) de MYSQL Installer en 331 Mo : https://dev.mysql.com/downloads/installer/ 
	- -> Choisir le type de Setup "Server only"
	- -> Suivre les étapes par défaut
	- -> Ajouter un produit MySQL Server 8.0.x
	- -> Télécharger et installer le produit ajouté
	- -> Configuration du serveur
		- --> Laisser le port à 3306
    
 		![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/7dde225f-04bb-46f3-ba13-15e2763937d0)
		- --> Choisir un mot de passe pour l'user "root"
    
    		![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/dfdd1b83-5440-4128-b049-412e33f995d3)
    
		- --> (optionnel) Créer un utilisateur en appuyant sur le bouton "add user"
    
    		![addUserRouge](https://github.com/Raider472/QualiteDevTP/assets/60116030/f68c01a9-fcee-48e0-94ea-630462310d6b)

			- ---> choisir le username
			- ---> Host = localhost
			- ---> choisir le mot de passe et le confirmer
			- ---> cliquer sur le bouton "ok" pour confirmer
     
     			![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/337d5c99-bc0a-49ce-8b47-2989e924e504)
     
	- --> Choisir les options par défauts pour le reste de la configuration


- Télécharger la version actuelle de MySQL Workbench pour votre OS : https://dev.mysql.com/downloads/workbench/

- Connexion à la BDD depuis MySQL Workbench
	- -> Créer une connexion MySQL
	- -> Ajoutez les identifiants
		- --> Connection Name -> Nommer la connexion
		- --> Hostname = localhost
		- --> Port -> seulement le changer si le port par défaut du serveur MySQL (3306) a été modifié pendant l'installation
		- --> Username
		- --> Password -> store in vault -> taper le mot de passe de l'utilisateur
		- --> (optionel ) Tester la connection avec le bouton "Test Connection"
		- --> appuyer sur le bouton "ok" pour confirmer
  		![Passwordwork](https://github.com/Raider472/QualiteDevTP/assets/60116030/7737f7f7-c99b-430c-a5dc-5fa66fd6dd05)
	- -> Créer un schéma de base de données (4ème icône en haut) -> nommer la "banque" -> appuyer sur le bouton "Apply" en bas et confirmer une nouvelle fois dans l'interface qui apparaîtra
   	![IconWork](https://github.com/Raider472/QualiteDevTP/assets/60116030/619d2073-d0a1-40ae-8156-6012eff0edd2)
   	![image](https://github.com/Raider472/QualiteDevTP/assets/60116030/6b0315bc-a8e6-4631-b95f-783180dfb72e)
	- -> Dans le navigateur, appuyer sur le bouton "Schemas" en bas
	- -> Double-cliquer sur le schéma de base de données ajouté (après avoir cliqué, celle-ci obtiendra une police en gras)
   	![BanqueRouge](https://github.com/Raider472/QualiteDevTP/assets/60116030/dd3871b8-05a6-4b00-b523-0726eec239ff)
	- -> Ouvrir le fichier dumpSQL.sql qui est dans le dossier "scripts" du projet /projet/script/dumpSQL.sql (pour ouvrir le script, appuyer sur le deuxième bouton en haut)
   	![Sccript2](https://github.com/Raider472/QualiteDevTP/assets/60116030/5c82e343-cdb9-4ae0-8c01-4d8710a07288)
	- -> Exécuter le script (bouton de l'éclair)
   	![Eclair](https://github.com/Raider472/QualiteDevTP/assets/60116030/8994f33e-c7c9-48f5-83a6-708025834c25)
	- -> Recréer un schéma "banquetest" et refaire les mêmes étapes ci-dessus mais avec le fichier "dumpSQL_JUnitTest"
			
- Configuration de la BDD sur Intellij
	- -> Installer le plugin "Database Tools and SQL" s'il n'est pas présent (File -> Settings -> Plugins)
	- -> Cliquer sur l'onglet Database (à droite de l'IDE avec une icone de base de données en dessous/dessus de la cloche)
	- -> Appuyer sur le bouton "+" puis sélectionnez "Data Source" -> "MySQL".
	- -> Ajouter les identifiants mis pour la configuration du serveur et la connexion sur MySQL Workbench
		- --> User
		- --> Password
		- --> Database: le nom du schéma ajouté = banque
	- -> Tester la connexion
	- -> Enregistrer la configuration
	- -> Refaire les étapes ci-dessus une nouvelle fois pour le schéma "banquetest" (Database: le nom du schéma ajouté = banquetest)
