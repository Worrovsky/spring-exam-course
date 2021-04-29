import configuration.Config;
import dao.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.StudentService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.registerShutdownHook();

        StudentService service = ctx.getBean(StudentService.class);
        service.doWork();

    }
}
