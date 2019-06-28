@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ExcelMergeTool startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and EXCEL_MERGE_TOOL_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\excelMergeTool-0.1.0.jar;%APP_HOME%\lib\poi-ooxml-3.9.jar;%APP_HOME%\lib\poi-3.9.jar;%APP_HOME%\lib\poi-ooxml-schemas-3.9.jar;%APP_HOME%\lib\dom4j-1.6.1.jar;%APP_HOME%\lib\groovy-2.5.7.jar;%APP_HOME%\lib\groovy-ant-2.5.7.jar;%APP_HOME%\lib\groovy-cli-commons-2.5.7.jar;%APP_HOME%\lib\groovy-cli-picocli-2.5.7.jar;%APP_HOME%\lib\groovy-console-2.5.7.jar;%APP_HOME%\lib\groovy-datetime-2.5.7.jar;%APP_HOME%\lib\groovy-docgenerator-2.5.7.jar;%APP_HOME%\lib\groovy-groovydoc-2.5.7.jar;%APP_HOME%\lib\groovy-groovysh-2.5.7.jar;%APP_HOME%\lib\groovy-jmx-2.5.7.jar;%APP_HOME%\lib\groovy-json-2.5.7.jar;%APP_HOME%\lib\groovy-jsr223-2.5.7.jar;%APP_HOME%\lib\groovy-macro-2.5.7.jar;%APP_HOME%\lib\groovy-nio-2.5.7.jar;%APP_HOME%\lib\groovy-servlet-2.5.7.jar;%APP_HOME%\lib\groovy-sql-2.5.7.jar;%APP_HOME%\lib\groovy-swing-2.5.7.jar;%APP_HOME%\lib\groovy-templates-2.5.7.jar;%APP_HOME%\lib\groovy-test-2.5.7.jar;%APP_HOME%\lib\groovy-test-junit5-2.5.7.jar;%APP_HOME%\lib\groovy-testng-2.5.7.jar;%APP_HOME%\lib\groovy-xml-2.5.7.jar;%APP_HOME%\lib\commons-codec-1.5.jar;%APP_HOME%\lib\xmlbeans-2.3.0.jar;%APP_HOME%\lib\xml-apis-1.0.b2.jar;%APP_HOME%\lib\ant-1.9.13.jar;%APP_HOME%\lib\ant-junit-1.9.13.jar;%APP_HOME%\lib\ant-launcher-1.9.13.jar;%APP_HOME%\lib\ant-antlr-1.9.13.jar;%APP_HOME%\lib\commons-cli-1.4.jar;%APP_HOME%\lib\picocli-3.9.5.jar;%APP_HOME%\lib\qdox-1.12.1.jar;%APP_HOME%\lib\jline-2.14.6.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\junit-platform-launcher-1.4.0.jar;%APP_HOME%\lib\junit-jupiter-engine-5.4.0.jar;%APP_HOME%\lib\testng-6.13.1.jar;%APP_HOME%\lib\stax-api-1.0.1.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\apiguardian-api-1.0.0.jar;%APP_HOME%\lib\junit-platform-engine-1.4.0.jar;%APP_HOME%\lib\junit-jupiter-api-5.4.0.jar;%APP_HOME%\lib\jcommander-1.72.jar;%APP_HOME%\lib\opentest4j-1.1.1.jar;%APP_HOME%\lib\junit-platform-commons-1.4.0.jar

@rem Execute ExcelMergeTool
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %EXCEL_MERGE_TOOL_OPTS%  -classpath "%CLASSPATH%" com.tool.SecondExperiment %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable EXCEL_MERGE_TOOL_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%EXCEL_MERGE_TOOL_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
