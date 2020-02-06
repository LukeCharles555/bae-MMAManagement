pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
        stage('--report--') {
            steps {
                sh "mvn surefire-report:report"
            }
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy"
            }
        }
        stage('--testing environment creation--') {
            steps {
                sh "ssh -i /home/ubuntu/ec2jenkins.pem ssh -i /home/ubuntu/ec2jenkins.pem ubuntu@ec2-18-130-4-97.eu-west-2.compute.amazonaws.com './script.sh'"
            }
        }
    }
}
