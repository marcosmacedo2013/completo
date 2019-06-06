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
          notifySlackVA ("Estou iniciando o processo de build do Hybris_Mediator_Kafka", "INICIADO")

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
            rm -rf ../hmk_deploy-dev
            mkdir ../hmk_deploy-dev
            mkdir ../hmk_deploy-dev/target
            cp -r Dockerfile ../hmk_deploy-dev/Dockerfile
            cp -r target/*.war ../hmk_deploy-dev/target/
            cp -r .ebextensions ../hmk_deploy-dev/.ebextensions
            cp -r .configuration/context.xml ../hmk_deploy-dev/target/context.xml
            cp -r .elasticbeanstalk ../hmk_deploy-dev/.elasticbeanstalk
            cp -r .configuration/newrelic/ ../hmk_deploy-dev/newrelic
            cp -r .configuration/certs/ ../hmk_deploy-dev/certs
          """
          echo '##################################'
          echo 'Deploying to dev environment'
          echo '##################################'
          withAWS(credentials:'svc_elasticbeanstalk_app') {
            sh """
              cd ../hmk_deploy-dev
              eb deploy mktplace-va-dev
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
              rm -rf ../hmk_deploy-hom
              mkdir ../hmk_deploy-hom
              mkdir ../hmk_deploy-hom/target
              cp -r Dockerfile ../hmk_deploy-hom/Dockerfile
              cp -r target/*.war ../hmk_deploy-hom/target/
              cp -r .ebextensions ../hmk_deploy-hom/.ebextensions
              cp -r .configuration/context.xml ../hmk_deploy-hom/target/context.xml
              cp -r .elasticbeanstalk ../hmk_deploy-hom/.elasticbeanstalk
              cp -r .configuration/newrelic/ ../hmk_deploy-hom/newrelic
              cp -r .configuration/certs/ ../hmk_deploy-hom/certs
            """
            echo '##################################'
            echo 'Deploying to dev environment'
            echo '##################################'
            withAWS(credentials:'svc_elasticbeanstalk_app') {
              sh """
                cd ../hmk_deploy-hom
                eb deploy mktplace-va-qa-1
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

    def url = "https://hitbra-sistemas.slack.com/services/hooks/jenkins-ci/"
    def token = "puDAFSml6ciHD6qL3x598MZu"
    def channel = "#venda-assistida"

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
