import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(AppConfig.class);
        ctx.refresh();

        SpringBeanNo1 springBeanNo1 = ctx.getBean(SpringBeanNo1.class);
        System.out.println(springBeanNo1);


    }
}
