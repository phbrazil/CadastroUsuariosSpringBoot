# Aplicação web em Spring Boot com Mysql

Para gerar um arquivo .war e rodar em seu servidor preferido como Jboss ou Tomcat e desabilitar o servidor nativo do Spring basta alterar os arquivos abaixo;


1 - No pom xml renomeie a linha de <packaging>jar</packaging> para <packaging>war</packaging>

2 - No pom xml comente ou remova o bloco: 
		 "<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
         </dependency>"
		
3 - Na classe Main renomeie a linha de "public class HandlingFormSubmissionApplication {" para 
"public class HandlingFormSubmissionApplication extends SpringBootServletInitializer{"
