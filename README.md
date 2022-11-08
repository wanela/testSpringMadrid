# testSpringMadrid



1.	Estructura
	La estructura esta definida por los distintas capas y por packages
	-	es.sanitas.app
		o	Inicio de la aplicacion 
	-	es.sanitas.exception
		o	HandlerException, actualmente solo devuelve una sola respuesta
	-	es.sanitas.test.controller
		o	Controlador de la calculadora, puerta de entrada de la app.
	-	 es.sanitas.test.service
		o	Capa de servicio, calcula el resultado, a partir de los parámetros de entrada
	-	es.sanitas.test
		o	Pruebas unitarias         
2.	Dependencias utilizadas
	-	Tracer, interfaz sencilla para imprimir un log,
	-	Log4j, para pintar trazas en ficheros de logs
	-	MathOperation interfaz para poder realizar cálculos usando Lambda 
	-	ErrorMessage clase para formatear los errores devueltos por ExceptionHandler
	-	Junit 5 incluido en el core de Spring Boot
	-	Java 12
	
3.	Funcionalidades
	-	Se ha creado un Web Servicios GET, para realizar pequeños cálculos matemáticos. Pudiéndose, sumar, restar, multiplicar y dividir, dependiendo de los parámetros facilitados vía url.
	
4.	Para incluir nuevas operaciones
	-	Solo se tiene que modificar el servicio.
	
5.	Para compilarlo usando Maven.
	-	Con la versión usada de Spring Boot no se ha podido autolanzar las pruebas unitarias al iniciar la aplicación. Por lo que previo a la construcción, se debe lanzar “mvn test”
	-	Para la compilación “mvn clean install”
	-	Para la instalación se debe usar el “jar” generado en la carpeta “target” dentro del proyecto y desplegarlo en un servidor J2EE.
	
6.	Ejemplos de llmadas de la API
	-	Suma
		i.	{{Servidor}}:{{puerto}}/{{Contexto}}/calculator/?operator=%2B&val2=2&val1=1
		ii.	En local usando Spring Boot Dashboard (Levanta un tomcat Local) - localhost:8080/calculator/?operator=%2B&val2=2&val1=1
	-	Resta
		i.	{{Servidor}}:{{puerto}}/{{Contexto}}/calculator/?operator=%2D&val2=2&val1=1
		ii.	En local usando Spring Boot Dashboard (Levanta un tomcat Local) - localhost:8080/calculator/?operator=%2D&val2=2&val1=1
	-	Multiplicacion
		i.	{{Servidor}}:{{puerto}}/{{Contexto}}/calculator/?operator=%2A&val2=2&val1=1
		ii.	En local usando Spring Boot Dashboard (Levanta un tomcat Local) - localhost:8080/calculator/?operator=%2A&val2=2&val1=1
	-	Division
		i.	{{Servidor}}:{{puerto}}/{{Contexto}}/calculator/?operator=%2F&val2=2&val1=1
		ii.	En local usando Spring Boot Dashboard (Levanta un tomcat Local) - localhost:8080/calculator/?operator=%2F&val2=2&val1=1

