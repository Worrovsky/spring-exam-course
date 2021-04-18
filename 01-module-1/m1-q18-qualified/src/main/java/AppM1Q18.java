import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.AppConfig;
import spring.service.CustomService;

public class AppM1Q18 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomService service = ctx.getBean(CustomService.class);
        service.doWork();
    }
}
