call mvn clean package -Dmaven.test.skip=true

echo copy start!
rem need modify
set BASE_HOME=E:\opensource\autocoder
copy "%BASE_HOME%\README.TXT" "%BASE_HOME%\bin\README.TXT"
copy "%BASE_HOME%\baseconfig.yaml" "%BASE_HOME%\bin\baseconfig.yaml" 
xcopy "%BASE_HOME%\target\classes\com" "%BASE_HOME%\bin\lib\com" /S /E /Y
xcopy "%BASE_HOME%\target\tea-1.0.1-release" "%BASE_HOME%\bin\lib" /S /E /Y
xcopy "%BASE_HOME%\template" "%BASE_HOME%\bin\template" /S /E /Y
del "%BASE_HOME%\bin\lib\tea-1.0.1.jar"

