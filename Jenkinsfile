import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()


pipeline {

    agent any

    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }

    options {
		buildDiscarder(logRotator(numToKeepStr: '20'))
	    disableConcurrentBuilds()
	}

    stages {

        stage ('Build') {
                    steps {
                    	bat ("mvn clean install -DskipTests")
                        bat ("mvn clean verify")
                    }
        }

		stage ('Ejecutar Pruebas') {
                	steps {
                		script {

                			try {
                				bat ("mvn test -Dcucumber.features=src/test/resources/features/ -Dcucumber.filter.tags=${ESCENARIO} -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue=com.atlantic")
                				//bat ("mvn test -Dcucumber.features=src/test/resources/features/ -Dcucumber.filter.tags=${TAGS} -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue=com.atlantic")
                				bat ("mvn serenity:aggregate")
                				echo 'Ejecucion de pruebas sin errores...'
                			}
                			catch (ex) {
                				echo 'Finalizo ejecucion con fallos...'
                				error ('Failed')
                            }
                        }
                   }
        }
                stage ('Reporte') {
                	steps {
                		script {
                             try {
                            	bat ("echo ${WORKSPACE}")
                            	bat ("echo ${defTimestamp}")
                            	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                            	//saucePublisher()
                              echo 'Reporte realizado con exito'
                            }

                            catch (ex) {
                                echo 'Reporte realizado con Fallos'
                                error ('Failed')
                            }
                        }
                    }
                }
/*
        stage ('Reporte') {
        	steps {
        		script {
					try {
                     	sh "mvn serenity:aggregate"
                    	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        saucePublisher()
                        echo 'Reporte realizado con exito'
                    }

                    catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error ('Failed')
                    }
                }
            }
        }
        */
    }
}