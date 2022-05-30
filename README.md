# Lancement du Micro service.
## Sans Docker : (Prérequis JDK 17)
- mvn clean install
- se positionner dans le dossier qui contient le jar et lancer la commande :

- java -DCSV_STORE_PATH=<PATH_CSV_A_DEFINIR> -jar izicap-0.0.1-SNAPSHOT.jar   
Exemple : java -DCSV_STORE_PATH="C:\\Dev\\workspace\\csv\\etablissements.csv" -jar izicap-0.0.1-SNAPSHOT.jar

## Avec Docker:
- Build a Docker image from the local sources:
- docker build -t izicap:<version> .
- example : docker build -t izicap:0.0.1-SNAPSHOT .

- launch the local Docker image :
- docker run - izicap:0.0.1-SNAPSHOT

# Fonctionnement :
Une fois le MS démarré, l'utilisateur peut mettre à jour le store et requêter les 
informations d'un établissement via son SIRET. Pour le faire, on lui a exposé l'API Rest :
http://<<adresse_ip>>:8080/api/v0/siret/<numero_siret>
- Exemple : http://localhost:8080/api/v0/siret/41339442000090

- Le MS cherchera directement l'info dans l'API source https://entreprise.data.gouv.fr/api.
- Et si un établissement est trouvé, le store CSV sera mis à jour et une réponse est envoyée à l'utiisateur
avec les dernières informations.