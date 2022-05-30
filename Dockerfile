FROM maven:3.8.3-openjdk-17
LABEL maintainer="Amine aero"

ADD target/*.jar /home/izicap.jar
ADD src/main/resources/csv/etablissements.csv /home/etablissements.csv

# Set environment for the CSV STORE FILE
ENV CSV_STORE_PATH=/home/etablissements.csv

WORKDIR /home
ENTRYPOINT ["java", "-jar", "izicap.jar"]
EXPOSE 8080

USER root
RUN mkdir -p /home/logs && chmod 777 /home/logs
