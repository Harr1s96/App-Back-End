pipeline {
    agent any
    stages {
        stage('--- package and deploy to Nexus ---') {
            steps {
                sh "mvn clean package deploy"
            }
        }
        stage('-- build docker image --') {
            steps {
                sh "docker build -t back-end:prod ."
            }
        }
        stage('-- deploy image to Docker Hub --') {
            steps {
                withDockerRegistry([credentialsId: "docker-credentials", url: ""]) {
                    sh 'docker tag back-end:prod bigheck123/back-end:prod'
                    sh 'docker push bigheck123/back-end:prod'
                }
            }
        }
    }
}
