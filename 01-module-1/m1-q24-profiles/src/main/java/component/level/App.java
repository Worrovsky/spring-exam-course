package component.level;

import component.level.bean.ServiceInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();

        ctx.getEnvironment().setActiveProfiles("fake");
        ctx.register(AppScanConfig.class);
        ctx.refresh();

        ServiceInterface service = ctx.getBean(ServiceInterface.class);
        service.doWork();
    }
}
