pipeline {
    agent none
    environment {
        MAVEN_OPTS = '-Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn'
    }
    options {
        ansiColor('css')
    }
    stages {
        stage('Verify') {
            agent {
                docker {
                    image 'maven:3.8.3-openjdk-17'
                }
            }
            when {
                beforeAgent true
                not {
                    branch 'main'
                }
            }
            steps {
                sh 'mvn -s settings.xml -f ./pom.xml clean verify'
            }
        }
        stage('Deploy Artifact') {
            agent {
                docker {
                    image 'maven:3.8.3-openjdk-17'
                }
            }
            when {
                beforeAgent true
                branch 'master'
            }
            steps {
                script {
                    pom = readMavenPom(file: 'izicap/pom.xml')
                    echo "-- build and deploiement of the artifact ${pom.artifactId} version ${pom.version} on Artifactory "
                    withCredentials([usernamePassword(credentialsId: 'my-credentialsId-deploy', usernameVariable: 'ARTIFACTORY_UPLOAD_USER', passwordVariable: 'ARTIFACTORY_UPLOAD_PASSWORD')]) {
                        sh 'mvn -s settings.xml clean deploy'
                    }
                    stash includes: 'izicap/target/**/*', name: 'buildMaven'
                }
            }
        }
        stage('Build & Push Docker Image') {
            agent any
            when {
                beforeAgent true
                branch 'master'
            }
            steps {
                script {
                    echo "Build Image Docker ${pom.artifactId}:${pom.version}"
                    unstash 'buildMaven'
                    image = docker.build("${pom.artifactId}:${pom.version}")
                    echo 'Docker Push'
                    docker.withRegistry('https://URI_OF_ACTIFACTORY', 'my-credentialsId-deploy') {
                        image.push()
                    }
                }
            }
        }
    }
}
