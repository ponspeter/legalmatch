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

   d. Git
  
   e. Mysql version 8

   f. Go to legalmatch/exam-be/config/application-local.properties and configure the mysql credentials.

   # Username and password
  
spring.datasource.username = root # change according to your local setup
spring.datasource.password = Qwerty@123456 # change according to your local setup
```
3. Run createSchema.sql in your MYSQL to create schema.
```
4. Run the backend

    a. go to exam-be (e.g: cd/exam-be)

    b. Open the project in your favorite ide (IntelliJ) or open  
       terminal or command prompt. Type [mvn spring-boot:run]

    c. It will download all the dependencies and compile. Once ready, it can accept request in [http://localhost:9090]
```
5. Run the frontend
```
    a. go to exam-fe (e.g: cd/exam-fe)

    b. Open the project in your favorite ide (Visual Studio Code) or open terminal or command prompt.

    c. Type [npm install] to download all dependencies

    e. Type [npm start] to run frontend

    i. It will compile and once ready, open the request in browser using the link [http://localhost:4200/login]

    Login Credentials:

    Role                     Username                Password
    ADMIN                  MANALO_JOSE            Qwerty@123456
    STANDARD_USER          PONS_PETER             Salty@123456

    Note: Every time a new employee is add, he / she can login in the application with his /her username "LASTNAME_FIRSTNAME" and password "Salty@123456"
           