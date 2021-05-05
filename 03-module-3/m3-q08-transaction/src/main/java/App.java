import configuration.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.StudentService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.registerShutdownHook();

        StudentService service = ctx.getBean(StudentService.class);
        try {
            service.addWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception while adding: " + e.getMessage() );
        }
        service.printStudents();
        service.clear();

        try {
            service.addWithTransaction();
        } catch (Exception e) {
            System.out.println("Exception while adding: " + e.getMessage());
        }
        service.printStudents();

    }
}
