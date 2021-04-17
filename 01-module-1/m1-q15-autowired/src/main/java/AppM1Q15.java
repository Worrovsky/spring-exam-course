import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ScanConfig;
import spring.servises.ServiceWithMethodInjection;

public class AppM1Q15 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ScanConfig.class);

        ServiceWithMethodInjection service = ctx.getBean(ServiceWithMethodInjection.class);
        service.check();
    }
}
