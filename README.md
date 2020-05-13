# Aplicação web em Spring Boot com Mysql

# EXECUTANDO VIA ARQUIVO .JAR

Caso queira executar sua aplicação via jar, rode o comando abaixo após copiar o arquivo gerado .jar para seu servidor, no caso de servidor Linux:

sudo java -jar GerenciadorUsuarios.jar --server.port=80


# EXECUTANDO VIA ARQUIVO .WAR

Caso prefira gerar um arquivo .war e rodar em seu servidor web preferido como Jboss ou Tomcat e desabilitar o servidor nativo do Spring Boot 
basta alterar os arquivos abaixo;


1 - No pom.xml renomeie a linha de <packaging>jar</packaging> para <packaging>war</packaging>

2 - No pom.xml comente ou remova o bloco spring-boot-starter-tomcat
		  		
3 - Na classe Main renomeie a linha 

de: 

		public class HandlingFormSubmissionApplication {
para: 

		public class HandlingFormSubmissionApplication extends SpringBootServletInitializer{
		
		
4 - Se preferir pode testar com o servidor Tomcat copiando a pasta apache-tomcat-8.5.42 para seu servidor, de preferencia Linux, e colocar o .war gerado na pasta 
apache-tomcat-8.5.42/webapps

Inicie o servidor rodando o comando sudo sh apache-tomcat-8.5.42/bin/catalina.sh start


