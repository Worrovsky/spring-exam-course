import configuration.DataSourceConfig;
import dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        ctx.registerShutdownHook();

        EmployeeDao dao = ctx.getBean(EmployeeDao.class);
        dao.usingRowMapper();

        dao.usingRowMapperWithLambda();

        dao.totalSalaryWithRowCallbackHandler();

        dao.totalSalaryWithResultSetExtractor();
    }

}
