
	para rodar a aplicação é obrigatório que tenha o JDK, NPM e Maven instaladados ná máquina
	
	- back-end é o projeto back end em java feito em spring boot
		- vá até a pasta exercicio3 e digite mvn spring-boot:run ou execute no eclipse importando o projeto no mesmo
	
	- front-end é um projeto front end em angular-1 que roda com um servidor node.js, é necessário que tenha o back end em execução para esse projeto rodar ok
		- vá até a pasta front-end\person
		- execute  o comando npm install
		- execute o comando npm start
		- vá no browse e teste localhost:3000 ou porta padrão


	- execute mvn test e tera o relatório padrão de testes do java
	- execute 'mvn verify' e no diretório target/site/jacoco encontrará um relatório com os testes que foram cobertos
	

	