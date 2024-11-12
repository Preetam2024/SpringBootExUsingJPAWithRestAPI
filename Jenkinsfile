//SCRIPTED

//DECLARATIVE
pipeline {
	agent any
	// agent { docker { image 'maven:3.6.3'} }
	// agent { docker { image 'node:13.8'} }
	environment {
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
       
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
	}

	stages {
		stage('Checkout') {
			steps {
			echo "checkout"
				sh 'mvn --version'
				sh 'docker version'
				echo "Build"
				echo "PATH - $PATH"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_TAG - $env.BUILD_TAG"
				echo "BUILD_URL - $env.BUILD_URL"
			}
		}
		stage('Compile') {
			steps {
				sh "mvn clean compile"
			}
		}

		stage('Test') {
			steps {
				sh "mvn test"
			}
		}

		stage('Integration Test') {
			steps {
				sh "mvn failsafe:integration-test failsafe:verify"
			}
		}

		stage('Package') {
			steps {
				sh "mvn package -DskipTests"
			}
		}

		stage('Build Docker Image') {
			steps {
				//"docker build -t in28min/currency-exchange-devops:$env.BUILD_TAG"
				script {
					dockerImage = docker.build("kumapref/docker-in-5-steps-todo-rest-api-h3:5.0.0.RELEASE")
				}

			}
		}

		stage('Push Docker Image') {
			steps {
              sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
			 // dockerImage.push();
				script {
					//docker.withRegistry('', 'dockerhub') {
						dockerImage.push();
						//dockerImage.push('latest');
					//}
				}
			}
		}
		 stage("kubernetes deployment"){
		 steps {
          sh 'kubectl apply -f k8s-spring-boot-deployment.yml'
		}
	   }
	} 
	
	post {
		always {
			echo 'Im awesome. I run always'
            sh 'docker logout'
		}
		success {
			echo 'I run when you are successful'
		}
		failure {
			echo 'I run when you fail'
		}
	}
}
