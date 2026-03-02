pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven_3.9'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Child-TestEngineer-Dheeraj/ows-pipe.git'
            }
        }

        stage('Verify Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'reg query "HKEY_CURRENT_USER\\Software\\Google\\Chrome\\BLBeacon" /v version'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Execute Regression Suite') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/*'
        }
        success {
            echo 'Regression Execution Successful'
        }
        failure {
            echo 'Regression Execution Failed'
        }
    }
}