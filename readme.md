# REST приложение для анализа заработной платы отдела.

### Описание проекта

Приложение позволяет:
1) получать данные о всех сотрудниках в системе - всем авторизованным пользователям (по умолчанию используется одна роль для менеджера отдела USER);
2) создавать нового сотрудника, либо менять данные о присутствующих в базе (удалять данные сотрудника) - только для сотрудников своего отдела;
3) просматривать статистику по заработной плате в разрезе позиций (JUNIOR, MIDDLE, SENIOR) и выводить данные о минимальной, максимальной и средней зарплате как за месяц, так и за период с начала года - также только по сотрудникам своего отдела;

Авторизация осуществляется с помощью Spring Security и JWT (время жизни токена - 24 часа)
Взаимодействие с данными с помощью Spring Data JDBC;
СУБД PostgreSQL.
Для тестирования используется in-memory database H2

### Запуск приложения

* Приложение и база данных запускаются в Docker c помощью docker-compose
* для того, чтобы наполнить базу тестовыми данными можно перед сборкой перенести файл data.sql из директории test/resources в main/resources


### Пример создания запроса на получение токена

* в адресной строке в качестве URL передать: (POST) http://localhost:8080/auth/login
* в теле запроса передать json, ex:
  {
  "login": "Java",
  "password": "changeit"
  }
* в качестве ответа придет строка с токеном, который потом нужно будет передавать во всех запросах, требующих авторизации, с типом TYPE="Bearer Token"

### Используемые технологии

* Java 11
* Spring Boot
* Spring Data JDBC
* Lombok
* JUnit /AssertJ
* Graddle