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
                sh "ssh -T -i /home/ubuntu/ec2jenkins.pem ubuntu@ec2-35-178-16-228.eu-west-2.compute.amazonaws.com ./script.sh"
            }
        }
    }
}
