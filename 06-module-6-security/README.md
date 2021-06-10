## 6. Модуль #6. Spring Security

<!-- MarkdownTOC autolink="true" levels="3" -->

- [6.1 Authentication and authorization](#61-authentication-and-authorization)
- [6.2 Реализация Spring Security](#62-%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F-spring-security)
- [6.3 Delegating filter proxy](#63-delegating-filter-proxy)
- [6.4 Security Filter Chain](#64-security-filter-chain)
- [6.5 Security context](#65-security-context)
- [6.6 Шаблоны для antMatcher и mvcMatcher](#66-%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD%D1%8B-%D0%B4%D0%BB%D1%8F-antmatcher-%D0%B8-mvcmatcher)
- [6.7 Почему mvcMatcher предпочтительнее чем antMatcher](#67-%D0%9F%D0%BE%D1%87%D0%B5%D0%BC%D1%83-mvcmatcher-%D0%BF%D1%80%D0%B5%D0%B4%D0%BF%D0%BE%D1%87%D1%82%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%B5%D0%B5-%D1%87%D0%B5%D0%BC-antmatcher)
- [6.8 Как Spring поддерживает хеширование паролей. Соли паролей](#68-%D0%9A%D0%B0%D0%BA-spring-%D0%BF%D0%BE%D0%B4%D0%B4%D0%B5%D1%80%D0%B6%D0%B8%D0%B2%D0%B0%D0%B5%D1%82-%D1%85%D0%B5%D1%88%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D0%B5%D0%B9-%D0%A1%D0%BE%D0%BB%D0%B8-%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D0%B5%D0%B9)
- [6.9 Security на уровне методов](#69-security-%D0%BD%D0%B0-%D1%83%D1%80%D0%BE%D0%B2%D0%BD%D0%B5-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%BE%D0%B2)
- [6.10 Разница между @PreAuthorize и @RolesAllowed](#610-%D0%A0%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-preauthorize-%D0%B8-rolesallowed)
- [6.11 Как выполняются @PreAuthorize и @RolesAllowed](#611-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D1%8F%D1%8E%D1%82%D1%81%D1%8F-preauthorize-%D0%B8-rolesallowed)
- [6.12 Аннотации с использованием SpEL](#612-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D0%B8-%D1%81-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-spel)

<!-- /MarkdownTOC -->

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


### 6.2 Реализация Spring Security

Два уровня:

* Веб уровень: на основе фильтров Servlet API
* Безопасность на уровне методов: Spring AOP

Компоненты блока Spring Security:

* для аутентификации:
    - AuthenticationManager
    - ProviderManager
    - AuthenticationProvider
    - UserDetailsService
* для авторизации:
    - AccessDecisionManager
        + AccessDecisionVoter
    - AfterInvocationManager
    - Authorities

**SecurityContextHolder** - основной объект, где в процессе работы хранится информация об аутентифицированных пользователях.

**SecurityContext** - объект, хранящийся в **SCH**, и предоставляющий доступ к объекту **Authentication**

**Authentication** - представляет аутентифицированного или нет пользователя с его данными. Входные данные для **AuthenticationManager**

**GrantedAuthority** - права, предоставленные пользователю, например роли.

**AuthenticationManager** - API, определяющее как фильтры выполняют аутентификацию. Обычно реализуется **ProviderManager**ом

**ProviderManager** - реализация **AM**, перенаправляет аутентификацию списку **AuthenticationProvider**ов. Если хотя бы один **AP** подтвердит пользователя, будет считаться аутентифицированным.


**AccessDecisionManager** вызывается **SecurityInterceptor**ом перед выполнением методов, для решения разрешено или нет выполнение на основе прав пользователя **GrantedAuthority**. Делегирует решение списку **AccessDecisionVoter**ов


**AfterInvocationManager** - вызывается после выполнения метода, для решения разрешен ли пользователю доступ к результату метода

**UserDetailsService** - абстракция, обеспечивающая хранения данных пользователя. Через нее другие компоненты получают данные о пользователях для проверки. Разные реализации: в памяти, JDBC и др.


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

Режим MODE_GLOBAL: все потоки имеют общий **SecurityContext**. Не подходит для веб-приложения. Подойдет для десктопа.

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

### 6.6 Шаблоны для antMatcher и mvcMatcher

[manning article #3](https://freecontent.manning.com/five-awkward-things-about-spring-security-that-actually-make-sense/)

Матчеры предназначены для настройки прав по шаблонам, путем сравнения пути (path) запроса с шаблоном.

Пример настройки:

    public class SecureConfig extends WebSecurityConfigurerAdapter {
     
        @Override
        protected void configure(HttpSecurity http) {
              http.authorizeRequests()
                   .antMatchers("/**")
                   .hasRole("USER")
                   .permitAll();
        }
    }

Варианты матчеров:

* **ANT** `antMatcher()` - использует синтаксис ANT для шаблона 
* **MVC** `mvcMatcher()` - также использует синтаксис ANT, но для шаблона "/abc", ANT защищает только точный путь "/abc", MVC будет защищать еще и все подчиненные ("/abc/def" и т. п.)
* **regex** `regexMatcher()` - использует регулярные выражения

**Предпочтительнее использовать mvcMatcher()**

Синтаксис ANT:

* `?` - один символ
* `*` - ноль или больше символов в сегменте пути
* `**` - ноль или несколько сегментов
* также поддерживает regex

Например для пути `/dep/delete/5` шаблоны:

* `/dep/delete/*` - соответствует
* `/dep/delete/**` - соответствует
* `/*/5` - НЕ соответствует (`*` - в пределах сегмента только)
* `/**/5` - соответствует
* `/dep/dele??/*` - соответствует

### 6.7 Почему mvcMatcher предпочтительнее чем antMatcher

**antMatcher** слишком строгий, если конец пути не подходит под шаблон соответствия не будет, поэтому можно забыть защитить страницу.

Например:

    antMathers("/users").denyAll()
    // "/users" - отклонит, НО
    // "/users/" - нет

### 6.8 Как Spring поддерживает хеширование паролей. Соли паролей

Хеширование поддерживается через интерфейс **PasswordEncoder**. Методы:

* **encode** - хеширует сырой пароль
* **matches** - проверяет соответствуют ли хеш и сырой пароль. Хеш при этом не восстанавливается в пароль

Одна из предпочтительных реализаций - **BCryptPasswordEncoder**.

Настроить кодировшик можно просто созданием бина. Можно в классе конфигурации, расширяющем **WebSecurityConfigurerAdapter**

    @Configuration
    @EnableWebSecurity  
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

Когда пользователь регистрируется, в БД сохраняется имя пользователя и хеш пароля. Чистый пароль не сохраняется.

Также можно использовать **DelegatingPasswordEncoder**. Он работает со списком кодировщиков. Пароли кодирует по одному выбранному, добавляя префикс к хешу `[bcrypt]3kovk344kvkos...`. Поэтому при проверке может понять, каким алгоритмом закодирован пароль в БД.

Соль для пароля: хеши можно реверснуть через таблицы. Защита: добавление случайных данных к паролю (соли). Кодировшики делают это по умолчанию. В БД хранится соль и хеш. При проверке пароля к нему добавляется соль, хешируется и результат сверяется с сохраненным хешем


### 6.9 Security на уровне методов

Если нужна более точная настройка прав, которая не может быть настроена через веб уровень (на основе шаблонов URL).

Приложение можно рассматривать по уровням. Пользователь взаимодействует с уровнем представлений (это контроллеры для веб приложения). Представления в свою очередь обращаются к сервисному уровню приложения. Если безопасность через URL работает на уровне представлений, безопасность метод работает на сервисном уровне. 

Для установки ограничений на уровне метода используются аннотации

* **@Secured** - спринговая аннотация
* **@RolesAllowed** - аннотация из пакета `javax.annotation.security`
* аннотации @Pre и @Post (**@PreAuthorize**, **@PostAuthorize** и др.)

Первые две принимают строковое представление ролей, назначенных пользователям

    @RolesAllowed("ROLE_ADMIN")

Аннотации по JSR-250 принимают выражения SpEL

    @PreAuthorize("hasRole('ROLE_EMPLOYEES_READ')")

Чтобы можно было использовать эти аннотации их необходимо разрешить через аннотацию **@EnableGlobalMethodSecurity**. Использовать можно на конфигурационном классе:

    @EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
    )

Для тонкой настройки можно расширять класс **GlobalMethodSecurityConfiguration**

### 6.10 Разница между @PreAuthorize и @RolesAllowed

Обе аннотации проверяют перед выполнением метода, разрешено ли пользователю выполнять его.

Для **@RolesAllowed** указывается список ролей. Для **@PreAuthorize** - выражение SpEL.

В выражении можно использовать разные условия:

* hasRole
* hasAnyRole
* hasAuthority
* hasAnyAuthority
* isAnonymous
* isAuthenticated

Например 

    @PreAuthorize("hasRole('ROLE_ADMIN') && isAuthenticated()")

### 6.11 Как выполняются @PreAuthorize и @RolesAllowed

Эти аннотации реализуются через Spring AOP.

**AdvisorAutoProxyCreator** регистрирует **MethodSecurityInterceptor**.
**MethodSecurityInterceptor** вызывает **AccessDecisionManager**.
**AccessDecisionManager** уже перенаправляет проверки **AccessDecisionVoter**


**MethodSecurityInterceptor** можно получить через **GlobalMethodSecurityConfiguration#methodSecurityInterceptor**.

Аннотации используют **Jsr250Voter** и **PreInvocationAuthorizationAdviceVoter**  


### 6.12 Аннотации с использованием SpEL

[docs](https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html)

Это **@PreAuthorize**, **@PostAuthorize**
Код, связанный с аннотациями, вызывается соответственно до и после вызова метода. 

Параметр аннотации - выражение SpEL, возвращающее булево. Если ЛОЖЬ - выбрасывается исключение (до выполнения метода для `@Pre...` или после для `@Post`)

Что доступно для использования в SpEL выражении:

* предопределенные функции (см. **SecurityExpressionRoot**)
    - `hasRole()`
    - `isAnonymous()`
    - `permitAll()` - всегда Истина
    - `вутнAll()` - всегда Ложь
    - и др.
* предопределенные значения, аналоги соответствующих классов с методами
    - `authentication`
    - `principal`
* параметры метода через `#`
* возвращаемое значение через `returnObject`

Фильтр **@PostFilter** применяется для методов, возвращающих коллекции. После выполнения метода, выполняется обход коллекции и для каждого элемента вычисляется SpEL выражение. Если оно ложно - элемент удаляется из коллекции. Для доступа к элементу используется `filterObject`

Фильтр **@PreFilter** работает аналогично, но применяется к параметрам метода. Если в параметрах несколько коллекций, нужно указать явно для какого параметра применяется.

Примеры:

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostFilter("hasPermission(filterObject, 'read') 
                    or hasPermission(filterObject, 'admin')")
    public List<Contact> getAll();


    @PreAuthorize("#contact.name == authentication.name")
    public void doSomething(Contact contact);

    