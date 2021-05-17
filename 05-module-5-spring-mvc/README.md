## 5. Модуль #5. Spring MVC

<!-- MarkdownTOC autolink="true" levels="3" -->

- [5.1 Что такое MVC](#51-%D0%A7%D1%82%D0%BE-%D1%82%D0%B0%D0%BA%D0%BE%D0%B5-mvc)
- [5.2 DispatcherServlet](#52-dispatcherservlet)
- [5.3 Web Application Context. Области видимости](#53-web-application-context-%D0%9E%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D0%B8-%D0%B2%D0%B8%D0%B4%D0%B8%D0%BC%D0%BE%D1%81%D1%82%D0%B8)
- [5.4 Аннотация @Controller](#54-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-controller)
- [5.5 Как входящие запросы распределяются по контроллерам и методам](#55-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%85%D0%BE%D0%B4%D1%8F%D1%89%D0%B8%D0%B5-%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81%D1%8B-%D1%80%D0%B0%D1%81%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D1%8F%D1%8E%D1%82%D1%81%D1%8F-%D0%BF%D0%BE-%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%BB%D0%B5%D1%80%D0%B0%D0%BC-%D0%B8-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0%D0%BC)
- [5.6 Разница между @RequestMapping и @GetMapping](#56-%D0%A0%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-requestmapping-%D0%B8-getmapping)
- [5.7 Аннотация @RequestParam](#57-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F-requestparam)
- [5.8 Разница между @RequestParam и PathVariable](#58-%D0%A0%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-requestparam-%D0%B8-pathvariable)
- [5.9 Типы параметров для методов контроллеров](#59-%D0%A2%D0%B8%D0%BF%D1%8B-%D0%BF%D0%B0%D1%80%D0%B0%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%B2-%D0%B4%D0%BB%D1%8F-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%BE%D0%B2-%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%BB%D0%B5%D1%80%D0%BE%D0%B2)
- [5.10 Аннотации, применяемые к методам контроллеров](#510-%D0%90%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D0%B8-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D0%BD%D1%8F%D0%B5%D0%BC%D1%8B%D0%B5-%D0%BA-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0%D0%BC-%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%BB%D0%B5%D1%80%D0%BE%D0%B2)
- [5.11 Типы, возвращаемые методами контроллеров и аннотации, влияющие на возвращаемые значения](#511-%D0%A2%D0%B8%D0%BF%D1%8B-%D0%B2%D0%BE%D0%B7%D0%B2%D1%80%D0%B0%D1%89%D0%B0%D0%B5%D0%BC%D1%8B%D0%B5-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0%D0%BC%D0%B8-%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%BB%D0%B5%D1%80%D0%BE%D0%B2-%D0%B8-%D0%B0%D0%BD%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D0%B8-%D0%B2%D0%BB%D0%B8%D1%8F%D1%8E%D1%89%D0%B8%D0%B5-%D0%BD%D0%B0-%D0%B2%D0%BE%D0%B7%D0%B2%D1%80%D0%B0%D1%89%D0%B0%D0%B5%D0%BC%D1%8B%D0%B5-%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%B8%D1%8F)

<!-- /MarkdownTOC -->

### 5.1 Что такое MVC

MVC - шаблон проектирования, разделяет приложение на 3 взаимодействующие части:

* Model: 
    - определяет структуру данных
    - обеспечивает доступ к ним
    - определяет бизнес-логику
* View:
    - представляет данные для пользователей
    - можно разные представления для одних и тех же данных
* Controller:
    - обрабатывает запросы от пользователей
    - передает команды в модель
    - выбирает представление для отображения модели

Spring предоставляет следующие механизмы:

* для моделей: Spring Data JPA, Spring Data JDBC и т. п.
* для представлений: Thymeleaf, Freemarker, Velosity, JSP и др.
* контроллеры: @Controller и @RestController

Преимущества MVC:

* разделение концепций
* повышение переиспользования кода
* уменьшение связанности между частями приложения
* повышение расширяемости приложения


### 5.2 DispatcherServlet

**DispatcherServlet** - внутренний компонент Spring Mvc, реализует интерфейс **HttpServlet** из Servlet API и паттерн Front Controller.

Обязанности:

* принимает все запросы и подбирает соответствующий контроллер
* использует ViewResolver для определения представления по данным контроллера
* создает ответ, отправляемый пользователям
* управляет общими функциями: обработка исключений, безопасность и т. п.

### 5.3 Web Application Context. Области видимости

Web Application Context - это Spring Application Context для веб-приложений, запускается под встроенным или самостоятельным сервером приложений, поддерживает Selvlet API и является контейнером сервлетов.

Является реализацией интерфейса **WebApplicationContext** и предоставляет доступ к интерфейсу **ServletContext** из Servlet API.

Web Application Context дает доступ к следующим областям видимости:

* **Request Scope**:
    - **@RequestScope**
    - цикл бина привязан к циклу HTTP запросов, на каждый запрос - свой бин
* **Session Scope**:
    - **@SessionScope**
    - цикл завязан на HTTP сессию
* **Application Scope**:
    - **@ApplicationScope**
    - цикл бина завязан на цикл Servlet Context
    - отличие от Singleton:
        + одно приложение может содержать несколько контекстов, Singleton'ы привязаны к ним, бин с Application Scope привязан к Servlet Context.
* **Websocket Scope**:
    - **@Scope(scopeName = "websocket", proxyMode=...)**


### 5.4 Аннотация @Controller

**@Controller** означает что этот класс является контроллером из паттерна MVC. DispatcherServlet будет рассматривать этот класс как кандидат на обработку запросов.

Включает в себя аннотацию **@Component**, поэтому Spring при сканировании будет создавать бины этих классов.

Классы с аннотацией **@Controller** не обязан реализовывать какие-либо интерфейсы или наследовать классы. Соответствие запрос-метод-обработчик устанавливается через дополнительные аннотации **@GetMapping** и т. п.

    @Controller
    public class TestController {
        @GetMapping("/user")
        public String getUser() {
            ....
        }
    }

### 5.5 Как входящие запросы распределяются по контроллерам и методам

DispatcherServlet принимает входящий запрос и, используя **HandlerMapping** и **HandlerAdapter**, выбирает обработчик.

**HandlerMapping** во время инициализации приложения ищет кандидатов для обработки запросов по аннотации **@Controller** или **@RestController**, а также по аннотациям над методами **@RequestMapping** (или составных типа **@GetMapping**).

**HandlerAdapter** отвечает за непосрественное выполнение методов, зарегистрированных как кандидаты для обработчиков запросов.


**Алгоритм обработки запроса**:

* Application Server ищет сервлет для обработки запроса. Выбирает **DispatcherServlet** на основе регистрации и соответствия url.
* **DispatcherServlet**, используя **HandlerMapping**, получает информацию об обработчике конкретного запроса.
* **DispatcherServlet** использует **HandlerAdapter** для выполнения метода контроллера.
* **DispatcherServlet** интерпретирует результат выполнения и рендерит Представление с помощью **ViewResolver**

Аннотация **@RequestMapping** может ставиться над классом или методом. Указывается путь, запросы на который обрабатывает этот класс или метод. Можно поставить над классом общий путь, а над методом уточнить путь или метод HTTP запроса.

    @Controller
    @RequestMapping(path ="/api")
    public class Controller {
        @RequestMapping("/user", method = GET)
        public String getUser() { ... }
    }

**RequestMapping** позволяет определять следующие параметры запроса:

* `path` - URI запроса (можно несколько)
* `method` - обрабатываемые HTTP методы (GET, POST, ...)
* `params` - требуемые параметры запроса
* `headers` - требуемые заголовки
* `produces` - указывает тип, который возвращает запрос


### 5.6 Разница между @RequestMapping и @GetMapping

**@RequestMapping** работает со всеми методами HTTP запроса.

**@GetMapping** работает только с GET методом. Это составная аннотация, включает в себя **@RequestMapping**.

### 5.7 Аннотация @RequestParam

**@RequestParam** используется для связывания параметров запроса с параметрами метода контроллера:

    // /index?name=Bob&city=NY
    @GetMapping("index")
    public String get( @RequestParam("name") String name,
                       @RequestParam("city") String city) {...} 


У Servlet API есть особенность: параметры из url и данные формы группируются в одну карту параметров. Поэтому **@RequestParam** можно использовать и для чтения параметров формы.

Свойства аннотации **@RequestParam**:

* `name` - имя параметра для связывания
* `required` - обязателен или нет. По умолчанию - да. Если в url не будет найден - исключение.
* `defaultValue` - значение по умолчанию. Будет использовано, если параметр не задан и `required = false`.

Поддерживается работа с Optional, поэтому следующие сигнатуры эквиваленты:

    @RequestParam("name", required = false) String name
    @RequestParam("name") Optional<String> name


Можно все параметры в карту поместить:
    
    // /index?name=Bob&city=NY
    public String get(@RequestParam Map<String, String> params)

Можно в список:

    // /index?cities=NY,MS,DE
    public String get(@RequestParam("cities") List<String> cities)




### 5.8 Разница между @RequestParam и PathVariable

Аннотация **@PathVariable** используется для получения части url через использование шаблона с `{}`:

    // /coutries/Canada/cities/Toronto
    @RequestMapping("countries/{country}/cities/{city}")
    public void do (@PathVariable("country") String country),
                    @PathVariable("city") String city) {...}

Аннотация **@RequestParam** извлекает параметры из параметров url:

    // /index?country=Canada&city=Toronto
    @RequestMapping("/index")
    public void do (@RequestParam("country") String country,
                    @RequestParam("city") String city) { ... }

Дополнительно: **@RequestParam** позволяет указывать значение по умолчанию, **@PathVariable**не разрешает значения по умолчанию.

Обе аннотации разрешают:

* задавать имя переменной
* помечать опциональными
* использовать Optional для необязательных
* помещать параметры в карты и коллекции






### 5.9 Типы параметров для методов контроллеров

**WebRequest** - это спринговый интерфейс. Дает доступ к заголовкам, телу, данным сессии и т. п. Не привязан к Servlet API.

    @GetMapping
    public String get(WebRequest wr) {
        wr.getHeaderNames();
    }

**javax.servlet.ServletRequest** - также дает доступ к данным запроса, но уже без привязки к Spring, через Servlet API.

**javax.servlet.ServletResponse** - доступ к объекту ответа. В таком методе можно ничего не возвращать, а напрямую работать с объектом ServletResponse. Например имеет методы для вывода через поток.

**javax.servlet.HttpSession** - доступ к сессии, возможность чтения, установки атрибутов сессии.

**javax.servlet.http.PushBuilder** -  работа с Servlet 4.0 Push Builder API

**java.security.Principal** - сведения о текущем пользователе (при работе с модулем security)

**HttpMethod** - метод HTTP запроса

**java.util.Locale** - определяет язык запроса через **LocaleResolver** (по умолчанию через заголовок запроса `accept-language`)

**java.util.TimeZone** + **java.util.ZoneId** - определяются через **LocalContextResolver**

**java.io.InputStream**, **java.io.Reader** - чтение тела запроса

**java.io.OutputStream**, **java.io.Writer** - запись в тело ответа

**HttpEntity** - объект, который представляет запрос или ответ. Включает в себя заголовки и тело. Тело преобразуется с помощью **HttpMessageConverter**

**java.util.Map**, **org.springframework.ui.Model**, **org.springframework.ui.ModelMap** - используются для передачи данных в шаблон Представления:

    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", "bob");
        return "index"; // это имя представления
    }

**RedirectAttributes** - позволяет устанавливать атрибуты, передаваемые при редиректах. Например обрабатываем запрос, устанавливаем атрибуты и возвращаем редирект. Тогда на новой странице будет доступ к ранее установленным атрибутам. Атрибуты двух видов бывают: разовые и действующие в пределах сессии.

**Errors**, **BindingResult** - используются для получения данных валидации и проверки на ошибки.

**SessionStatus** + **@SessionAttributes** над контроллером + **@ModelAttribute** - применяется когда между несколькими запросами необходимо сохранять какие-то атрибуты (например заполнение данных в несколько шагов: на каждом шаге переходим на новую страницу, но данные сохраняются между переходами). **@ModelAttribute** представляет сохраняемые данные, **SessionStatus** позволяет очищать атрибуты, когда уже не нужны.

**Остальные случаи** - если явно не указана аннотация или тип не подходит под перечисленные, тогда по умолчанию для простых типов считает как **@RequesrParam**, для ссылочных - как **@ModelAttribute** (data binding)


### 5.10 Аннотации, применяемые к методам контроллеров

**@RequestParam** - доступ к параметрам запроса

**@PathVariable** - доступ к путям URL через шаблоны

**@MatrixVariable** - доступ к парам имя-значение в URL по стандарту RFC 3986 (например `/user/id=1;name=Alice`)

**@CookieValue** - доступ к кукам. Может быть простой тип или объект типа **Cookie**. Можно обязательность указывать, задавать как Optional и значения по умолчанию.

**@RequestHeader** - доступ к заголовкам запроса. Можно все заголовки в карту положить. Также можно опциональность указать, Optional использовать и значение по умолчанию.

**@RequestBody** - доступ к телу запроса. Может быть простым типом (строкой) или объектом, в который будет преобразовано тело с помощью **HttpMessageConverter**

**@RequestPart** - для multipart-запросов

**@RequestAttribute** - получение атрибута запроса. Атрибуты могут добавляться разными интерсепторами например.

**@ModelAttribute** - связывание данных запроса (объект с формы например) с параметром

**@SessionAttribyte** - атрибут сессии

**@SessionAttributes** - аннотация над классом для сохранения атрибутов между несколькими запросами в пределах одной сессии.



### 5.11 Типы, возвращаемые методами контроллеров и аннотации, влияющие на возвращаемые значения

**@ResponseBody** - аннотация, связывает возвращаемое значение с телом ответа. Для сложных типов преобразование выполняется через **HttpMessageConverter**.

**HttpEntity<B>**, **ResponseEntity<B>** - позволяет полностью описать ответ. **ResponseEntity** еще позволяет установить статус ответа.

    public ResponseEntity<Person> get() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Person-Version", "v2");
        return new ResponseEntity<>(
                new Person("John", "Doe"),
                httpHeaders,
                HttpStatus.FOUND
        );
    }

**HttpHeaders** - возвращает только заголовки без тела

**String** - возвращает логическое имя представления. Конкретное представление определяется с помощью **ViewResolver**. Часто используется совместно с параметром с **@ModelAttribyte**, что позволяет передавать данные в представление.

**View** - конкретное представление

**Map**, **Model** - позволяет передавать данные в представление. Само представление здесь определяется через **RequestToViewNameTranslator** (по умолчанию - по имени метода).

**@ModelAttribyte** - аналогично предыдущему, но возвращается объект

    @GetMapping("")
    @ModelAttribute
    public Person get() {
        return new Person("John", "Doe");
    }

**ModelAndView** - представление (логическое имя или объект View) и модель (именованный объект или Map). Также можно код ответа устанавливать. 
    
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(
                "view-name",
                "person",
                new Person("John", "Doe")
        );
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView; 
    }

**void** - когда в параметрах метода есть ответ в виде **ServletResponse** или **OutputStream** и возвращать ничего не надо. Или это означает отсутствие тела для REST контроллеров.

**DeferredResult<V>** - асинхронный результат из другого потока.

**Callable<V>** - также для асинхронных операций

**ListenableFuture**, **CompletableFuture**, **CompletionStage** - для цепочки асинхронных операций.

**ResponseBodyEmitter**, **SseEmitter** - передача объекта в поток асинхронно.

**StreamingResponseBody** - запись в поток ответа асинхронно.

