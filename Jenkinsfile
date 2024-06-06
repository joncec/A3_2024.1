pipeline {
    agent any

    tools {
        jdk 'jdk11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/**/*.xml'
            sh '''
                curl -T build/test-results/test/*.xml ftp://joaobsjunior.com.br/ --user aluno-ftp:a1b2c3d4@
            '''
        }
    }
}