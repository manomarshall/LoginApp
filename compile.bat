@echo off
javac -cp "lib\servlet-api.jar" -d "webapp\WEB-INF\classes" src\com\example\LoginServlet.java src\com\example\DashboardServlet.java src\com\example\LogoutServlet.java
if %errorlevel%==0 (echo Compiled successfully!) else (echo Compilation failed! && pause)
