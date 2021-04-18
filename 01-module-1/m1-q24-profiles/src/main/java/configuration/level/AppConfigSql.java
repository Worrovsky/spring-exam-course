package configuration.level;

import configuration.level.bean.DbService;
import configuration.level.bean.DbServiceImplSql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("sql")
public class AppConfigSql {

    @Bean
    public DbService service() {
        return new DbServiceImplSql();
    }
}
