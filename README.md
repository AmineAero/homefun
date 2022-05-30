# Lancement du Micro service.
## Sans Docker : (Prérequis JDK 17)
- mvn clean install
- se positionner dans le dossier qui contient le jar et lancer la commande :
java -DCSV_STORE_PATH=<PATH_CSV_A_DEFINIR> -jar izicap-0.0.1-SNAPSHOT.jar   
Exemple : java -DCSV_STORE_PATH="C:\\Dev\\workspace\\csv\\etablissements.csv" -jar izicap-0.0.1-SNAPSHOT.jar

## Avec Docker:

