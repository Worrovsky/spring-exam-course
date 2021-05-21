## 6. Модуль #6. Spring Security

### 6.1 Authentication and authorization

**Authentication** - процесс, удостоверяющий что пользователь/устройство/внешняя система является тем, чем представляется. Ответ на вопрос "Кто это?".

С одной стороны пользователь отправляет свой идентификатор и учетные данные (credential), на другой стороне система проверяет их подтверждает или отклоняет идентификацию.

Пример процесса:

* пользователь обращается к защищаемому ресурсу
* сервер возвращает код 302 и перенаправляет на страницу логина
* пользователь ввод логин/пароль и отправляет их серверу
* если все правильно, сервер перенаправляет на требуемых ресурс
* иначе отображает ошибку

Более сложная система с 3-мя субъектами: пользователь, приложение и аутентификационный сервис (Central Authentication Service - CAS) - технология Single Sign-On (SSO):

* пользователь обращается к защищаемому ресурсу
* приложение перенаправляет на внешную страницу аутентификации
* CAS возвращает форму аутентификации
* пользователь заполняет форму и отпраляет CAS
* CAS возвращает ticket
* пользователь запращивает у приложения ресурс с полученным ticket'ом
* приложение обращается к CAS для проверки ticket'а
* если все правильно - отдает пользователю требуемый ресурс

Фреймворк предоставляет следующие возможности:

* аутентификация по логину/паролю
    - Form Login
    - Basic Authentication
    - Digest Authentication
* Remember-Me Authentication
* поддержка OpenID
* CAS Authentication
* X.509 Certificate Authentication
* OAuth 2.0 Login
* SAML2
* хранение данных:
    - in-Memory Authentication
    - JDBC authorization
    - пользовательские через UserDetailsService
* различные кодировки паролей

**Authorization** - процесс проверки, разрешены ли аутентифицированному пользователю досткуп к определенному ресурсу или выполнение определенных действий. Ответ на вопрос: "Что разрешено пользователю?".

Spring позволяет реализовывать авторизацию на двух уровнях:

* веб уровень
    - задание шаблонов и ролей
    - `mvcMatcher("/admin").hasRole("ADMIN")`
* уровень метода
    - `@Secured`
    - `@PreAuthorize`
    - аннотации JSR 250 (`@RolesAllowed`, `@PermitAll` и др.)

Права доступа могут быть заданы через:

* Роли
    - отображают высокоуровневые привелегии, например ROLE_ADMIN, ROLE_CUSTOMER
    - используются в методах типа `hasRole`
* Права (authorities)
    - низкоуровневые разрешения типа READ_CUSTOMERS, DELETE_EMPLOYEE
    - используются в методах типа `hasAuthority` 
* Иерархия ролей 
    - выражает отношение между ролями, что одна роль может включать все разрешения другой роли


### 6.2

### 6.3 Delegating filter proxy

[spring security docs](https://docs.spring.io/spring-security/site/docs/3.0.x/reference/security-filter-chain.html)

**DelegatingFilterProxy** - класс фреймворка `org.springframework.web.filter`, входит в веб-часть Spring'а.

Играет роль прослойки/прокси между стандартными фильтрами Servlet API и фильтрами-бина Spring'а. Т. е. он сам является Servlet-фильтром, управляется веб-контейнером, но перенаправляет обработку фильтрам-бинам, зарегистрированным в контексте Spring'а.


(просмотр исходников) Имеет у себя приватное поле типа `Filter`. Это поле инициализируется через поиск бина по имени `targetBeanName`. Этому полю будут перенапралятся вызовы `doFilter()`. По умолчанию внедряется бин класса **FilterChainProxy**. 

Есть аннотация **@EnableWebSecurity**, которая импортирует конфигурационный класс **WebSecurityConfiguration**. Этот класс и создает **FilterChainProxy**


#### 6.3.2 Собственные фильтры

##### 6.3.2.1 Добавление 

Создать класс, реализующий `javax.servlet.Filter`. Реализовать метод 

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {...}

Или унаследовать один из классов **GenericFilterBean** или **OncePerRequestFilter**

Добавить экземпляр этого класса в цепочку фильтров. Настройка модуля Security выполняется через конфигурационный класс, расширяющий **WebSecurityConfigurerAdapter**

    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
        }
    }

