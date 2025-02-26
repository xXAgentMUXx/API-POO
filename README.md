# README - Spring Boot API with Java

## Description
This project is an API built with **Spring Boot** and **Java**. It creates a RESTful application that can be used to perform operations on the data.

## Prerequisites

Before you start, make sure that the following tools are installed on your machine:

- ***Java 17 ou plus (or a version compatible with Spring Boot)
Extension VS Code :
- **Extension pack for java (made by Microsoft)
- **Gradle for java (for the dependencies)
- Springboot extension (for unfolding the API)
Tools for executing the API :
- **Postman, Powershell ou Curl.exe pour tester l'API

## Github Links

Links of the project available on :

https://github.com/xXAgentMUXx/API-POO## Démarrer le Serveur

## Start the Server

1. Open PowerShell.
2. Go to the project directory (example: ‘demo cd’).
3. Run the following command to start the server:
   `bash
   . /gradlew.bat bootRun


## Command API :

Here are the commands that you can do to add, update or suppress the data :

NOTE: After starting the server, you need to add a new terminal to add or implement these commands.

Commands for course.java (Courses) :

Add a Course (with JSON file) :
Invoke-WebRequest -Uri "http://localhost:8080/courses" -Method Post `
-Headers @{"Content-Type"="application/json"; "charset"="utf-8"} `
-Body ([System.Text.Encoding]::UTF8.GetBytes((Get-Content -Raw -Path "data.json")))

Add a Course (without JSON file) :
Invoke-WebRequest -Uri "http://localhost:8080/courses" -Method Post `
-Headers @{"Content-Type"="application/json"} `
-Body '{"courseName":"Mathematics","courseCode":"MATH101","credits":3}'

Get the List of Courses :
Invoke-WebRequest -Uri "http://localhost:8080/courses" -Method Get

Delete a Course :
Invoke-WebRequest -Uri "http://localhost:8080/courses/1" -Method Delete

Update a Course :
Invoke-WebRequest -Uri "http://localhost:8080/courses/1" -Method Put `
-Headers @{"Content-Type"="application/json"} `
-Body '{"courseName":"Physics","courseCode":"PHY101","creditHours":4}'

Commands for enrollment.java (Enrollments) :

Add an Enrollment :
Invoke-WebRequest -Uri "http://localhost:8080/enrollments" -Method Post `
-Headers @{"Content-Type"="application/x-www-form-urlencoded"} `
-Body "studentId=1&courseId=1"

Delete an Enrollment :
Invoke-WebRequest -Uri "http://localhost:8080/enrollments/1" -Method Delete

Update an Enrollment :
Invoke-WebRequest -Uri "http://localhost:8080/enrollments/1" -Method Put `
-Headers @{"Content-Type"="application/json"} `
-Body '{"studentId":2, "courseId":3}'

Commands for student.java (Students) :

Add a Student (with JSON file) :
Invoke-WebRequest -Uri "http://localhost:8080/students" -Method Post `
-Headers @{"Content-Type"="application/json"; "charset"="utf-8"} `
-Body ([System.Text.Encoding]::UTF8.GetBytes((Get-Content -Raw -Path "student.json")))

Add a Student (without JSON file) :
Invoke-WebRequest -Uri "http://localhost:8080/students" -Method Post `
-Headers @{"Content-Type"="application/json"} `
-Body '{"name":"John Doe","age":21,"studentID":12345,"grades":[14,16,12,18,15]}'

Get a Student's Details : 
Invoke-WebRequest -Uri "http://localhost:8080/students/1" -Method Get
Delete a Student :
Invoke-WebRequest -Uri "http://localhost:8080/students/1" -Method Delete

Update a Student :
Invoke-WebRequest -Uri "http://localhost:8080/students/1" -Method Put `
-Headers @{"Content-Type"="application/json"} `
-Body '{"name":"New Name","age":25,"studentId":1234}'

Commands for admin.java (Administration) :

Delete All Data :
Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAll" -Method Delete

Delete All Enrollments :
Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAllEnrollments" -Method Delete

Delete All Courses :
Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAllCourses" -Method Delete

Delete All Students :
Invoke-WebRequest -Uri "http://localhost:8080/admin/deleteAllStudents" -Method Delete

