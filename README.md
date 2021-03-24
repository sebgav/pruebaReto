

Proyecto creado en java, abarca una de las pruebas funcionales de la aplicación.
La prueba consiste en realizar un registro de un usuari, con sus datos personales.

# Getting Started

1.	Installation process

Para ejecutar el proyecto de forma local, lo primero que debes instalar es un IDE puedes utilizar el que desees.
(Eclipse, Intellij, VisualStudioCode.)

2.	Software dependencies

El proyecto tiene un gestor de dependencias Gradle
framework: Cucumber With Serenity
ChromeDriver
las librerias que se utilizan son
'serenity-core', version: '2.0.39'
'serenity-cucumber', version: '1.9.30'
'serenity-junit', version: '2.0.39'
'org.slf4j:slf4j-simple:1.7.7'
'junit:junit:4.12'



# Build and Test
La construccion iniciar con el archivo .feature empleando la tecnica BDD, donde utilizamos las Historias de Usuario
y partimos con los requierimientos given, when, then.
Con el resultado obetenemos los metodos con los que iniciarmos la construcción de nuestro codigo.
Utilizamos las librerias de PageObejectModel.
La ejecución se realiza desde la clase RunnerTestSite

#forma para los elementos day month and year
//getDriver().findElement(By.xpath("//option[contains(text(),'"+datos.get(22)+"')]")).click();