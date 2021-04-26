package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DbInitializerConfig {

    @Value("classpath:/db-schema.sql")
    private Resource schemaScript;

    @Value("classpath:/db-data.sql")
    private Resource dataScript;

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource ds) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(ds);
        initializer.setDatabasePopulator(datasourcePopulator());
        return initializer;
    }

    private DatabasePopulator datasourcePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        populator.addScript(dataScript);
        return populator;
    }
}