Фильтр можно вставить до изместного фильтра, после или в той же позиции. Список всех (??) фильтров и их порядок можно посмотреть в `org.springframework.security.config.annotation.web.builders.FilterComparator`. Если одинаковый порядок у нескольких - произвольный порядок выполнения будет.

##### 6.3.2.2 Что можно делать

Есть доступ к объекту **ServletResponse**. Можно просто скастовать в **HttpServletResponse**, который дает доступ к объекту ответа.

Можно обработать как угодно: тело, заголовки, код ответа и т. п.

Дальше варианты:

* передать по цепочке следующим фильтрам
    - `filterChain.doFilter(servletRequest, servletResponse);`
    - если передаем - следующие фильтры могут изменить код ответа
* не передавать дальше
    - тогда сервер вернет ответ в текущем состоянии
    - не передаем скорее всего при ошибке, поэтому статус ответа задаем, например 4хх.

#### 6.3.3 Просмотр фильтров

Класс **DefaultSecurityFilterChain** логгирует список фильтров на уровне `INFO`

Можно разрешить подробную отладку: `logging.level.org.springframework.security.web = TRACE`. Тогда показывает прохождение цепочки фильтров. 

Можно в отладчике просмотреть метод **HttpSecurity#addFilter**. Будет видно добавление фильтров разными классами **...Configurer** (например **CsrfConfigurer** добавляет **CsrfFilter** и др.)


### 6.4 Security Filter Chain

Это набор фильтров-бинов, которые отвечают за аутентификацию и авторизацию

**SecurityFilterChain** - это интерфейс из пакета `org.springframework.security.web`. Задача - связать URL с набором фильтров.

Два метода:

    boolean matches(HttpServletRequest request);

    List<Filter> getFilters();

Spring предоставляет реализацию - **DefaultSecurityFilterChain**. Для матчинга использует интерфейс **RequestMather** (подходят фильтры запросу или нет устанавливается по данным самого запроса). Возможные реализации: **AntPathRequestMatcher**, **MvcPathRequestMatcher**, **MediaTypeRequestMatcher** и др.

Алгоритм работы:

* **FilterChainProxy** содержит список **SecurityFilterChain**, при обработке запроса выбирается первый
* если матчер дает соответствие, получает список фильтров **Filter**
* **FilterChainProxy** применяет эти фильтры.
* **FilterChainProxy** является зарегистрированным бином в контексте, имя этого бина определено в `AbstractSecurityWebApplicationInitializer#DEFAULT_FILTER_NAME` и это "springSecurityFilterChain"

### 6.5 Security context

Интерфейс **SecurityContext**, дающий доступ к security информации, связанной с текущим процессом. 

    Authentication getAuthentication();
    void setAuthentication(Authentication authentication);

Получить доступ к **SecurityContext** можно через **SecurityContextHolder**, который работает в трех режимах:

* MODE_THREADLOCAL 
* MODE_INHERITABLETHREADLOCAL 
* MODE_GLOBAL

По умолчанию работает в MODE_THREADLOCAL, т. е. каждый поток имеет доступ к собственному экземпляру **SecurityContext**. Например если пользователь залогинился и выполняет запрос, и в обработчике запроса порождается отдельный поток, в этом потоке пользователь залогинен не будет.

Режим MODE_INHERITABLETHREADLOCAL: если поток порождает дочерний поток, родительский и дочерний потоки будут иметь общий **SecurityContext**

Режим MODE_GLOBAL: все потоки имеют общий **SecurityContext**. Не подходит для веб-приложения. Возможно подойдет для десктопа.

Режим можно задать:

* через свойство `spring.security.strategy`
* программно `SecurityContextHolder#setStrategyName`

Основное назначение **SecurityContext** - получать и устанавливать объект **Authorization**. 

**Authentication** представляет токен или данные для аутентификации. Методы:

* `getPrincipal()`   
* `getAythorities()` - набор прав
* `getCredentials()` - данные, подтверждающие корректность principal
* `getDetails()` - дополнительная информация
* `isAuthenticated()`, `setAuthenticated()` - методы для внутреннего использования

Пример получения:

    SecurityContext ctx = SecurityContextHolder.getContext();
    Authentication auth = ctx.getAuthentication();