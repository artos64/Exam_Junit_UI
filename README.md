# Exam_Junit_UI

## В рамках данного проекта реализован UI автотест сервиса Edujira

_Используемый стек:_
- Java
- Maven
- Junit
- Allure

### Логика проекта организована по паттену Page Object, осуществлена разбивка по:
- [Элементам на страницах](https://github.com/artos64/Exam_Junit_UI/tree/master/src/main/java/pageObject/baseElements)
- [Методам на страницах](https://github.com/artos64/Exam_Junit_UI/tree/master/src/main/java/pageObject/baseSteps)

### Запуск автотестов осуществляется в методе [RunTest](https://github.com/artos64/Exam_Junit_UI/blob/master/src/test/java/Tests/RunTest.java)

### Команды для запуска автотеста через терминал:
- mvn clean test - запуск всех тестов в проекте c удалением временных файлов
- mvn clean test -Dgrops="@AT-48771251" - для запуска по тегам
- mvn allure:report - генерация allure отчета
- mvn allure:serve - генерация allure отчета и разворачивания локального сервера для просмотра сгенерированного allure отчета
