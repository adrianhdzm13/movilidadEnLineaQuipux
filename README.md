
# Movilidad en Línea automation

Automated testing project created to test new features and quality of Movilidad en Línea product

## Tech Stack

```
Java
Gradle
Serenity BDD
Selenium
Gherkin
Cucumber
Git
```

## Requeriments

To implement the project, the following is required

```
  Java JDK v1.8
  Gradle v7.6
```

## Environment Variables

To run this project, you will need to add the following environment variables to your computer

`GRADLE_HOME`

`JAVA_HOME`

## General details of the implementation
The tests use tasks, interactions, questions, elements of pages (userinterface). The complete structure of the project is the following:

```
+ exceptions
     Classes that control the possible technical and business exceptions that arise during the execution of tests
+ model
     Classes related to the domain model and their respective builders when necessary
+ tasks
     Classes that represent tasks performed by the actor at the business process level
+ interactions
     Classes that represent direct interactions with the user interface
+ userinterface
     Page Objects and Page Elements. Map the objects of the user interface
+ questions
     Objects used to check the status of the application
+ util
     Utility classes
+ runners
     Classes that allow to run the tests
+ step definitions
     Classes that map the Gherkin lines to java code
+ features
     The representation of the stories in cucumber archives
```

## Authors

- [adrianhdzm13](https://github.com/adrianhdzm13)







    


