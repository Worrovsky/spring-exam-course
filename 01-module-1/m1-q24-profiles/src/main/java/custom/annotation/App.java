package custom.annotation;

import custom.annotation.beans.Reporter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();

        ctx.getEnvironment().setActiveProfiles("sql");
        ctx.register(AppScanConfig.class);
        ctx.refresh();

        Reporter reporter = ctx.getBean(Reporter.class);
        reporter.report();
    }
}
