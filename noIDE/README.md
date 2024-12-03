# About the project

This project is about using jdk without an ide.

## JDK installation

just go to Oracle website and install the msi version for JDK 21.

## compile java files source code to bytecode in class files

javac -d bin src/*.java

## execute the code project directory

java -cp bin IHM

## MANIFEST.MF to show where is the app entry point
Manifest-Version: 1.0
Main-Class: IHM
*don't forget to add an empty line*

## put class files in .jar archive
jar cfm  Employee.jar ./src/MANIFEST.MF -C bin .

jar tf Employee.jar

java -jar Employee.jar

## All of these can be used in other project !

add new project "otherProject" directory, put the Employee.jar inside and do : 

javac -cp Employee.jar TestDirectory.java