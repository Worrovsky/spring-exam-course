package bean.method.level;

import bean.method.level.services.CustomService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();

        ctx.getEnvironment().setActiveProfiles("email");
        ctx.register(AppConfig.class);
        ctx.refresh();

        CustomService service = ctx.getBean(CustomService.class);
        service.doWork();
    }
}
