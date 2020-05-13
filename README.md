# Aplicação web em Spring Boot com Mysql

Para gerar um arquivo .war e rodar em seu servidor preferido como Jboss ou Tomcat e desabilitar o servidor nativo do Spring basta alterar os arquivos abaixo;


1 - No pom xml renomeie a linha de <packaging>jar</packaging> para <packaging>war</packaging>

2 - No pom xml comente ou remova o bloco spring-boot-starter-tomcat
		  		
3 - Na classe Main renomeie a linha 

de: 

		public class HandlingFormSubmissionApplication {
para: 

		public class HandlingFormSubmissionApplication extends SpringBootServletInitializer{
		
		
4 - Se preferir pode testar com o servidor Tomcat copiando a pasta apache-tomcat-8.5.42 para seu servidor, de preferencia Linux, e colocar o .war gerado na pasta 
apache-tomcat-8.5.42/webapps


Caso prefira executar via jar rode o comando abaixo após copiar o arquivo .jar para seu servidor:

sudo java -jar GerenciadorUsuarios.jar --server.port=80
