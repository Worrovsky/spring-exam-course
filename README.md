# Подготовка к экзамену по Spring (Udemy)

[Модуль #1. Основы / Spring Core](/01-module-1/README.md)

##  Модуль #3. 

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

TODO посмотреть свойства аннотации 
