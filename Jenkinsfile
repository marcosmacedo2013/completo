#!groovy
pipeline {

    agent {
        label 'slave1'
    }

    tools {
        maven 'Maven'
        jdk 'JDK 8u152'
    }

    stages {
      stage('Build') {
        steps {
          echo "Notificar início de build"
          notifySlackVA ("Estou iniciando o processo de build do Completo", "INICIADO")

          echo "Executando build do projeto"
          sh 'mvn clean install'
        }
      }

	    stage('Analyse') {
        steps {
	        withSonarQubeEnv('sonar.hitbra.com.br') {
            sh 'mvn sonar:sonar'
	        }
        }
	    }

      stage ('Deploy to Develop') {
        when {
          branch 'developer'
        }
        steps {
          echo '#########################'
          echo 'Preparing workspace'
          echo '#########################'
          sh """
            rm -rf ../hitbra-deploy-dev
            mkdir ../hitbra-deploy-dev
            mkdir ../hitbra-deploy-dev/target
            cp -r Dockerfile ../hitbra-deploy-dev/Dockerfile
            cp -r target/*.war ../hitbra-deploy-dev/target/
            cp -r .ebextensions ../hitbra-deploy-dev/.ebextensions
            cp -r .configuration/context.xml ../hitbra-deploy-dev/target/context.xml
            cp -r .elasticbeanstalk ../hitbra-deploy-dev/.elasticbeanstalk
            cp -r .configuration/newrelic/ ../hitbra-deploy-dev/newrelic
            cp -r .configuration/certs/ ../hitbra-deploy-dev/certs
          """
          echo '##################################'
          echo 'Deploying to dev environment'
          echo '##################################'
          withAWS(credentials:'svc_elasticbeanstalk_app') {
            sh """
              cd ../hitbra-deploy-dev
              eb deploy hitbra-dev
            """
            }
          }
        }

        stage ('Deploy to Homolog') {
          when {
            branch 'homolog'
          }
          steps {
            echo '#########################'
            echo 'Preparing workspace'
            echo '#########################'
            sh """
              rm -rf ../hitbra-deploy-hom
              mkdir ../hitbra-deploy-hom
              mkdir ../hitbra-deploy-hom/target
              cp -r Dockerfile ../hitbra-deploy-hom/Dockerfile
              cp -r target/*.war ../hitbra-deploy-hom/target/
              cp -r .ebextensions ../hitbra-deploy-hom/.ebextensions
              cp -r .configuration/context.xml ../hitbra-deploy-hom/target/context.xml
              cp -r .elasticbeanstalk ../hitbra-deploy-hom/.elasticbeanstalk
              cp -r .configuration/newrelic/ ../hitbra-deploy-hom/newrelic
              cp -r .configuration/certs/ ../hitbra-deploy-hom/certs
            """
            echo '##################################'
            echo 'Deploying to dev environment'
            echo '##################################'
            withAWS(credentials:'svc_elasticbeanstalk_app') {
              sh """
                cd ../hitbra-deploy-hom
                eb deploy hitbra-prd
              """
              }
            }
          }
    }

    post {

        success {
            notifySlackVA ("Tudo certo com o seu build", "SUCESSO")
        }

        failure {
            notifySlackVA ("Algo aconteceu de errado neste build", "ERRO")
        }
    }
}

def notifySlackVA(String details, String buildStatus = 'INICIADO') {

    def url = "https://hitbra-slack.com/services/hooks/jenkins-ci/"
    def token = "puDAFSml6ciHD6qL3x598MZu"
    def channel = "#completo"

    buildStatus =  buildStatus ?: 'SUCESSO'

    def subject = "${buildStatus}: ${details}. Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"

    def colorCode
    if (buildStatus == 'INICIADO') {
        colorCode = '#FFFF00' // Yellow
    } else if (buildStatus == 'SUCESSO') {
        colorCode = '#00FF00' // Green
    } else {
        colorCode = '#FF0000' //Red
    }

    slackSend (
        baseUrl: url,
        token: token,
        channel: channel,
        color: colorCode,
        message: summary
    )
}
