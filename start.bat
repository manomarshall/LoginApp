@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-19
set CATALINA_HOME=C:\apache-tomcat-9.0.116
call "%CATALINA_HOME%\bin\startup.bat"
timeout /t 5 /nobreak
start http://localhost:8080/LoginApp/login.html
