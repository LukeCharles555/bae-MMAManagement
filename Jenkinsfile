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
                sh "ssh -i "ec2jenkins.pem" ubuntu@ec2-18-130-4-97.eu-west-2.compute.amazonaws.com"
                sh "docker stop spring-app"
                sh "docker rm spring-app"
                sh "mvn dependency:get -DremoteRepositories=http://3.11.84.155:8081/repository/mmamanagement-hosted -DgroupId=com.bae -DartifactId=mmaManagement -Dversion=0.0.1-SNAPSHOT -Dtransitive=false"
                sh "mvn dependency:copy -Dartifact=com.bae:mmaManagement:0.0.1-SNAPSHOT"
                sh "git clone https://github.com/LukeCharles555/bae-MMAManagement/blob/back-end/Dockerfile"
                sh "docker build -t spring-app ."
                sh "docker run -dit --restart unless-stopped -d -p 8090:8090 --name spring-app spring-app"
                sh "exit"
            }
        }
}
