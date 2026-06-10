@echo off
ie4uinit.exe -show
taskkill /f /im explorer.exe
del /a /f /q "%localappdata%\IconCache.db"
del /a /f /q "%localappdata%\Microsoft\Windows\Explorer\iconcache_*.db"
start explorer.exe
echo Cache de icones limpo com sucesso!
pause