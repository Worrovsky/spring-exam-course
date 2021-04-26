# Подготовка к экзамену по Spring (Udemy)

[Модуль #1. Основы / Spring Core](/01-module-1/README.md)

##  Модуль #2. 

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

