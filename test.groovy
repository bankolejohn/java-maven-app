def buildJar() {
    sh 'mvn package'
}

def buildAppImage() {
    echo 'building the app image ...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
        sh 'docker build -t newimage:2.0 .'
        sh "echo $PASSWORD | docker login -u $USER --password-stdin"
        sh 'docker push bankolejohn/newimage:2.0'
    }
    

}

def testApp() {
    echo 'testing the app...'
}

def deployApp() {
    echo 'deploying app'
}

return this