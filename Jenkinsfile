pipeline {
  agent any
  stages {
    stage('Build & Publish') {
      steps {
        sh './mvnw clean deploy'
      }
    }
  }
}