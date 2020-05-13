# Aplicação web em Spring Boot com Mysql

# EXECUTANDO VIA ARQUIVO .JAR

Caso queira executar sua aplicação via jar, rode o comando abaixo após copiar o arquivo gerado .jar para seu servidor, no caso de servidor Linux:

sudo java -jar GerenciadorUsuarios.jar --server.port=80


# EXECUTANDO VIA ARQUIVO .WAR

Caso prefira gerar um arquivo .war e rodar em seu servidor web preferido como Jboss ou Tomcat e desabilitar o servidor nativo do Spring Boot 
basta alterar os arquivos abaixo;


1 - No pom.xml renomeie a linha packaging de jar para war

2 - No pom.xml descomente o bloco spring-boot-starter-tomcat
		  		
3 - Na classe Main renomeie a linha 

de: 

		public class HandlingFormSubmissionApplication {
para: 

		public class HandlingFormSubmissionApplication extends SpringBootServletInitializer{
		
		
4 - Se preferir pode testar com o servidor Tomcat copiando a pasta apache-tomcat-8.5.42 para seu servidor, de preferencia Linux, e colocar o .war gerado na pasta 
apache-tomcat-8.5.42/webapps

Inicie o servidor rodando o comando sudo sh apache-tomcat-8.5.42/bin/catalina.sh start

# EXECUTANDO EM BACKGROUND 

1 - Crie um arquivo .sh com os dados abaixo:

sudo java -jar /caminho_user_servidor/GerenciadorUsuarios.jar --server.port=8080

2 - Altere a permissão do arquivo .sh criado com o comando abaixo:

sudo chmod +x arquivo.sh

3 - CRIE um arquivo GerenciadorUsuarios.service no caminho /etc/systemd/system com os dados abaixo:

[Unit]
Description=A Spring Boot application
After=syslog.target

[Service]
User=root
ExecStart=/bin/bash caminho_do_arquivo/script/spring.sh
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target

4 - Altere a permissão do arquivo .service com o comando abaixo:

sudo chmod 644 arquivo.service

5 - Atualize os serviços rodando o comando abaixo:

sudo systemctl daemon-reload

6 - Inicie o serviço com o comando abaixo:

sudo systemctl start NomeArquivo.service



