# Приложение для анализа текста на различные ошибки

## Условия для запуска:
- Должна быть установлена Java не ниже 17ой версии и прописана переменная %JAVA_HOME%.

## Запуск приложения:
1) Необходимо разархивировать приложение.  
2) Запустить командную строку(PowerShell/Bash)  
3) Переместиться в корень разархивированного приложения ~/textAnalyzer (например cd c:/java/textAnalyzer)
4) Далее для сборки приложения необходимо использовать команду:  
4.1) Для системы Windows: ./gradlew clean build  
4.2) Для Unix-систем: ./gradlew clean build
5) Для запуска приложения необходимо использовать команду:  
  5.1) Для Windows: /gradlew bootRun  
  5.2) Для Unix: ./gradlew bootRun  

После того как приложение было успешно запущено, открываем браузер и переходим по ссылке http://localhost:8080/ для проверки возможностей API.    

## Функционал приложения:
В данный момент реализован только функционал проверки скобок.