## 3.  Модуль #3. Работа с БД 

<!-- MarkdownTOC autolink="true" levels="3,4" -->

- [3.1 Разница между провверяемыми и непроверяемыми исключениями. Почему в Spring предпочтительнее непроверяемые. Иерархия исключений доступа к данным.](#31-%D0%A0%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-%D0%BF%D1%80%D0%BE%D0%B2%D0%B2%D0%B5%D1%80%D1%8F%D0%B5%D0%BC%D1%8B%D0%BC%D0%B8-%D0%B8-%D0%BD%D0%B5%D0%BF%D1%80%D0%BE%D0%B2%D0%B5%D1%80%D1%8F%D0%B5%D0%BC%D1%8B%D0%BC%D0%B8-%D0%B8%D1%81%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D1%8F%D0%BC%D0%B8-%D0%9F%D0%BE%D1%87%D0%B5%D0%BC%D1%83-%D0%B2-spring-%D0%BF%D1%80%D0%B5%D0%B4%D0%BF%D0%BE%D1%87%D1%82%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%B5%D0%B5-%D0%BD%D0%B5%D0%BF%D1%80%D0%BE%D0%B2%D0%B5%D1%80%D1%8F%D0%B5%D0%BC%D1%8B%D0%B5-%D0%98%D0%B5%D1%80%D0%B0%D1%80%D1%85%D0%B8%D1%8F-%D0%B8%D1%81%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D0%B9-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%B0-%D0%BA-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D0%BC)
- [3.2 Как настроить DataSource в Spring](#32-%D0%9A%D0%B0%D0%BA-%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%BE%D0%B8%D1%82%D1%8C-datasource-%D0%B2-spring)
    - [3.2.1 Основы](#321-%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B)
    - [3.2.2 Создание через EmbeddedDataSourceBuilder](#322-%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D1%87%D0%B5%D1%80%D0%B5%D0%B7-embeddeddatasourcebuilder)
    - [3.2.3 Создание через BasicDataSource из Apache DBCP](#323-%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D1%87%D0%B5%D1%80%D0%B5%D0%B7-basicdatasource-%D0%B8%D0%B7-apache-dbcp)
    - [3.2.4 Использование класса DataSourceInitializer для инициализации БД](#324-%D0%98%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0-datasourceinitializer-%D0%B4%D0%BB%D1%8F-%D0%B8%D0%BD%D0%B8%D1%86%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8-%D0%91%D0%94)
    - [3.2.5 Создание DataSource в SpringBoot](#325-%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-datasource-%D0%B2-springboot)
- [3.3 Паттерн Template и JDBC Template](#33-%D0%9F%D0%B0%D1%82%D1%82%D0%B5%D1%80%D0%BD-template-%D0%B8-jdbc-template)
- [3.4 Что такое Callback. Как они используются в JdbcTemplate](#34-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-callback-%D0%9A%D0%B0%D0%BA-%D0%BE%D0%BD%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8E%D1%82%D1%81%D1%8F-%D0%B2-jdbctemplate)
    - [3.4.1 Про callback](#341-%D0%9F%D1%80%D0%BE-callback)
    - [3.4.2 Коллбеки в JdbcTemplate](#342-%D0%9A%D0%BE%D0%BB%D0%BB%D0%B1%D0%B5%D0%BA%D0%B8-%D0%B2-jdbctemplate)
- [3.5 Можно ли выполнить простой запрос с помощью JdbcTemplate](#35-%D0%9C%D0%BE%D0%B6%D0%BD%D0%BE-%D0%BB%D0%B8-%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B8%D1%82%D1%8C-%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%B9-%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-jdbctemplate)
- [3.6 Как JdbcTemplate создает/получает соединение \(connection\)](#36-%D0%9A%D0%B0%D0%BA-jdbctemplate-%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%B5%D1%82%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B0%D0%B5%D1%82-%D1%81%D0%BE%D0%B5%D0%B4%D0%B8%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5-connection)
- [3.7 Как JdbcTemplate поддерживает универсальные \(generic\) запросы.](#37-%D0%9A%D0%B0%D0%BA-jdbctemplate-%D0%BF%D0%BE%D0%B4%D0%B4%D0%B5%D1%80%D0%B6%D0%B8%D0%B2%D0%B0%D0%B5%D1%82-%D1%83%D0%BD%D0%B8%D0%B2%D0%B5%D1%80%D1%81%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-generic-%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81%D1%8B)
- [3.8 Что такое транзакция. Глобальные и локальные транзакции.](#38-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D1%8F-%D0%93%D0%BB%D0%BE%D0%B1%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D0%B8-%D0%BB%D0%BE%D0%BA%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D0%B8)
- [3.9 Транзакция это cross cutting concern?](#39-%D0%A2%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D1%8F-%D1%8D%D1%82%D0%BE-cross-cutting-concern)
- [3.10 Как определить транзакцию в Spring. Аннотация @Transactional. Что такое PlatformTransactionManager.](#310-%D0%9A%D0%B0%D0%BA-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D1%8E-%D0%B2-spring-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-transactional-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-platformtransactionmanager)
- [3.11 Может ли JdbcTemplate участовать в уже существующей транзакции](#311-%D0%9C%D0%BE%D0%B6%D0%B5%D1%82-%D0%BB%D0%B8-jdbctemplate-%D1%83%D1%87%D0%B0%D1%81%D1%82%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D0%B2-%D1%83%D0%B6%D0%B5-%D1%81%D1%83%D1%89%D0%B5%D1%81%D1%82%D0%B2%D1%83%D1%8E%D1%89%D0%B5%D0%B9-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D0%B8)
- [3.12 Что такое уровень изолированности транзакции](#312-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-%D1%83%D1%80%D0%BE%D0%B2%D0%B5%D0%BD%D1%8C-%D0%B8%D0%B7%D0%BE%D0%BB%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D0%BE%D1%81%D1%82%D0%B8-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D0%B8)
- [3.13 Аннотация @EnableTransactionManagment](#313-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-enabletransactionmanagment)
- [3.14 Что такое распространение транзакций \(propagation\)](#314-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-%D1%80%D0%B0%D1%81%D0%BF%D1%80%D0%BE%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D0%B9-propagation)
- [3.15 Что произойдет, если один @Transactional метод вызывает другой @Transactional метод того же самого класса](#315-%D0%A7%D1%82%D0%BE-%D0%BF%D1%80%D0%BE%D0%B8%D0%B7%D0%BE%D0%B9%D0%B4%D0%B5%D1%82-%D0%B5%D1%81%D0%BB%D0%B8-%D0%BE%D0%B4%D0%B8%D0%BD-transactional-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4-%D0%B2%D1%8B%D0%B7%D1%8B%D0%B2%D0%B0%D0%B5%D1%82-%D0%B4%D1%80%D1%83%D0%B3%D0%BE%D0%B9-transactional-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4-%D1%82%D0%BE%D0%B3%D0%BE-%D0%B6%D0%B5-%D1%81%D0%B0%D0%BC%D0%BE%D0%B3%D0%BE-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0)
- [3.16 Где может располагаться @Transactional.](#316-%D0%93%D0%B4%D0%B5-%D0%BC%D0%BE%D0%B6%D0%B5%D1%82-%D1%80%D0%B0%D1%81%D0%BF%D0%BE%D0%BB%D0%B0%D0%B3%D0%B0%D1%82%D1%8C%D1%81%D1%8F-transactional)
- [3.17 Что такое декларативное управление транзакциями](#317-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-%D0%B4%D0%B5%D0%BA%D0%BB%D0%B0%D1%80%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D0%BE%D0%B5-%D1%83%D0%BF%D1%80%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D1%8F%D0%BC%D0%B8)
- [3.18 Режимы отката транзакции \(rollback policy\)](#318-%D0%A0%D0%B5%D0%B6%D0%B8%D0%BC%D1%8B-%D0%BE%D1%82%D0%BA%D0%B0%D1%82%D0%B0-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D0%B8-rollback-policy)
- [3.19 Как работают тесты \(@Test\) cовместно с @Transactional](#319-%D0%9A%D0%B0%D0%BA-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%D1%8E%D1%82-%D1%82%D0%B5%D1%81%D1%82%D1%8B-test-c%D0%BE%D0%B2%D0%BC%D0%B5%D1%81%D1%82%D0%BD%D0%BE-%D1%81-transactional)
- [3.20 Термин Unit of Work. Свойство AutoCommit у JDBC.](#320-%D0%A2%D0%B5%D1%80%D0%BC%D0%B8%D0%BD-unit-of-work-%D0%A1%D0%B2%D0%BE%D0%B9%D1%81%D1%82%D0%B2%D0%BE-autocommit-%D1%83-jdbc)
- [3.21 Работа c JPA](#321-%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-c-jpa)
- [3.22 Может ли DAO на основе JPA участвовать в существующей транзакции](#322-%D0%9C%D0%BE%D0%B6%D0%B5%D1%82-%D0%BB%D0%B8-dao-%D0%BD%D0%B0-%D0%BE%D1%81%D0%BD%D0%BE%D0%B2%D0%B5-jpa-%D1%83%D1%87%D0%B0%D1%81%D1%82%D0%B2%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D0%B2-%D1%81%D1%83%D1%89%D0%B5%D1%81%D1%82%D0%B2%D1%83%D1%8E%D1%89%D0%B5%D0%B9-%D1%82%D1%80%D0%B0%D0%BD%D0%B7%D0%B0%D0%BA%D1%86%D0%B8%D0%B8)
- [3.23 Какие PlatformTransactionManager можно использовать с JPA](#323-%D0%9A%D0%B0%D0%BA%D0%B8%D0%B5-platformtransactionmanager-%D0%BC%D0%BE%D0%B6%D0%BD%D0%BE-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D1%81-jpa)
- [3.24 Как настроить конфигурацию для работы с JPA. Как Spring Boot упрощает это.](#324-%D0%9A%D0%B0%D0%BA-%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%BE%D0%B8%D1%82%D1%8C-%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D1%8E-%D0%B4%D0%BB%D1%8F-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B-%D1%81-jpa-%D0%9A%D0%B0%D0%BA-spring-boot-%D1%83%D0%BF%D1%80%D0%BE%D1%89%D0%B0%D0%B5%D1%82-%D1%8D%D1%82%D0%BE)
- [3.25 Интерфейс Repository](#325-%D0%98%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81-repository)
- [3.26 Как определить Repository. Почему это интерфейс, а не класс](#326-%D0%9A%D0%B0%D0%BA-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C-repository-%D0%9F%D0%BE%D1%87%D0%B5%D0%BC%D1%83-%D1%8D%D1%82%D0%BE-%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81-%D0%B0-%D0%BD%D0%B5-%D0%BA%D0%BB%D0%B0%D1%81%D1%81)
- [3.27 Конвенции наименования для методов поиска для Репозиториев](#327-%D0%9A%D0%BE%D0%BD%D0%B2%D0%B5%D0%BD%D1%86%D0%B8%D0%B8-%D0%BD%D0%B0%D0%B8%D0%BC%D0%B5%D0%BD%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-%D0%B4%D0%BB%D1%8F-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%BE%D0%B2-%D0%BF%D0%BE%D0%B8%D1%81%D0%BA%D0%B0-%D0%B4%D0%BB%D1%8F-%D0%A0%D0%B5%D0%BF%D0%BE%D0%B7%D0%B8%D1%82%D0%BE%D1%80%D0%B8%D0%B5%D0%B2)
- [3.28 Как Репозиторий реализуется Спрингом в рантайме](#328-%D0%9A%D0%B0%D0%BA-%D0%A0%D0%B5%D0%BF%D0%BE%D0%B7%D0%B8%D1%82%D0%BE%D1%80%D0%B8%D0%B9-%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D1%83%D0%B5%D1%82%D1%81%D1%8F-%D0%A1%D0%BF%D1%80%D0%B8%D0%BD%D0%B3%D0%BE%D0%BC-%D0%B2-%D1%80%D0%B0%D0%BD%D1%82%D0%B0%D0%B9%D0%BC%D0%B5)
- [3.29 Аннотация @Query](#329-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-query)

<!-- /MarkdownTOC -->

### 3.1 Разница между провверяемыми и непроверяемыми исключениями. Почему в Spring предпочтительнее непроверяемые. Иерархия исключений доступа к данным.

***Проверяемые*** - наследники `java.lang.Exception` (кроме RuntimeException). Обязаны перехватываться или включаться в сигнатуру методов

Плюсы: 

* Явное указание API (перехват исключений явно требуется)
* Проверка на уровне компилятора

Минусы:

* Усложнение кода
* Увеличение связанности между классами (исключения и классы, в которых используются)

***Непроверяемые*** - наследники `java.lang.RuntimeException`. Не требуют явной обработки, обрабатываются по желанию.

Плюсы:

* Упрощение кода
* Уменьшение связанности классов

Минусы:

* Можно пропусть ситуацию, когда ошибка остается без обработки
* Компилятор никак не помогает в отслеживании таких ошибок

Spring использует непроверяемые исключения из-за их преимуществ. Вводит свою иерархию исключений, чтобы отвязаться от сторонних библиотек, конкретного API (напр. JDBC) и т. п.

Корневое исключение - **DataAccessException**. Это обертка для исключений JDBC, Hibernate, JPA и т. п.



### 3.2 Как настроить DataSource в Spring

#### 3.2.1 Основы

DataSource представляет подключение к sql базе данных. Это интерфейс **javax.sql.DataSource**

В Спринге можно создать бин этого типа любым способом. Например в **@Configuration** классе создать метод с **@Bean**, возвращающий экземпляр **DataSource**.

Возвращать можно готовые классы:

* **DriverManagerDataSource** - реализация для JDBC драйвера
* **BasicDataSource** - для пула соединений Apache DBCP
* **ComboPooledDataSource** - для пула C3PO
* **SmartDataSource**
* **AbstractDataSource**
* **SingleConnectionDataSource**
* и др.

Настройка **DataSource**

* для автономного - в конфигурационном классе **@Configuration**
* Spring Boot - через файл свойств `application.properties`
* веб-приложение - через JNDI с помощью `JndiDataSourceLookup`/`JndiTemplate`

#### 3.2.2 Создание через EmbeddedDataSourceBuilder

Пакет `org.springframework.jdbc.datasource.embedded` (подключить зависимость **spring-jdbc**)

Создает встроенную базу данных (в памяти). Можно выбрать тип БД: H2, HSQL, Derby (не забыть зависимость подключить).

    DataSource ds = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .addScript("db-schema.sql")
                .addScripts("db-test-data.sql")
                .build();

Разные методы:

* `setType()` - затает тип базы (H2, HSQL, Derby). По умолчанию - H2.
* `generateUniqueName(boolean)` - если этот билдер используется несколько раз (например для нескольких контекстов), определяет будут ли различаться базы данных.
* `setName(String)` - можно задать имя, вместо автогенерируемого
* `addDefaultScripts()` - добавляет скрипты для инициализации и заполнения БД перед созданием БД. Имена по умолчанию - **schema.sql** и **data.sql**. Располагаются в `/resources` 
* `addScript(String)`, `addScripts(String ...)` - добавляет скрипты с указанием имен.
* `setScriptEncoding(String)` - устанавливает кодировку для скриптов
* `continueOnError(boolean)` - не прекращать работу при ошибках в скрипте. По умолчанию - `false`
* `ignoreFailedDrop(boolean)` - следует ли игнорировать ошибки при выполнении `DROP` в скрипте.



#### 3.2.3 Создание через BasicDataSource из Apache DBCP

Apache DBCP - библиотека для создания пула соединений с БД.

Класс **BasicDataSource** создает источник, пригодный для большинства применений (с пулом)

    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
    basicDataSource.setUrl("jdbc:hsqldb:mem:localhost");

#### 3.2.4 Использование класса DataSourceInitializer для инициализации БД

Класс **DataSourceInitializer** из пакета `org.springframework.jdbc`

Общая схема:

* регистрируем как бин
* при создании передаем бин DataSource (если такой бин есть должно сработать `@Autowired`) и устанавливаем `setDataSource()`
* также при создании задаем **DatabasePopulator** `setDatabasePopulator()`, где указываем sql-скрипты.
* можно указать **DatabasePopulator** для очистки БД `setDatabaseCleaner()`

Здесь **DatabasePopulator** - интерфейс. Реализация - **ResourceDatabasePopulator** (устанавливает скрипты)

Можно на разные профили разные инициализаторы создавать.

Пример см. в репозитории.




#### 3.2.5 Создание DataSource в SpringBoot

Подключаем стартер **spring-boot-starter-data-jdbc**

Теперь можем указать предопределенные свойства в файле `application.properties` **spring.datasource.url** и т. п.

Полный список см. [docs](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#common-application-properties-data)

Также можно задать скрипты, расположенные в `/resources`. Имена по умолчанию `schema.sql` и `data.sql`. Впрочем тоже через свойства можно переопределить.



### 3.3 Паттерн Template и JDBC Template

Паттерн Template - паттерн для инкапсуляции последовательности шагов алгоритма. Достигается за счет создания абстрактного класса с перечнем методов. Часть этих методов может быть иметь реализацию (общие для шаблона). Остальные реализуются в конкретных классах. 

Проблема паттерна - связывание классов через наследование. Может помочь паттерн стратегия - для тех же целей, но работает через композицию, вместо наследования.

**Spring JdbcTemplate** - шаблон для выполнения sql-запросов. Берет на себя всю работу по открытию соединения, запуску выражения, обработке исключений и т. п.

[docs](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#jdbc-core)

Это класс в `org.springframework.jdbc.core`


### 3.4 Что такое Callback. Как они используются в JdbcTemplate

#### 3.4.1 Про callback

Это код или ссылка на другой код, который может передаваться как аргумент в метод. Этот код будет вызван методом во время выполнения.

Способы задания коллбеков:

* класс, реализующий интерфейс
* анонимный класс
* лямбда-выражение
* reference-method

#### 3.4.2 Коллбеки в JdbcTemplate

Используются в разных вариантах метода **query(String sql, <тут один из типов>)** 

**Интерфейс RowMapper**

Сигнатура метода объекта JdbcTemplate:

    public <T> List<T> query(String sql, RowMapper<T> mapper)

Сигнатура метода интерфейса:

    T mapRow(ResultSet rs, int rowNum)

Обходит **ResultSet** и преобразует каждую строку в объект типа `T`. Сам объект **RowMapper** обычно stateless. Реализация только вызывает `ResultSet::getXXX()`, на основе полученных значений формируется объект. Релизация никогда не вызывает `ResultSet::next()`.

    List<String> names = jdbcTemplate.query(
            "select employee_id, first_name from employee",
            (rs, rowNum) -> {
                String name = rs.getString("first_name");
                return name;
            }
    );


**Интерфейс RowCallbackHandler**

Сигнатура метода JdbcTemplate:

    public void query(String sql, RowCallbackHandler rch)

Сигнатура метода интерфейса:

    void processRow(ResultSet rs)

Как и **RowMapper** обходит каждую строку результата запроса. Но ничего не возвращает. Поэтому обычно имеет состояние (не stateless). Реализация может вызывать `ResultSet::getXXX()`, но не должна вызывать `ResultSet::next()`. `proccessRow()` обычно извлекает данные и сохраняет / накапливает их в полях класса-реализации.

    public class TotalSalaryRowCallbackHandler implements RowCallbackHandler {
        private int totalSalary;
        @Override
        public void processRow(ResultSet rs) throws SQLException {
            int currentSalary = rs.getInt("salary");
            totalSalary = totalSalary + currentSalary;
        }
    }


**Интерфейс ResultSetExtractor**

Сигнатура метода JdbcTemplate:

    <T> T query(String sql, ResultSetExtractor<T> rse)

Сигнатура метода интерфейса:

    T extractData(ResultSet rs)

Реализация интерфейса сама должна обойти результат запроса (метод `ResultSet::next()`), сформировать какое-то значение и вернуть его. Обычно stateless. Закрывать `ResultSet` не нужно.

    int total = jdbcTemplate.query("select salary from employee",
        rs -> {
            int total1 = 0;
            while (rs.next()) {
                total1 = total1 + rs.getInt("salary");
            }
            return total1;
        });


### 3.5 Можно ли выполнить простой запрос с помощью JdbcTemplate

Да, см. следующие методы:

* query
* queryForList
* queryForObject - возвращает объект в единственном экземпляре. 
    - ожидает, что в результате запроса - одна строка
    - два вида сигнатур:
        + с RowMapper'ом `queryForObject("select ...", (rs, num) -> {...})`
        + с ожидаемым типом `queryForObject("select ...", String.class)`. Здесь еще ожидает, что колонка в результате ровно одна.
    - можно выполнять параметризированные запросы, параметры тогда передаются через varargs или массивом.
* queryForMap
* queryForRowSet
* execute - универсальный запрос, DDL обычно
* update - запросы INSERT, UPDATE, DELETE 
* batchUpdate

### 3.6 Как JdbcTemplate создает/получает соединение (connection)

Есть DataSource использует пул соединений, тогда соединение не закрывается/создается, а забирается из пула/возвращается в пул

На каждый запрос получается соединение. После выполнения запроса соединение закрывается / возвращается в пул. Так минимизируется время удержания соединения в занятом состоянии.

Но если несколько запросов выполняются в транзакции, тогда используется одно соединение, до тех пор пока транзакция не будет завершена или не произойдет откат. Закрытие соединения в процессе транзакции приведет к откату транзакции.

    @Transactional
    public void doQueries() {
        ...
    }

Если смотреть на исходники: получение соединения - **DataSourceUtils**. Работа с транзакциями - **TransactionSynchronizationManager**


### 3.7 Как JdbcTemplate поддерживает универсальные (generic) запросы.

Универсальные запросы поддерживаются для следующих методов:

* **queryForObject** - возвращает единственный экземпляр объекта. Ожидается, что результат запроса содержит только одну запись. Если не так - исключение **IncorrectResultSizeDataAccessException**.
    - можно указать тип ожидаемый тип параметром
    - или передать маппер **RowMapper**
* **queryForList** - возвращает список объектов заданного типа. Предполагается, что результат запроса содержит одну колонку, иначе - исключение.
* **queryForMap** - также ожидается одна строка, но число колонок не ограничено. Имена колонок идут как ключи, значения - в значения Map. Возвращает всегда тип `Map<String, Object>`. 
* **queryForRowSet** - возвращает экземпляр **SqlRowSet** - спринговый вариант **javax.sql.ResultSet** (не вызывает проверяемых исключений). Также позволяет получать метаданные, обходить результат и т. п.

Эти методы имеют различные сигнатуры, позволяют выполнять параметризованные запросы например.

Внутри используются:

* стандартный **SingleColumnRowMapper** или пользовательская реализация **RowMapper** для **queryForObject**
* **SingleColumnRowMapper** для метода **queryForList**
* **ColumnMapRowMapper** для метода **queryForMap** 

### 3.8 Что такое транзакция. Глобальные и локальные транзакции.

Транзакция - операция, состоящая из набора задач, в которой или все эти задачи выполняются, или не выполняется ни одна.

ACID-принципы транзакции:

* **Атомарность** - все изменения принимаются или ни одно не должно произойти
* **Консистентность** - система должна переходить из одного допустимого состояния в другое допустимое состояние. Никакие промежуточные состояния не должны быть видны для пользователей системы.
* **Изолированность** - ни одна транзакция не должна влиять на другую. Конкурентное выполнение транзакций должно вести к состоянию, как если бы транзакции выполнялись последовательно.
* **Прочность** (durability) - если транзакция была завершена, данные будут сохранены, несмотря на любые падения системы, питания и т. п.

**Глобальная транзакция** - транзакция, применяемая сразу к нескольким ресурсам (разные БД и т. п.). Решение - например JTA со своим собственным сервером приложения

**Локальная транзакция** - транзакция, применяемая к единственному ресурсу. Много проще реализуется, чем глобальные, обычно СУБД обеспечивает реализацию.

### 3.9 Транзакция это cross cutting concern?

Cross cutting concern - это второстепенная функциональность, не связанная напрямую с бизнес-логикой, но пронизывающая все приложение. Примеры: логгирование, безопасность, транзакции и др.

В Spring транзакции выражаются через **@Transactional**. Ставится над методов или классом (тогда все методы - в транзакции).

Транзакционные методы проксируются классами **TransactionInterceptor** и **TransactionAspectSupport**, чтобы фиксировать или откатывать транзакции.

### 3.10 Как определить транзакцию в Spring. Аннотация @Transactional. Что такое PlatformTransactionManager.

см. пример [m3-q08-transaction]

Определение транзакции в Spring:

* Разрешить транзакции через аннотацию **@EnableTransactionManagment** над конфигурационным классом
* Создать бин, реализующий интерфейс **PlatformTransactionManager**
    - **DataSourceTransactionManager**
    - **JtaTransactionManager**
    - **JpaTransactionManager**
    - и другие
* Указать **@Transactional** над методом или классом

**Аннотация @Transactional**

Над методом означает, что метод выполняется в транзакции. Над классом - все методы класса в транзакции.

Вызовы таких методов проксируются через **TransactionInterceptor** и **TransactionAspectSupport**, которые передают управление **PlatformTransactionManager**.

Свойства аннотации позволяют настраивать/задавать:

* менеджер транзакций (вместо заданного бином по умолчанию)
* тип распространения (propagation) транзакций
* уровень изоляции
* таймаут для транзакции
* флаг только для чтения
* определять какие исключения вызывают откат транзакции
* какие не вызывают

**Интерфейс PlatformTransactionManager**

Управляет транзакциями.

Методы:

* **getTransaction()** - возвращает активную транзакцию или создает новую
* **commit()** - коммитит транзакцию или откатывает, если была помечена на откат
* **rollback()** - откатывает транзакцию


### 3.11 Может ли JdbcTemplate участовать в уже существующей транзакции

Да. Через **DataSourceUtils** и **TransactionSynchronizationManager**. Через них и определяется текущая транзакция.

### 3.12 Что такое уровень изолированности транзакции

Уровень изолированности определяет как изменения в одной транзакции отражаются на других паралелльных транзакциях. Чем выше уровень, тем более согласованны данные (изменения в незавершенной транзакции не видны другим транзакциям). При низких уровнях изменения в незавершенных транзакциях могут быть видны другим транзакциям. Высокие уровни дают более согласованный доступ к данным, но снижают производительность системы.

При параллельном выполнении транзакций могут возникать следующие проблемы:

* **фантомное чтение** (phantom read)
    - транзакция № 1 несколько раз одинаковым запросом читает (не конкретную строку, а какой-то диапазон) какие-либо данные
    - между чтениями из транзакции № 1, транзакция № 2 (пока транзакция № 1 не закрыта) вставляет данные в таблицу, которую читает транзакция № 1
    - в результате транзакция № 1 получит разные данные в одинаковых запросах
    - чтобы избежать - нужна блокировка на диапазон (range locks)
* **неповторяющееся чтение** (non-repeatable read)
    - почти то же, что и фантомное чтение, но транзакция № 2 не вставляет, а изменяет данные
    - нужна блокировка на чтение-запись (read-write locks)
* **грязное чтение** (dirty read)
    - транзакция № 1 добавляет/изменяет данные, а потом откатывается
    - до отката транзакции № 1, транзакция № 2 читает данные и видит изменения, сделанные транзакцией № 1
    - нужен запрет на незакоммиченные изменения (uncommited locks)
* **потерянное обновление** (lost update)
    - две транзакции пытаются изменить одно и то же значение, одно из изменений теряется
    - например `UPDATE tbl1 SET f2=f2+20 WHERE f1=1` и `UPDATE tbl1 SET f2=f2+55 WHERE f1=1`
    - если здесь транзакции не блокируются, может возникнуть ситуация, когда обе прочитают одинаковое исходное значение, а потом только последняя запись сохранится

**Уровни изолированности**:

* **Serializable**
    - самый высокий, параллельно транзанкции не выполняются
    - защищает от всех проблем
* **Repeatable read**
    - ставятся блокировки на чтение-запись на читаемые строки до завершения транзакции
    - защищает от всего, кроме фантомного чтения (блокировки на новые строки не действуют)
* **Read commited** (чтение фиксированных данных)
    - ставится блокировка на чтение до конца выполнения SELECT
    - ставится блокировка на запись до конца транзакции
    - защищает только от грязного чтения и потерянного обновления
    - режим работы по умолчанию для больщинства СУБД
* **Read uncommited** 
    - ставится блокировка только на запись
    - защищает только от потерянного обновления

В Spring уровень изолированности задается через свойство аннотации 

    @Transactional(isolation = Isolation.Serializable)

TODO: разобрать пример в части блокирования потока

### 3.13 Аннотация @EnableTransactionManagment

см. пример [m3-q08-transaction]

**@EnableTransactionManagment** - аннотация, применяемая к конфигурационному классу (классу с аннотацией **@Configuration**). При наличии бина **@PlatformTransactionManager**, обеспечивает работу аннотации **@Transactional**

Для этого классы **TransactionInterceptor** и **TransactionAspectSupport** проксируют вызовы методов с аннотацией **@Transactional** и используют **PlatformTransactionManager** для управления транзакциями

Параметры аннотации **@EnableTransactionManagment**:

* `mode` - как перехватываются вызовы методов:
    - `PROXY` - по умолчанию через проксирование
    - `ASPECTJ` - через АОП
* `order` - если в режиме АОП и несколько советов присутствует
* `proxyTargetClass` - каким способом проксировать в режиме прокси: CGLIB или JDK Proxy (по умолчанию)

### 3.14 Что такое распространение транзакций (propagation)

[dzone](https://dzone.com/articles/spring-boot-transactions-tutorial-understanding-tr)

Определяет как существующая транзакция переиспользуется, когда вызывается **@Transactional** метод внутри другого метода с уже запущенной транзакцией.

За это отвечает параметр аннотации **@Transactional** `propagation`:

* **REQUIRED** - используется существующая транзакция, или создается новая, если нет транзакции. Это поведение по умолчанию.
* **SUPPORTS** - если метод вызывается внутри транзакции, он ее использует. Если вызывается самостоятельно, из метода вне транзакции, транзакция не создается и метод выполняется как без аннотации `@Transactional`
* **MANDATORY** - обязан вызываеться внутри метода с транзакцией. Если вызывается самостоятельно или внутри не транзакционного метода - выбрасывается исключение
* **REQUIRES_NEW** - всегда создает новую транзакции: когда вызывается без транзакции и когда вызывается внутри существующей транзакции
*  **NOT_SUPPORTED** - не создает транзакции и не использует существующие
*  **NEWER** - не создает транзакции, но если запускается внутри существующей - вызывает исключение
*  **NESTED** - так же как и **REQUIRED**, но создаются точки сохранения, что позволяет откатывать внутреннюю транзакции независимо от внешней.

|      Тип      | Вне транзакции |      Внутри транзакции    |  
| ------------- | -------------- | --------------------------|  
| REQUIRED      |новая           |переиспользуется           |  
| SUPPORTS      |без транзакции  |переиспользуется           |  
| MANDATORY     |исключение      |переиспользуется           |  
| REQUIRES_NEW  |новая           |новая                      |  
| NOT_SUPPORTED |без транзакции  |без транзакции             |  
| NEWER         |без транзакции  |исключение                 |  
| NESTED        |новая           |переиспользуется с точками |  



### 3.15 Что произойдет, если один @Transactional метод вызывает другой @Transactional метод того же самого класса

Это **self-invocation**. Проксирование через CGLIB и JDK Dynamic Proxy не поддерживают такой механизм, поэтому **TransactionInterceptor** и **TransactionAspectSupport** не смогут перехватить вызов и транзакция не будет обработана.

Например при вызове метода Б не будет создана транзакция для метода А:

    public class A {
        @Transactional
        void methodA() {
            ...
        }
        void methodB() {
            methodA();
        }
    }

Чтобы разрешить поддержку self-invocation нужно отказаться от проксирования и перейти на АОП:

* добавить зависимость `spring-aspects`
* включить плагин `aspectj-maven-plugin`
* переключить режим в АОП: `@EnableTransactionManagment(mode = AdviceMode.ASPECTJ)`




### 3.16 Где может располагаться @Transactional.

**@Transactional** может располагаться над классом или над методом класса или интерфейса.

Если ставится над классом - все публичные методы будут в транзакции выполняться

Если поставить не над публичным методом - транзакция не будет создана



### 3.17 Что такое декларативное управление транзакциями

Вместо того, чтобы управлять транзакциями вручную программно, описываем транзакцию через аннотацию **@Transactional**

Программно это выглядит так:

    Connection conn = dataSource.getConnection();
    conn.setAutocommit(false);
    conn.setTransactionIsolation(...);
    try {
        // бизнес-логика
        conn.commit();
    } catch (..) {
        conn.rollback()
    } finally {
        conn.close();
    }

### 3.18 Режимы отката транзакции (rollback policy)

По умолчанию откатываются транзакции, внутри которых произошли непроверяемые исключения (а это например исключения Spring Data).

Проверяемые исключения не являются по умолчанию причиной для отката транзакции

Можно настроить через параметры аннотации **@Transactional**:

* `rollbackFor` / `noRollbackFor` - через указание класса
* `rollbackForClassName` / `noRollbackForClassName` - через строковое имя класса

### 3.19 Как работают тесты (@Test) cовместно с @Transactional

При тестировании, если тестовый метод помещен в транзанкцию, транзакция будет отменена. Это сделано для обеспечения воспроизводимости тестов.

Это поведение можно изменить, добавив аннотацию **@Rollback(false)**

    @RunWith(...)
    public class SomeServiceTest {
        @Test
        @Transactional
        public void someTest() { ... }
        
        @Test
        @Transactional
        @Rollback(false)
        public void anotherTest() { ... }
    }

### 3.20 Термин Unit of Work. Свойство AutoCommit у JDBC.

В общем смысле - это набор задач, изменяющих данные, которые должны бвть выполнены все или не выполнено ни одно изменение.

Для СУБД - это транзакция

На уровне ORM (JPA/Hibernate) это все изменения, которые необходимо сделать в БД при изменении Data Object. Обычно ORM стремится минимизировать количество обращений к БД.

JDBC по умолчанию выполняется с `autoCommit = true`, т. е. каждое обращение к БД выполняется в собственной транзанкции. **@Transactional** отключает это поведение, так что транзакции можно откатывать.

### 3.21 Работа c JPA

Чтобы работать с JPA необходимо:

* добавить зависимости:
    - собственно JPA `javax.persistence-api`
    - поддержка ORM в Spring `spring-orm`
    - сама ORM, например Hibernate `hibernate-core`
    - драйвер БД, например `hsqldb`
    - опционально для упрощения работы Spring Data JPA `spring-data-jpa`
    - **ПРОВЕРЯТЬ СООТВЕТСТВИЕ ВЕРСИЙ (spring-orm, spring-jdbc и др.)**
* определить бин **DataSource**
* определить бин **PlatformTransactionManager**, для JPA это **JpaTransactionManager**
    - имя бина важно, связь с репозиторием по нему, не по типу
* определить бин для управления сущностями **EntityManagerFactoryBean**
    - **LocalContainerEntityManagerFactoryBean** для автономного приложения
    - **EntityManagerFactory** - для работы через JNDI
    - **LocalEntityManagerFactoryBean** - упрощенная версия для тестов
    - обращать внимание на имя бина (имя метода), связывать репозитории будет по имени, не по типу
* определить сущность: класс с **@Entity** и минимум с полем **@Id**
* определить DAO классы или использовать репозитории из Spring Data JPA
    - для репозитория из Spring Data JPA унаследовать интерфейс репозитория (**CrudRepository** например)
    - добавить аннотацию **@EnableJpaRepositories** над конфигурацией с указанием пакета для сканирования
    - **!!!!** есть свойство `entityManagerFactoryRef`, которое определяет какое имя у бина **EntityManagerFactory**, по умолчанию `entityManagerFactory`. Поэтому метод создания бина должен иметь определенное имя
    - аналогично для бина **PlatformTransactionManager**

### 3.22 Может ли DAO на основе JPA участвовать в существующей транзакции

Да. JPA работает через **JpaTransactionManager**, который как и для JdbcTemplate способен подключаться к транзакциям. 

Можно создавать DAO на основе JdbcTemplate и JPA и вызывать их в одном транзакционном методе. Менеджер транзакций может быть (должен?) один: **JpaTransactionManager**

    @Transactional
    public void doWork() {
        jpaDao.save(...);
        jdbcDao.save(...);
    }

### 3.23 Какие PlatformTransactionManager можно использовать с JPA

Можно применять следующие:

* **JpaTransactionManager** - для работы с единственной БД
* **JtaTransactionManager** - для работы с несколькими БД/entity managers

### 3.24 Как настроить конфигурацию для работы с JPA. Как Spring Boot упрощает это.

По настройке см. 3.21. 

Отличия для Spring Boot:

* одна зависимость `spring-boot-starter-jpa`
* JPA конфигурируется автоматически
* **PlatformTransactionManager**, **EntityManager** также автоматически настраиваются
* **DataSource** настраивается через свойства (в случае встроенной - достаточно зависимости)
* нет нужды в скриптах - по сущностямм создаются таблицы (для встроенных)
* автоматически поддерживается Hikari Connection Pool
* настраиваются свойства по умолчанию JPA
* автоматически создаются DAO бины на основании репозиториев (не нужна **@EnableJpaRepositories**)




### 3.25 Интерфейс Repository

Интерфейс, который описывает DAO и для которого Spring автоматически сгенерирует логику.

Разные интерфейсы есть:

* **Repository** - базовый интерфейс-маркер
* **CrudRepository**
* **PagingAndSortingRepository**
* **JpaRepository**

Можно добавлять методы через имя поля и разные предопределенные findBy- и т. п.

Для того чтобы Spring создавал DAO на основе репозитория - добавить к конфигурационному классу **@EnableJpaRepositories** с указанием пакета или класса для сканирования.

    public interface EmployeeDao extends CrudRepository<Employee, Long> {}


### 3.26 Как определить Repository. Почему это интерфейс, а не класс

* унаследовать один из интерфейсов:
    - **Repository**
    - **CrudRepository**
    - **PagingAndSortingRepository**
    - **JpaRepository**
* создать класс сущности с помощью аннотации **@Entity**
* определить ключ внутри сущности:
    - аннотацией **@Id** для простого ключа
    - аннотациями **"EmbeddedId** и **@Embeddable** для ссылочного
* использовать аннотацию **@EnableJpaRepositories** для указания пакетов для поиска репозитория

Пример:

    public interface EmployeeDao extends CrudRepository<Employee, Long> {}

    @Configuration
    @EnableJpaRepositories(basePackage = {"com.example"})
    public class JpaConfig {...}

    @Entity
    public class Employee {
        @Id Long id;
        ...
    }

Используются именно интерфейсы, а не классы, потому что для создания реализации и  перехватов вызовов используется JDK Dynamic Proxy.




### 3.27 Конвенции наименования для методов поиска для Репозиториев

    find[limit]By[properties][comparison][ordering]

**limit**:

* через ключевые слова `top`/`first`
* можно указать количество `findTop10ById`
* без указания - 1 запись `findFirstByName`

**properties**:

* фильтр по полям сущности `findByName`
* можно несколько полей через ключевые слова `or`, `and`
    - `findByFirstnameAndLastname`

**comparison**:

* различные условия для фильтрации
    - `Is`, `Equals`, `LessThan` и т. п.
    - `DateBefore`, `DateAfter`
    - `True`, `False`
    - и др.

**ordering**:

* имя поля + направление `findByIdNameAsc` 

### 3.28 Как Репозиторий реализуется Спрингом в рантайме

Spring находит аннотацию **@EnableJpaRepositories** и начинает сканировать пакеты. **JpaRepositoriesRegistrar** и **JpaRepositoryConfigExtencion** будут использоваться для создания бина для репозитория. Далее **JpaRepositoryFactoryBean** использует **JpaRepositoryFactory** и создает экземпляр **SimpleJpaRepository** для каждого репозитория.

Можно переопределить и создавать свои реализации репозиториев:

* глобально для всех:
    - указываем собственный класс в свойстве `repositoryBaseClass` аннотации **@EnableJpaRepositories**
    - этот класс должен наследовать **SimpleJpaRepository**
    - в нем переопределяем методы из репозитория
* для конкретного репозитория:
    - когда объявляем репозиторий, наследуем от собственного интерфейса
    - для этого собственного интерфейса создаем реализацию

### 3.29 Аннотация @Query

Используется над методом (например в методе репозитория) и позволяет указать запрос, который будет выполняться

    public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}

