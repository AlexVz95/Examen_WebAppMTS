# Examen_WebAppMTS
Examen por Meltsan Solutions
Por Ramon Alejandro Perez Vazquez
Pasos para crear la aplicacion Practica_WebApp que es el examen en si
Paso uno deberemos de clonar este proyecto a un sitio que sea de facil acceso
por ejemplo MINGW64 ~/documents/practicasmeltsan/github donde se me facilitara,
ya hubicado en la carpeta procederemos a clonar con el siguiente comando

1. git clone https://github.com/AlexVz95/Examen_WebAppMTS.git
de que termine la clonacion a nuestro disco duro, podremos accesar mediant el comando
2. cd Examen_WebAppMTS
ya dentro de la carpeta procederemos ha hacer la instalacion de nuestras dependencia que incluye nuestro pom.xml
el comando para hacer eso, es el siguiente:
3. mvn clean install
despues de esto debemos de parsear el proyecto a uno que identifique nuestro IDE Eclipse
para ello nos apoyaremos del uso de los siguientes comandos
4. mvn eclipse:eclipse
5. mvn eclipse:eclipse -DwtpVersion=2.0
el primero de ellos es para convertir nuestro proyecto a un proyecto eclipse, el siguiente es para convertir
nuestro proyecto a una aplicacion WebApp, en la cual trabajaremos. Despues de esto ya tendremos nuestro proyecto para manipularlo desde 
eclipse; Dentro de las dependencias incluí los frameworks Log4j, Spring version 4.1.4, Jersey , postgresql en
la veersion mas actual que es la 42.1.1.


Dentro de la carpeta Examen_WebAppMTS podemos ver que hay una carpeta llamada DB, en el esta el DER(Diagrama Entidad Relacional)
ademas de los distintos Scripts para que pueda funcionar nuesta WebApp, en mi caso Utilize PostgreSQL 9.6 y utilize el programa 
pgAdmin 3, ya que el pgAdmin 4 no lo supe manipula ademas que cargaba lento, mi base de datos se llama db_alexvz, en el cual tiene el 
esquema alexvz, donde estan mis tablas, para la utilizacion del proyecto. Dentro del programa ejecutamos las sentencias sql para la correcta utilizacion de la base de datos y se pueda integrar al proyecto, ademas dentro de Spring en un bean debemos de especificar nuestro driver de PostgreSQL, en mi caso:

<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.postgresql.Driver" />
		<property name="url" value="jdbc:postgresql://localhost:5432/db_alexvz"/>
		<property name="username" value="postgres" />
		<property name="password" value="" />
</bean>



