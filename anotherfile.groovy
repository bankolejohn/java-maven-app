def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }

    stages {
       stage("init") { 
            steps{
                script {
                    gv = load "test.groovy"
                }
                

            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildAppImage()
                }
            }
        }

        stage("app test"){
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy image") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
    
}