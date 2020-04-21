CODE_CHANGES = true
pipeline {
    agent any
    environment {
        DOCKERFILE_VERSION = '1.0.0'
        CREDENTIALS_GIT = credentials('credentials_git1')
    }
    parameters {
        string(name: 'VERSION_STRING', defaultValue: 'test_value', description: 'test string parameter')
        booleanParam(name: 'VERSION_BOOLEAN', defaultValue: true, description: 'test boolean parameter')
        choice(name: 'VERSION_CHOICE', choices: ['1.0.0', '1.0.1'], description: 'test choices parameter')
    }
    tools {
        maven 'Maven-363'
        jdk 'jdk8'
    }
    stages {
        stage {
            steps ('GroovyInit') {
                script {
                    gv = load 'scripts.groovy'
                }
            }
        }
        stage ('Initialize') {
            steps {
                echo "DOCKERFILE_VERSION value ${DOCKERFILE_VERSION}"
                echo gv.buildApp
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage ('CREDENTIALS') {
            steps {
                echo '--- credentials section ---'
                withCredentials([usernamePassword(credentialsId: 'credentials_git1', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    echo "credentials: ${USERNAME} : ${PASSWORD}"
                }
            }
        }
        stage ('PARAMETERS') {
            when {
                expression {
                   params.VERSION_STRING == true
                }
            }
            steps {
                script {
                    gv.parametersApp
                }
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
                echo "credentials ${CREDENTIALS_GIT}"

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