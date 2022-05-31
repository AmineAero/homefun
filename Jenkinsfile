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
                branch 'main'
            }
            steps {
                script {
                    pom = readMavenPom(file: 'izicap/pom.xml')
                    sh 'mvn -s settings.xml clean install'
                    stash includes: 'izicap/target/**/*', name: 'buildMaven'
                }
            }
        }
        stage('Build & Push Docker Image') {
            agent any
            when {
                beforeAgent true
                branch 'main'
            }
            steps {
                script {
                    echo "Build Image Docker ${pom.artifactId}:${pom.version}"
                    unstash 'buildMaven'
                    image = docker.build("${pom.artifactId}:${pom.version}")
                    echo 'Docker Push to DockerHub'
                    docker.withRegistry('monik/devinprogress', 'aero-token-deploy') {
                        image.push()
                    }
                }
            }
        }
    }
}
