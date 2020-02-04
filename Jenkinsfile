pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean -DskipTests=true"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test -DskipTests=true"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package -DskipTests=true"
            }
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy -DskipTests=true"
            }
        }
    }
}
