import configuration.DataSourceConfig;
import configuration.DbInitializerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(DataSourceConfig.class, DbInitializerConfig.class);

        ctx.registerShutdownHook();
    }
}
