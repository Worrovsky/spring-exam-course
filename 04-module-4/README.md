## 4. Модуль #4. Spring Boot

<!-- MarkdownTOC autolink="true" levels="3" -->

- [4.1 Что такое Spring Boot](#41-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-spring-boot)
- [4.2 Преимущества использования Spring Boot](#42-%D0%9F%D1%80%D0%B5%D0%B8%D0%BC%D1%83%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%B0-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-spring-boot)
- [4.3 Почему Spring Boot берет на себя столько обязанностей \("opinionated"\)](#43-%D0%9F%D0%BE%D1%87%D0%B5%D0%BC%D1%83-spring-boot-%D0%B1%D0%B5%D1%80%D0%B5%D1%82-%D0%BD%D0%B0-%D1%81%D0%B5%D0%B1%D1%8F-%D1%81%D1%82%D0%BE%D0%BB%D1%8C%D0%BA%D0%BE-%D0%BE%D0%B1%D1%8F%D0%B7%D0%B0%D0%BD%D0%BD%D0%BE%D1%81%D1%82%D0%B5%D0%B9-opinionated)
- [4.4 Как Spring Boot определяет какую конфигурацию использовать. Создание собственной конфигурации.](#44-%D0%9A%D0%B0%D0%BA-spring-boot-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D1%8F%D0%B5%D1%82-%D0%BA%D0%B0%D0%BA%D1%83%D1%8E-%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D1%8E-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D0%BE%D0%B1%D1%81%D1%82%D0%B2%D0%B5%D0%BD%D0%BD%D0%BE%D0%B9-%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D0%B8)
- [4.5 Для чего нужен Spring Boot Starter POM](#45-%D0%94%D0%BB%D1%8F-%D1%87%D0%B5%D0%B3%D0%BE-%D0%BD%D1%83%D0%B6%D0%B5%D0%BD-spring-boot-starter-pom)
- [4.6 Свойства в YAML и .properties файлах](#46-%D0%A1%D0%B2%D0%BE%D0%B9%D1%81%D1%82%D0%B2%D0%B0-%D0%B2-yaml-%D0%B8-properties-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0%D1%85)
- [4.7 Управление логгированием в Spring Boot](#47-%D0%A3%D0%BF%D1%80%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BB%D0%BE%D0%B3%D0%B3%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-%D0%B2-spring-boot)
- [4.8 Где Spring Boot ищет файлы со свойствами](#48-%D0%93%D0%B4%D0%B5-spring-boot-%D0%B8%D1%89%D0%B5%D1%82-%D1%84%D0%B0%D0%B9%D0%BB%D1%8B-%D1%81%D0%BE-%D1%81%D0%B2%D0%BE%D0%B9%D1%81%D1%82%D0%B2%D0%B0%D0%BC%D0%B8)
- [4.9 Как определять свойства специфичные для профиля](#49-%D0%9A%D0%B0%D0%BA-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D1%8F%D1%82%D1%8C-%D1%81%D0%B2%D0%BE%D0%B9%D1%81%D1%82%D0%B2%D0%B0-%D1%81%D0%BF%D0%B5%D1%86%D0%B8%D1%84%D0%B8%D1%87%D0%BD%D1%8B%D0%B5-%D0%B4%D0%BB%D1%8F-%D0%BF%D1%80%D0%BE%D1%84%D0%B8%D0%BB%D1%8F)
- [4.10 Как можно получить доступ к свойствам, определенным в файлах](#410-%D0%9A%D0%B0%D0%BA-%D0%BC%D0%BE%D0%B6%D0%BD%D0%BE-%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF-%D0%BA-%D1%81%D0%B2%D0%BE%D0%B9%D1%81%D1%82%D0%B2%D0%B0%D0%BC-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B5%D0%BD%D0%BD%D1%8B%D0%BC-%D0%B2-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0%D1%85)
- [4.11 Как настроить подключение к внешней базе MySQL](#411-%D0%9A%D0%B0%D0%BA-%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%BE%D0%B8%D1%82%D1%8C-%D0%BF%D0%BE%D0%B4%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BA-%D0%B2%D0%BD%D0%B5%D1%88%D0%BD%D0%B5%D0%B9-%D0%B1%D0%B0%D0%B7%D0%B5-mysql)
- [4.12 Как настроить схему БД и начальные данные](#412-%D0%9A%D0%B0%D0%BA-%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%BE%D0%B8%D1%82%D1%8C-%D1%81%D1%85%D0%B5%D0%BC%D1%83-%D0%91%D0%94-%D0%B8-%D0%BD%D0%B0%D1%87%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D0%B5)
- [4.13 Что такое "толстый" \(fat\) jar](#413-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-%D1%82%D0%BE%D0%BB%D1%81%D1%82%D1%8B%D0%B9-fat-jar)
- [4.14 Различия между встроенным контейнером и WAR](#414-%D0%A0%D0%B0%D0%B7%D0%BB%D0%B8%D1%87%D0%B8%D1%8F-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-%D0%B2%D1%81%D1%82%D1%80%D0%BE%D0%B5%D0%BD%D0%BD%D1%8B%D0%BC-%D0%BA%D0%BE%D0%BD%D1%82%D0%B5%D0%B9%D0%BD%D0%B5%D1%80%D0%BE%D0%BC-%D0%B8-war)
- [4.15 Какие встроенные контейнеры поддерживает Spring Boot](#415-%D0%9A%D0%B0%D0%BA%D0%B8%D0%B5-%D0%B2%D1%81%D1%82%D1%80%D0%BE%D0%B5%D0%BD%D0%BD%D1%8B%D0%B5-%D0%BA%D0%BE%D0%BD%D1%82%D0%B5%D0%B9%D0%BD%D0%B5%D1%80%D1%8B-%D0%BF%D0%BE%D0%B4%D0%B4%D0%B5%D1%80%D0%B6%D0%B8%D0%B2%D0%B0%D0%B5%D1%82-spring-boot)
- [4.16 Как Spring Boot определяет конфигурацию](#416-%D0%9A%D0%B0%D0%BA-spring-boot-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D1%8F%D0%B5%D1%82-%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D1%8E)
- [4.17 Для чего нужна @EnableAutoConfiguration](#417-%D0%94%D0%BB%D1%8F-%D1%87%D0%B5%D0%B3%D0%BE-%D0%BD%D1%83%D0%B6%D0%BD%D0%B0-enableautoconfiguration)
- [4.18 Для чего нужна @SpringBootApplication](#418-%D0%94%D0%BB%D1%8F-%D1%87%D0%B5%D0%B3%D0%BE-%D0%BD%D1%83%D0%B6%D0%BD%D0%B0-springbootapplication)
- [4.19 Как Spring Boot выполняет сканирование](#419-%D0%9A%D0%B0%D0%BA-spring-boot-%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D1%8F%D0%B5%D1%82-%D1%81%D0%BA%D0%B0%D0%BD%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5)
- [4.20 Как происходит автоконфигурация DataSource и JdbcTemplate](#420-%D0%9A%D0%B0%D0%BA-%D0%BF%D1%80%D0%BE%D0%B8%D1%81%D1%85%D0%BE%D0%B4%D0%B8%D1%82-%D0%B0%D0%B2%D1%82%D0%BE%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D1%8F-datasource-%D0%B8-jdbctemplate)
- [4.21 Для чего нужен файл spring.factories](#421-%D0%94%D0%BB%D1%8F-%D1%87%D0%B5%D0%B3%D0%BE-%D0%BD%D1%83%D0%B6%D0%B5%D0%BD-%D1%84%D0%B0%D0%B9%D0%BB-springfactories)
- [4.22 Как настраивать под свои нужды автоконфигурации](#422-%D0%9A%D0%B0%D0%BA-%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%B0%D0%B8%D0%B2%D0%B0%D1%82%D1%8C-%D0%BF%D0%BE%D0%B4-%D1%81%D0%B2%D0%BE%D0%B8-%D0%BD%D1%83%D0%B6%D0%B4%D1%8B-%D0%B0%D0%B2%D1%82%D0%BE%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D0%B8)
- [4.23 Примеры аннотаций @Condition..](#423-%D0%9F%D1%80%D0%B8%D0%BC%D0%B5%D1%80%D1%8B-%D0%B0%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D0%B9-condition)
- [4.24 Spring Boot Actuator](#424-spring-boot-actuator)
- [4.25 Протоколы доступа к API Actuator'a](#425-%D0%9F%D1%80%D0%BE%D1%82%D0%BE%D0%BA%D0%BE%D0%BB%D1%8B-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%B0-%D0%BA-api-actuatora)
- [4.26 Actuator Endpoints](#426-actuator-endpoints)
- [4.27 Info endpoint](#427-info-endpoint)
- [4.28 Logger endpoint](#428-logger-endpoint)
- [4.29 Доступ к endpoint'ам с помощью tag](#429-%D0%94%D0%BE%D1%81%D1%82%D1%83%D0%BF-%D0%BA-endpoint%D0%B0%D0%BC-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-tag)
- [4.30 Для чего нужны метрики](#430-%D0%94%D0%BB%D1%8F-%D1%87%D0%B5%D0%B3%D0%BE-%D0%BD%D1%83%D0%B6%D0%BD%D1%8B-%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D0%BA%D0%B8)
- [4.31 Создание собственных метрик](#431-%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D0%BE%D0%B1%D1%81%D1%82%D0%B2%D0%B5%D0%BD%D0%BD%D1%8B%D1%85-%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D0%BA)
- [4.32 Health endpoint](#432-health-endpoint)
- [4.33 Какие Health индикаторы доступны](#433-%D0%9A%D0%B0%D0%BA%D0%B8%D0%B5-health-%D0%B8%D0%BD%D0%B4%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D1%8B-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%BD%D1%8B)
- [4.34 Что такое статус Health индикатора](#434-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-%D1%81%D1%82%D0%B0%D1%82%D1%83%D1%81-health-%D0%B8%D0%BD%D0%B4%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D0%B0)
- [4.35 Значения статусов индикаторов](#435-%D0%97%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%B8%D1%8F-%D1%81%D1%82%D0%B0%D1%82%D1%83%D1%81%D0%BE%D0%B2-%D0%B8%D0%BD%D0%B4%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D0%BE%D0%B2)
- [4.36 Изменение порядка статусов Health индикаторов](#436-%D0%98%D0%B7%D0%BC%D0%B5%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BF%D0%BE%D1%80%D1%8F%D0%B4%D0%BA%D0%B0-%D1%81%D1%82%D0%B0%D1%82%D1%83%D1%81%D0%BE%D0%B2-health-%D0%B8%D0%BD%D0%B4%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D0%BE%D0%B2)
- [4.37 Использование сторонних мониторинговых систем](#437-%D0%98%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81%D1%82%D0%BE%D1%80%D0%BE%D0%BD%D0%BD%D0%B8%D1%85-%D0%BC%D0%BE%D0%BD%D0%B8%D1%82%D0%BE%D1%80%D0%B8%D0%BD%D0%B3%D0%BE%D0%B2%D1%8B%D1%85-%D1%81%D0%B8%D1%81%D1%82%D0%B5%D0%BC)
- [4.38 Использование аннотации @SpringBootTest](#438-%D0%98%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B0%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D0%B8-springboottest)
- [4.39 Автоконфигурация с @SpringBootTest](#439-%D0%90%D0%B2%D1%82%D0%BE%D0%BA%D0%BE%D0%BD%D1%84%D0%B8%D0%B3%D1%83%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D1%81-springboottest)
- [4.40 Зависимости, добавляемые spring-boot-starter-test](#440-%D0%97%D0%B0%D0%B2%D0%B8%D1%81%D0%B8%D0%BC%D0%BE%D1%81%D1%82%D0%B8-%D0%B4%D0%BE%D0%B1%D0%B0%D0%B2%D0%BB%D1%8F%D0%B5%D0%BC%D1%8B%D0%B5-spring-boot-starter-test)
- [4.41 Интеграционное тестирование с @SpringBootTest для веб-приложения](#441-%D0%98%D0%BD%D1%82%D0%B5%D0%B3%D1%80%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%BD%D0%BE%D0%B5-%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%81-springboottest-%D0%B4%D0%BB%D1%8F-%D0%B2%D0%B5%D0%B1-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F)
- [4.42 Аннотация @WebMvcTest](#442-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-webmvctest)
- [4.43 Разница между @Mock и @MockBean](#443-%D0%A0%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-mock-%D0%B8-mockbean)
- [4.44 Аннотация @DataJpaTest](#444-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-datajpatest)

<!-- /MarkdownTOC -->

### 4.1 Что такое Spring Boot

Это фреймворк для создания приложений. Часто используется для микросервисной архитектуры.

Приложение Spring Boot может запускаться через `java -jar` или через `war`. Поддерживает встроенные контейнеры: Jetty, Tomcat, Undertow

Позволяет работать в парадигме 12 факторов (например dev/prod работают в одном окружении)

Добавляет различные фичи (логгирование, внешнее конфигурирование, метрики и т. п.)

### 4.2 Преимущества использования Spring Boot

* увеличение продуктивности
* упрощение развертывания через создание jar файлов
* предоставление стандартной конфигурации и возможности легко изменять конфигурацию
* предоставление набора зависимостей для разный функций (веб, работа с БД и пр)
* предоставление функциональности, не связанной с бизнес-логикой (логгирование, метрики и пр.)
* интеграция с микросервисными инструментами (Eureka, Ribbon)
* интеграция с линуксовыми systemd, init.d
* использование IoC/DI Spring

### 4.3 Почему Spring Boot берет на себя столько обязанностей ("opinionated")

Имеет представление, как приложение должно быть организованно, устанавливает настройки по умолчанию.

Преимущества этого:

* упрощение настройки приложения
* повышение продуктивности через фокусирование на бизнес-задачах, вместо кода, связанного с окружением
* конфигурацию нужно писать, только если она отличается от конфигурации по умолчанию

Основной недостаток такого подхода: если требуется что-то отличное от стандартного подхода - придется потратить силы на настройку

Исключение автоконфигурации происходит через свойство `exclude` аннотации **@EnableAutoConfiguration** (нужно знать класс, который отвечает за конфигурацию):

    @Configuration
    @EnableAutoConfiguration(exclude = {DataSourseAutoConfiguration.class})
    public class ...

### 4.4 Как Spring Boot определяет какую конфигурацию использовать. Создание собственной конфигурации.

Spring Boot для автоконфигурирования использует зависимости.

Spring Boot анализирует classpath и ищет файл **META-INF/spring.factories**. В этом файле зависимости (разные starter'ы) перечисляют конфигурационные классы (помеченные **@EnableAutoConfiguration**). Далее Spring Boot обрабатывает эти классы. Они дополнительно могут иметь аннотации **@ConditionOn...**, которая определяет в каких условиях применяется эта конфигурация.

Примеры условных аннотаций:

* @ConditionalOnBean - при наличии бина
* @ConditionalOnClass
* @ConditionOnProperty
* и т. п.

Вот пример файла `spring.factories` в ресурсах

    # Auto Configure
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.example.autoconfiguration.DataSourceAutoConfiguration,\
    com.example.autoconfiguration.JpaAutoConfiguration

Здесь же находятся эти конфигурационные классы, например

    @Configuration
    @EnableTransactionManagement
    @ConditionalOnClass(name = "org.hsqldb.Database")
    public class DataSourceAutoConfiguration { 
        @Bean
        DataSource ... 
    }

Теперь достаточно включить этот проект как зависимость в Spring Boot проект и при наличии в classpath `hsqldb` будут созданы бины, определяемые этой конфигурацией.


### 4.5 Для чего нужен Spring Boot Starter POM

Это мавеновский модуль, пустой jar с набором зависимостей, которые нужны для работы с определенной технологией. Spring Boot при наличии зависимостей выполняет автокофигурирование и создает необходимые для работы с технологией бины. 

Плюсы стартеров:

* зависимости поступают в проверенных версиях
* автоконфигурирование

### 4.6 Свойства в YAML и .properties файлах

Spring Boot поддерживает кофнигурации через 

* YAML файлы
* Java Properties файлы

Работа с YAML выполняется через библиотеку ShakeYAML, которая входит в любой `spring-boot-starter`

### 4.7 Управление логгированием в Spring Boot

#### 4.7.1 Основы

[docs](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging)

Любой стартер содержит зависимости на логгирующие библиотеки (Logback) по умолчанию.

Spring Boot позволяет настраивать:

* уровни логгирования в общем или для каждого класса отдельно
* шаблоны логгирования
* цвета
* место назначение логов: консоль, файл
* ротацию файлов
* группировку сообщений для нескольких классов
* фрейморк логгирования:
    - Logback (по умолчанию)
    - Log4j2
    - JDK (Java Util Logging)
* задавать конфигурации через xml
    - `logback-spring.xml` для Logback
    - `log4j2-spring.xml` для Log4j2
    - `logging.properties` для JDK


#### 4.7.2 Созданние логгера

Создаем как поле класса. Здесь **Logger** и **LoggerFactory** - из пакета sl4j (logback - это обертка над sl4j). Можно использовать **Logger** из Java Util Logging (но методы логгирования другие).
    
    public class MyClazz {
        private static final Logger logger = LoggerFactory.getLogger(App.class.getName);
    }

#### 4.7.3 Задание уровня логгирования

* через файл свойств
    - корневой `logging.level.root=WARN`
    - для пакета `logging.level.<имя логгера>=<level>`
        + `logging.level.com.example=ALL`
* через переменные окружения
    - `LOGGING_LEVEL_COM_EXAMPLE=ALL`
* через параметры запуска jar `--debug` или `--trace`
    - `java -jar myjar.jar --debug`
* через свойства `debug=true` или `trace=true` в файле свойств
* конфигурация в xml

Допустимые уровни:  `TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`, `FATAL`, `OFF` (для Logback `FATAL` эквивалент `ERROR`).

#### 4.7.4 Задание шаблона

Например для консоли:

    logging.pattern.console="%d{yyyy-MMM-dd HH:mm:ss.SSS} %-5level [%thread] %logger{15} - %msg%n"

Подробнее - см. документацию Logback


#### 4.7.5 Управление цветами

Если устройство вывода логов (консоль например) поддерживает ANSI можно настраивать цвет сообщений через `%clr` в шаблонах

Например:

    %clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){yellow}

Цвета предопределенные:

    blue, cyan, faint, green, magenta, red, yellow

#### 4.7.6 Вывод в файл

Настраивается через свойства `logging.file.name` (пишутся в конкретный файл) или `logging.file.path` (пишутся в файл `spring.log` в указанной директории)

#### 4.7.7 Другое

Можно настроить ротацию файлов: максимальный размер, максимальное количество и т. п.

**Группировка настроек**

можно объединить разные пакеты в одну группу и задавать настройки для этой группы:

    logging.group.tomcat=org.apache.catalina,org.apache.coyote,org.apache.tomcat

    logging.level.tomcat=trace

Есть предопределеные группы **web**, **sql**

Можно подключать другие библиотеки: исключаем из зависимости Logback, добавляем другую



### 4.8 Где Spring Boot ищет файлы со свойствами

Порядок поиска (от первых к последующим):

* по профилям файлы вида `application-{profile}.properties` и `application-{profile}.yml`
    - вне jar:
        + в директории `/config`
        + в текущей директории 
    - внутри jar:
        + внутри директории `/config` внутри classpath (в структуре проекта `resources/config`)
        + в корневой директории classpath (`resources`)
* общие файлы (без профиля) `application.properties` и `application.yml`
    - вне jar:
        + в директории `/config`
        + в текущей директории 
    - внутри jar:
        + внутри директории `/config` внутри classpath (в структуре проекта `resources/config`)
        + в корневой директории classpath (`resources`)

Это позволяет менять настройки для готового приложения в виде jar простым добавлением файлов с настройками.

Можно указать конкретный файл с настройками:

    java -jar myapp.jar --spring.config.name=..

Или расположение для поиска файлов:

    java -jar myapp.jar --spring.config.location=classpath:/default.properties


### 4.9 Как определять свойства специфичные для профиля

* Через отдельные для каждого профиля файлы свойств
    - `application-{profile}.properties`
    - `application-{profile}.yml`
    - `application-default.properties/yml` для свойств по умолчанию
* Мульти-профильный YAML файл

Пример такого файла (внимание на `---` - это разделение документа на части):

    server:
        url: "http://.."
    ---
    spring:
        profiles: "dev"
    server:
        url: "..."
    ---
    spring:
        profiles: "prod"
    server:
        url: "...   "

Подробнее [docs](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-files-multi-document)

### 4.10 Как можно получить доступ к свойствам, определенным в файлах

Можно получить доступ следующими способами:

* внедрять свойства в поля через **@Value("${PROPERTY_NAME}")**
* через создание конфигурационного классы **@ConfigurationProperties(prefix = "...")** и **@EnableConfigurationProperties**
* через интерфейс **Environment**

Пример с конфигурационным классом:

    @SpringBootApplication
    @EnableConfigurationProperties(AppConfig.class)
    public class App {...}

    @Configuration(prefix = "app")
    public class AppConfig {
        private String someProp;
    }

Пример с **Environment**:

    ...
    @Autowired
    private Environment environment;

    ...
        environment.getPropery("someProp");


Подробнее [github](https://github.com/Worrovsky/spring-vue-learn-stuff/tree/main/003-spring-boot-properties)


### 4.11 Как настроить подключение к внешней базе MySQL

1. Настроить DataSource через свойства **spring.datasource...** url, username, password
2. (опцинально) указать JDBC драйвер `spring.datasource.driver-class-name=com.mysql.cj.jdbc.driver`
3. (опционально) для выполнения скриптов при запуске приложения `spring.datasource.initialization-mode=always` (теперь можно добавлять в ресурсы `data.sql` и `schema.sql`)
4. добавить зависимость на драйвер/коннектор, например `mysql-connector-java`
5. (опционально) добавить механизм для работы с БД, например JDBC template `spring-boot-starter-jdbc`


### 4.12 Как настроить схему БД и начальные данные

[docs](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-initialize-a-database-using-spring-jdbc)

Spring Boot позволяет задавать:

* схему (DDL) `schema.sql`
* скрипт для начального заполнения `data.sql`

Можно указывать платформо-зависимые настройки `data-{platform}.sql` и `schema-{platform}.sql`. Платформа определяется через свойство `spring.datasource.platform`. Это может быть конкретная СУБД -postgres, mysql.

Скрипты по умолчанию запускаются только для встроенных БД. Чтобы запускались для остальных нужно установить свойство `spring.database.initialization-mode=always`.

Можно изменить имена скриптов с `data.sql` и `schema.sql` по умолчанию через свойства `spring.datasource.schema` и `spring.datasource.data` 

### 4.13 Что такое "толстый" (fat) jar

Толстый jar содержит скомпилированный код приложения и все его зависимости. Spring включает зависимости как вложенные jar. Другой подход - включение зависимостей в один jar - может приводить к конфликтам, когда имена файлов из разных зависимостей будут совпадать. К тому же хуже видны зависимости.

Fat jar также является исполняемым, т. к. Spring включает манифест, главный класс и код, необходимый для запуска. Манифест содержит `Main-Class`(указание на специальный класс Soring Boot **JarLoader**) и `Start-Class` (главный класс приложения). Создание fat jar выполняется с помощью `spring-boot-maven-plugin`

Все это позволяет запускать jar через `java -jar ...`

Итого отличия от обычного jar:

* содержит все зависимости
* исполняемый по умолчанию

### 4.14 Различия между встроенным контейнером и WAR

**WAR** - Web Application Archive - представляет веб-модуль. Не предназначен для самостоятельного исполнения, размещается на сервере приложений (Tomcat например).

**Встроенный контейнер** включается как зависимость в исполняемый jar и запускает приложение

Структура исполняемого приложения Spring Boot:

* `BOOT-INF`
    - `classes` - собственно приложение
    - `lib` - зависимости
        + в т. ч. сервер (tomcat по умолчанию)
* `META-INF`
    - `MANIFEST.MF`
* `org.springframework.boot.loader`
    - `jarLauncher.class`

### 4.15 Какие встроенные контейнеры поддерживает Spring Boot

Spring Boot поддерживает:

* Tomcat
* Jetty
* Undertow

Tomcat используется по умолчанию когда применяется зависимость `spring-boot-starter-web`. Чтобы добавить другие нужно исключить зависимость `spring-boot-starter-tomcat` и добавить `spring-boot-starter-jetty` или `spring-boot-starter-undertow`

### 4.16 Как Spring Boot определяет конфигурацию

Дубль вопроса 4.4

### 4.17 Для чего нужна @EnableAutoConfiguration

Аннотация **@EnableAutoConfiguration** включает режим автоконфигурирования для спрингового контекста. В этом режим контейнер пытается определить какие бины создавать на основе аннотаций **@ConditonOn...**

Spring ищет в classpath файлы `META-INF/spring.factories`, определяет конфигурационные классы, указанные в свойстве `org.spring....EnableAutoConfiguration` и загружает их. Если условия в аннотациях **@ConditionOn...** подходят, создает бины, определенные в этих классах.

**@EnableAutoConfiguration** должна ставиться над классом с **@Configuration**. Для Spring Boot приложения не нужна, **@SpringBootApplication** уже включает ее. 


### 4.18 Для чего нужна @SpringBootApplication

**@SpringBootApplication** включает в себя следующие аннотации:

* **@Configuration** - внутри этого класса можно создавать бины
* **@EnableAutoConfiguration** - разрешается автоконфигурация
* **@ComponentScan** - сканируется пакеты текущего класса на поиск бинов. Поэтому рекомендуется главный класс приложения размещать в каком-нибудь пакете.




### 4.19 Как Spring Boot выполняет сканирование

Spring Boot выполняет сканирование потому что **@SpringBootApplication** содержит **@ComponentScan**.

По умолчанию сканирование выполняется в том пакете, где расположен класс, помеченный аннотацией **@SpringBootApplication**. Но можно уточнить через свойства `scanBasePackages` или `scanBasePackageClasses`

### 4.20 Как происходит автоконфигурация DataSource и JdbcTemplate

Конфигурируются через классы из `spring-boot-autoconfigure`: 

* `org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration` 
* `org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration`

Если посмотреть исходники, над этими классами будут аннотации по типу `@EnableConfigurationProperties(DataSourceProperties.class)`, которые и определяют префиксы и состав свойств, задаваемых через файлы или другими способами.

Зависимости подтягиваются при подключении соответствующих стартеров.


### 4.21 Для чего нужен файл spring.factories

см. 4.4 и 4.17

### 4.22 Как настраивать под свои нужды автоконфигурации

* создать jar модуль с `resources/META_INF/spring.factories`
* этот файл должен содержать строку свойства `org.springframework.boot.autoconfigure.EnableAutoConfiguration=...`, в которой перечислены классы автоконфигурации
* Класс автоконфигурации - это класс с аннотацией **@Configuration** и обычно с **@ConditionOn...**
* Внутри класса определяются бины через **@Bean**
* Дополнительно можно использовать свойства через **@EnableConfigurationProperties**, **@ConfigurationProperties** и **@PropertySource**

### 4.23 Примеры аннотаций @Condition..

* ConditionOnClass
* ConditionOnBean
* ConditionOnProperty
* и др.

### 4.24 Spring Boot Actuator

Предоставляет следующий функционал:

* мониторинг
* health-checks
* метрики
* audit events

Все что нужно - добавить зависимость `spring-boot-starter-actuator`. После этого доступны "ручки" `actuator/health`, `actuator/info`

`health` возвращает json:

    {
        "status": " "
    } 

`info` возвращает json:

    {
        app: {
            "name": "..",
            "description": "",
            "version": ""
        }
    }


### 4.25 Протоколы доступа к API Actuator'a

Spring Boot Actuator поддерживает два протокола

* HTTP
* JMX

JMX - специальный протокол для управления объектами и др.

Для доступа можно использовать любые средства, работающие с JMX, например `jconsole` (входит в состав jre, не jdk)

По умолчанию JMX разрешена локально. Для удаленного доступа нужно настраивать свойства `-Dcom.sun.management.jmxremote....`


### 4.26 Actuator Endpoints

[docs](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html)

Добавить зависимость `spring-boot-starter-actuator`

Теперь есть endpoint `/actuator`, показывающий список своих endpoint'ов. Большинство доступно и JMX, и в Web; включены по умолчанию в основном в JMX, в веб по умолчанию работают только `health` и `info`. Обращение: `/actuator/{имя enpoint'a}`

**Доступные endpoint'ы**:

* beans - список бинов приложения
* caches - кеши
* conditions - показывает условия, используемые при автоконфигурировании
* configprops - список **@ConfigurationProperties**
* env - свойства окружения
* flyway - допустимые миграции при использовании Flyway
* health - информация о состоянии (по умолчанию включена для Web)
* httptrace - отображает трассировку http запросов (но нужен бин **HttpTraceRepository**)
* info - информация о приложении (по умолчанию включена для Web)  
* loggers - просмотр и изменение логгеров
* liquibase - миграции liquibase
* metrics - метрики приложения
* mappings - отображение путей, заданных через **@RequestMapping**
* scheduledtasks - задачи в очереди
* sessions - просмотр сессий (при использовании Spring Session ?)
* shutdown - остановка приложения удаленно (по умолчанию отключена)
* threaddumps - дамп потока

**Включение/отключение endpoint'a**:

    management.endpoint.{ENDPOINT_NAME}.enable=true

**Отключение разрешенных по умолчанию**:

    management.endpoint.enabled-by-default=false

**Групповое влкючение endpoint'ов**

    management.endpoints.jmx.exposure.exclude=<endpoint'ы>    
    management.endpoints.jmx.exposure.include=<endpoint'ы>
    management.endpoints.web.exposure.exclude=<endpoint'ы>    
    management.endpoints.web.exposure.include=<endpoint'ы>

Например:
    
    management.endpoints.jmx.exposure.exclude=beans, env, health    

Можно все сразу:

    management.endpoints.jmx.exposure.include=*    


**Просмотр списка endpoint'ов с HATEOAS**

Добавить зависимость `spring-boot-starter-hateoas`

Теперь endpoint `/actuator` в расширенном виде отображается


[Сторонняя админка для этого](https://github.com/codecentric/spring-boot-admin)

### 4.27 Info endpoint

**Info** предоставляет произвольную, не чувствительную определенную пользователем информацию о приложении. Обычно доступна всем, поэтому секретного ничего нельзя передавать

Доступна: 

* через HTTP `/actuator/info`
* через JMX `org.springframework.boot/Endpoint/Info`

Можно свои свойства добавлять:

* через файл свойств свойства с префиксом `info`
    - `info.app.name=Super App`
    - `info.java-vendor=${java.specification.vendor}`
* через бин **InfoContributor**
    - создать бин, реализующий интерфейс
    - в методе интерфейса добавить свойства `builder.withDetail("props", "value");`



### 4.28 Logger endpoint

Позволяет просматривать логгеры и их уровни через:

* HTTP `/actuator/loggers`
* JMX `org.springframework.boot/Endpoint/Loggers/Operations/loggers`

В JMX разрешена по умолчанию, через HTTP нужно явно разрешать

    management.endpoints.web.exposure.include = loggers

Можно проверить отдельный логгер через `/actuator/loggers/{LOGGER_NAME}`, например `/actuator/loggers/com.example.app`. Возвращает такое:

    {
        "configuredLevel": null,
        "effectiveLevel": "INFO"
    }

Изменить уровень логгера можно через POST на `/actuator/loggers/{LOGGER_NAME}`. В теле передать желаемый уровень логгера:

    {
        "configuredLevel": "TRACE"
    }    

### 4.29 Доступ к endpoint'ам с помощью tag

Можно использовать теги добавляя к запросу таким образом: `tag=KEY:VALUE`:

    /actuator/metrics/http.server.requests?tag=status:200
    /actuator/metrics/jvm.memory.max?tag=area:heap

Можно несколько тегов в одном запросе через **&**: `tag=KEY1:VALUE1&tag=KEY2:VALUE2`:

    /actuator/metrics/http.server.requests?tag=status:200&tag=method:GET

Часто используется для endpoint'а метриках. Также `/actuator/metrics/{имя метрики}` показывает допустимые теги и их значения

### 4.30 Для чего нужны метрики

Endpoint `metrics` отображает различные метрики, собираемые при работе приложения

`/actuator/metrics` отображает доступные метрики

`/actuator/metrics/{ИМЯ_МЕТРИКИ}` показывает данные метрики, в том числе теги и их значения для более подробной информации:

    /actuator/metrics/process.cpu.usage
    /actuator/metrics/jvm.memory.used?tag=area:heap

Примеры метрик:

* использование процессора, использование ядер
* используемая и доступная память
* информация о потоках
* статистика GC
* информация по HTTP запросам
* метрики встроенного сервера (Tomcat и т. п.)
* и другие, в т. ч. можно собственные определять

Метрики по умолчанию отключены, нужно включать

    management.endpoints.web.exposure.include=metrics


### 4.31 Создание собственных метрик

Добавляются с помощью **MeterRegistry** из фреймворка Micrometer.

Есть разные примитивы: счетчики, таймеры и др.

Можно добавлять метрики с тегами.

Подробнее [docs](https://micrometer.io/)

### 4.32 Health endpoint

`/actuator/health` работает по умолчанию для JMX и Web, но показывает минимум информации. 

Обычно этот endpoint используется сторонним ПО для мониторинга, в балансировщиках нагрузки.

Для расширения перечня выводимых показателей можно настроить следующие свойства:

* `management.endpoint.health.show-details`
* `management.endpoint.health.show-components`

Эти свойства принимают следующие значения:

* `never`
* `when-authorized` - только если пользователь авторизован и его роль указана в `management.endpoint.health.roles`
* `always`

Можно создавать пользовательские индикаторы через создание бина/компонента, реализующего интерфейс **HealthIndicator**

    @Component
    public class CustomHealthIndicator implements HealthIndicator {
        @Override
        public Health health() {
            return Health.up()
                    .withDetail("my indicator", 42)
                    .build();
        }
    } 



### 4.33 Какие Health индикаторы доступны

**ApplicationHealthIndicator** - индикатор по умолчанию, всегда активен

**DiskSpaceHealthIndicator** - отображает состояние дисковой подсистемы. Нужно разрешать через `management.endpoint.health.show-details`

Есть разные индикаторы, связанные с базами данных, автоматически подключаются при наличии зависимостей.

Есть индикаторы  для сервисов ElasticSearch, Cassandra, Redis и др.

### 4.34 Что такое статус Health индикатора

Статус описывает состояние некоторого компонента системы, для которого задан индикатор.

Возможные значения статуса:

* UP
* DOWN
* OUT_OF_SERVICE
* UNKNOWN
* пользовательский

Задаются через статические методы при создании индикаторов

    Health.up()
    Health.down()
    Health.unknown()
    Health.status("custom status")

Также Actuator агрегирует состояние всех индикаторов и формирует статус для всего приложения в целом. Для этого используется реализация интерфейса **HealthIndicator**. По умолчанию работает **OrderedHealthIndicator**, который сортирует все статусы в порядке (DOWN, OUT_OF_SERVICE, UP, UNKNOWN) и берет первый. Т. е. если хотя бы один компонент будет в статусе DOWN, вся система также будет в этом статусе.




### 4.35 Значения статусов индикаторов



Возможные значения статуса:

* UP - компонент функционирует в ожидаемом режиме
* DOWN - компонент не работает из-за неожиданной ошибки
* OUT_OF_SERVICE - компонент отключен и не должен использоваться
* UNKNOWN - состояние неизвестно/неопределено

Каждый статус отображается на код HTTP ответа посредством **HealthStatusHttpMapper**.  По умолчанию:

* UP - HTTP 200
* UNKNOWN - HTTP 200
* DOWN - HTTP 503
* OUT_OF_SERVICE - HTTP 503

Можно переопределить через свойства,
например`management.health.status.http-mapping.DOWN=501`


### 4.36 Изменение порядка статусов Health индикаторов

Изменить порядок статусов можно с помощью свойства `management.health.status.order`. 

Например может использоваться для изменения приоритета пользовательских статусов:

    management.health.status.order=custom-status, DOWN, OUT_OF_SERVICE, UNKNOWN, UP

Этот порядок используется в **OrderedHealthIndicator**. Если в системе будет индикатор со статусом `custom-status`, этот статус будет установлен для всего приложения.


### 4.37 Использование сторонних мониторинговых систем

Сторонние системы дают функциональность без необхолимости ручного кодирования.

Обычно предоставляют следующие возможности:

* постоянное хранилище для метрик
* способ для выборки данных
* способ для визуализации данных
* настраиваемые дашборды
* настраиваемые оповещения

Spring Actuator использует Micrometer Application Metric Facade, который интегрируется с разными системами: Atlas, Datadog, Elastic и др. Обычно достаточно добавить зависимость по шаблону `micrometer-registry-${monitoring-system-name}` и задать некоторые свойства.

    <artifactId>micrometer-registry-elastic</artifactId>

    management.metrics.export.elastic.host=http...  

### 4.38 Использование аннотации @SpringBootTest

Пакет `org.springframework.boot.test.context`

Следует использовать при написании тестов для приложений на основе SpringBoot

Аннотация **@SpringBootTest** предоставляет разную функциональность для тестов:

* Автоматическое создание контекста через класс **SpringApplication**
* Web окружение для тестов
* Моки для бинов через **@MockBean**
* создание шпионов через **@SpyBean**
* автоконфигурирование для MVC тестов, JPA, JDBC и других

**@SpringBootTest** применяется над классом-тестом. Для JUnit4 нужно добавить **@RunWith(SpringRunner.class)**. Для JUnit5 добавлять **@ExtendWith(SpringExtension.class)** не надо: уже включает.

    @SpringBootTest
    public class SomeControllerTest {
        @Test
        void doTest() {...}
    }

### 4.39 Автоконфигурация с @SpringBootTest

При использовании **@SpringBootTest** создается: 

* **ApplicationContext** через поиск классов с аннотациями **@SpringBootApplication** или **@SpringBootConfiguration**
* сам тест

Можно ограничить конфигурацию, указав только некоторые классы:

* через свойство **@SpringBootTest#classes**
* через аннотацию **@ContextConfiguration** (из пакета `springframework.test`)
* через аннотации типа **@AutoConfigure...** из пакета `org.springframework.boot.test.autoconfigure`, например `AutoConfigureJdbc`

Для аннотаций типа **@AutoConfigure...** есть обертки, еще более упрощая использование: `@JsonTest`, `@WebMvcTest`, `@JdbcTest` и др. Эти обертки включают аннотацию **@ExtendWith** и другие. Например **@JdbcTest** включает транзакции, поднимает встроенную БД.






### 4.40 Зависимости, добавляемые spring-boot-starter-test

**spring-boot-starter-test** добавляет следующие зависимости:

* JUnit (4 и 5)
* Spring Test - спринговая поддержка тестов
* Spring Boot Test - поддержка тестов для Spring Boot
* AssertJ
* Hamcrest - библиотека для построение matcher'ов
* Mockito
* JSONAssert
* JsonPath - XPath для JSON
* XMLUnit - библиотека для проверки XML

### 4.41 Интеграционное тестирование с @SpringBootTest для веб-приложения

Интеграционные тесты проверяют взаимодействие между несколькими компонентами системы. При написании теста необходимо решить какие компоненты будут реальными, остальные можно пропустить/создать заглушки через **@MockBean** например. Количество реальных объектов должно быть минимальным (проще обслуживать тест), но не меньше 2-х (иначе это не интеграционный тест).

Если тестируются web-компоненты, следует выполнять HTTP запросы и проверять HTTP ответы.

Spring Boot позволяет писать тесты в двух вариантах.

Первый - использование **MockMvc** (более быстрый):

    @SpringBootTest
    @AutoConfigureMockMvc
    public class SomeTest {
        @Autowired
        private MockMvc mvc;
        @Test
        public void test() {
            mvc.perform(get("/user"))
        }
    }

Второй - через встроенный контейнер (разворачивается реальный веб-контейнер):

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class SomeTest {
        @LocalServerPort
        private int port;
        @Autowired
        private TestRestTemplate restTemplate;
        @Test
        public void test() {
            String url = String.format("http://localhost:%d/users", port);
            restTemplate.put(url, new User(...));
        }
    }

### 4.42 Аннотация @WebMvcTest

Аннотация **@WebMvcTest** используется для интеграционных тестов веб-уровня приложения. Аннотация создает `ApplicationContext`, в котором присутствуют только веб-компоненты и убраны все остальные. Если нужны какие-то дополнительные - можно создавать заглушки через **@MockBean** или с помощью аннотации **@Import** создавать реальные объекты.

**@WebMvcTest** может работать в двух режимах:

* создавать конфигурацию только для одного контроллера: `@WebMvcTest(MyController.class)`
* находить все контроллеры - просто `@WebMvcTest`

При использовании **@WebMvcTest** выполняется автоконфигурирование:

* Mock Mvc
* классов с **@Controller**
* классов **@ControllerAdvice**
* классов **@Converter**
* классов **@Filter**
* классов **@WebMvcConfigurer**

### 4.43 Разница между @Mock и @MockBean

**@Mock** - аннотация из библиотеки Mockito. Создает мок для класса.

**@MockBean** - аннотация из SpringBootTest, создает мок и внедряет его в **ApplicationContext**. Соответственно все поля с **@Autowired** получат этот бин.

Главное различие: **@MockBean** не только создает мок, но и внедряет его в контекст, тогда как **@Mock** только создает мок.

Совместно с **@Mock**  можно использовать **@InjectMocks**, но эта аннотация внедряет мок не в контекст, а только в класс.

### 4.44 Аннотация @DataJpaTest

Используется в интеграционных тестах для связанных с JPA компонентов: Entity и Repository.

Выполняет конфигурацию:

* создает встроенную БД (можно отменить `@AutoConfigureTestDatabase(replace=Replace.NONE)`)
* создает бины **@Entity** 
* создает бины репозиториев
* настраивает **TestEntityManager** - аналог **EntityManager**

По умолчанию использует транзакции с откатом в конце. Можно поменять через явное задание **@Transactional**

 
 