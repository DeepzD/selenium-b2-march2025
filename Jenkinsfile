pipeline {
    agent any  // Runs on any available agent

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/DeepzD/selenium-b2-march2025.git', branch: 'main'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
    post {
        always {
            echo 'Pipeline Execution Completed edited'
        }
    }
}