import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        ctx.registerShutdownHook();

        DataSource ds = ctx.getBean(DataSource.class);

    }
}
