package configuration.level;

import configuration.level.bean.DbService;
import configuration.level.bean.DbServiceImplFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class AppConfigFile {

    @Bean
    public DbService service() {
        return new DbServiceImplFile();
    }
}
