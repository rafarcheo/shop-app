pipeline {
    agent any
    tools {
        maven 'Maven-363'
        jdk 'jdk8'
    }
    CODE_CHANGES = getGitChanges()
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
        stage ('Test') {
            when {
                expression {
                    BRANCH_NAME == 'feature/init' && CODE_CHANGES == true
                }
            }
            steps {
                echo 'test 123 conditional expression executes !!!'
            }
        }
    }
    post {
        always {
            echo "echo after build"
        }
        success {
            echo "echo after build success"
        }
        failure {
            echo "echo after failure"
        }
    }
}