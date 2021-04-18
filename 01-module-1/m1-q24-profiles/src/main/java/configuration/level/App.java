package configuration.level;

import configuration.level.bean.DbService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();

        ctx.getEnvironment().setActiveProfiles("sql");
        ctx.register(AppConfigFile.class, AppConfigSql.class);
        ctx.refresh();

        DbService service = ctx.getBean(DbService.class);
        service.save();

    }


}
