pipeline {
    agent any

    parameters {
        choice(name: 'VERSION', choices: ['1.0', '1.1'])
        booleanParam(name: 'executeTests', defaultValue: true)
    }

    stages {
        stage("build") {
            steps {
                echo 'building the app...'
            }

            }
        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'jenkins-jobs'

                }
            }
            steps {
                echo 'testing the app...'
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying the app...'
                echo 'execution successful'
                echo "deploying ${params.VERSION}"
            }
        }

}
    