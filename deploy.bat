@echo off
xcopy /E /Y /I webapp "C:\apache-tomcat-9.0.116\webapps\LoginApp"
echo Deployed to Tomcat!
