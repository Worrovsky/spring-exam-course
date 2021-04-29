package configuration;

import dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import service.StudentService;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public StudentService studentService() {
        return new StudentService();
    }
}
