pipeline{
    agent any
     environment {

        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }
    
    stages{
        
       stage('Git Code'){
            steps{
                git branch: 'main',
                url: 'https://github.com/yasmine226/Projetachat' ,
                credentialsId: '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'    
            }
         }        
        

        
            stage('Building Project'){
            steps{
                        sh 'mvn clean install'

            }
        }

       

        stage("Building Docker Image") {
                steps{
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/achat .'
                }
        }
        
        stage("Login to DockerHub") {
                steps{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                   // sh 'doctl registry login'
                }
        }
        
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/achat'
                }
        }
        
        stage("Docker-compose") {
                steps{
                    sh 'docker-compose up -d'
                }
        }
    }
}
