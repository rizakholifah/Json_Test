@ECHO OFF
IF "%OS%"=="Windows_NT" (
SET HOSTFILE=%windir%\system32\drivers\etc\hosts
) ELSE (
SET HOSTFILE=%windir%\hosts
)
ECHO.>> %HOSTFILE%
ECHO 127.0.0.1       tonec.com>> %HOSTFILE%
ECHO 127.0.0.1       www.tonec.com>> %HOSTFILE%
ECHO 127.0.0.1       registeridm.com>> %HOSTFILE%
IPCONFIG -flushdns
CLS
ECHO.
ECHO Disable Activation
ECHO Provided by: P30download Group - www.p30download.com
ECHO.
PAUSE