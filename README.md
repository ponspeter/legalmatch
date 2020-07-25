# Legalmatch Exam

  Legalmatch exam is a Spring-Angular application for CRUD of Employee with login


## PROCEDURE

```bash
1. Clone the project in your local copy
```
2. The following should be installed before running the application
```
   a. Java 8

   b. Maven latest version

   c. Node JS latest version

   d. Open a terminal or command prompt and perform below to install Angualar CLI
   
      [npm install -g @angular/cli@latest] Make sure it is running as admin account.
  
   e. Mysql version 8
```
3. Run createSchema.sql in your MYSQL to create schema.
```
4. Run the backend

    a. go to exam-be (e.g: cd/exam-be)

    b. Open the project in your favorite ide (IntelliJ) or open  
       terminal or command prompt. Type [mvn spring-boot:run]

    c. Wait until it load, once ready it can accept request in      
       [http://localhost:9090]
```
5. Run the frontend
```
    a. go to exam-fe (e.g: cd/exam-fe)

    b. Open the project in your favorite ide (Visual Studio Code) or open terminal or command prompt.

    c. Type [npm install] to download all dependencies

    e. Type [npm start] to run frontend

    i. once ready, open the request in browser using the link [http://localhost:4200/login]
