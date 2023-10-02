-!!! La configuration du projet se fera sur l'IDE Intellij (Community, IDEA, Ultimate, ...)

- Télécharger le serveur Tomcat version 9 (le fichier core tar.gz): https://tomcat.apache.org/download-90.cgi
	-> Extraire les dossiers de l'archive tar.gz préférablement dans le répertoire "Documents") et se souvenir du chemin

- Java Jre 1.8 (On peut l'installer directement grâce à Intellij ou télécharger une version manuellement)

- (optionnel) Installer localement maven (voir Documentation/Maven/Installer maven localement.txt)

- lancer la commande dans le projet mvn clean install (-Dskiptests) (sur Intelij: ctrl+ctrl pour afficher la console maven)

- Configurer Tomcat pour Intellij: Edit Configurations... -> Add New Configuration (ou le bouton "+") -> Tomcat Server -> Local
	-> Application Server -> Configure... -> Tomcat Home: le chemin du server tomcat extrait du ficher tar.gz (exemple: C:\Users\Gabriel\Documents\Tomcat_server\apache-tomcat-9.0.80)
		--> Normalement, une fois le chemin renseignait, les autres paramètres s'autocompletent tout seul, sinon, le "Tomcat base directory" s'agit du même chemin ci-dessus

	-> JRE: jre utilisé pour l'application, default ou jre 1.8

	-> Tomcat Server settings: ne pas toucher appart si le port, a été modifier sur le serveur tomcat
		--> Cocher la case: "Deploy applications configured in Tomcat instance"

	-> Before launch: appuyer sur le "+" et ajouter un "Build Artifacts" puis sélectionner _00_ASBank2018:war

	-> Deployment -> "+" -> Artifacts -> cocher "_00_ASBank2018:war"

- Télécharger la version actuelle de MYSQL Installer en 331 Mo : https://dev.mysql.com/downloads/installer/ 
	-> Choisir le type de Setup "Server only"
	-> Suivre les étapes par défaut
	-> Ajouter un produit MySQL Server 8.0.x
	-> Télécharger et installer le produit ajouté
	-> Configuration du serveur
		--> Laisser le port à 3306
		--> Choisir un mot de passe pour l'user "root"
		--> (optionnel) Créer un utilisateur en appuyant sur le bouton "add user"
			---> choisir le username
			---> Host = localhost
			---> choisir le mot de passe et le confirmer
			---> cliquer sur le bouton "ok" pour confirmer
		--> Choisir les options par défauts pour le reste de la configuration


- Télécharger la version actuelle de MySQL Workbench : https://dev.mysql.com/downloads/workbench/

- Connexion à la BDD depuis MySQL Workbench
	-> Créer une connexion MySQL
	-> Ajoutez les identifiants
		--> Connection Name -> Nommer la connexion
		--> Hostname = localhost
		--> Port -> seulement le changer si le port du serveur MySQL a été modifié pendant l'installation
		--> Username
		--> Password -> store in vault -> taper le mot de passe de l'utilisateur
		--> (optionel ) Tester la connection avec le bouton "Test Connection"
		--> appuyer sur le bouton "ok" pour confirmer
	-> Créer un schéma de base de données (4ème icône en haut) -> nommer la "banque" -> appuyer sur le bouton "Apply" en bas et confirmer une nouvelle fois dans l'interface qui apparaîtra
	-> Dans le navigateur, appuyer sur le bouton "Schemas" en bas
	-> Double-cliquer sur le schéma de base de données ajouté (après avoir cliqué, celle-ci obtiendra une police en gras)
	-> Ouvrir le fichier dumpSQL.sql qui est dans le dossier "scripts" du projet /projet/script/dumpSQL.sql (pour ouvrir le script, appuyer sur le deuxième bouton en haut)
	-> Exécuter le script (bouton de l'éclair)

- MYSQL Connector-J 
	-> Si vous avez déjà MySQL Connector-J, mettez la à jour sur IntelliJ. Dans le cas contraire, suivez les étapes ci-dessous
	-> Télécharger la version actuelle de MYSQL Connector-J en .zip et choisir l'OS "Platform Independent" : https://dev.mysql.com/downloads/connector/j/
	-> Si vous avez déjà MySQL Connector-J
	-> Aller dans "structure du projet" sur IntelliJ
	-> Sélectionner "libraries"
	-> Ajouter le fichier .jar de MYSQL Connector-J à l'endroit où vous l'avez mis
	-> Appliquer les modifications
			
- Configuration de la BDD sur Intellij
	-> Installer le plugin "Database Tools and SQL" s'il n'est pas présent (File -> Settings -> Plugins)
	-> Cliquer sur l'onglet Database (à droite de l'IDE avec une icone de base de données en dessous de la cloche)
	-> Appuyer sur le bouton "+" puis sélectionnez "Data Source" -> "MySQL".
	-> Ajouter les identifiants mis pour la configuration du serveur et la connexion sur MySQL Workbench
		--> User
		--> Password
		--> Database: le nom du schéma ajouté = banque
	-> Tester la connexion
	-> Enregistrer la configuration
