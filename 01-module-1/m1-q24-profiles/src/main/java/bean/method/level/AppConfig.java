package bean.method.level;

import bean.method.level.beans.Reporter;
import bean.method.level.beans.ReporterEmailImpl;
import bean.method.level.beans.ReporterTelegramImpl;
import bean.method.level.services.CustomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    CustomService getCustomService(Reporter reporter) {
        return new CustomService(reporter);
    }

    @Bean
    @Profile("email")
    Reporter getEmailReporter() {
        return new ReporterEmailImpl();
    }

    @Bean
    @Profile("telegram")
    Reporter getTelegramReporter() {
        return new ReporterTelegramImpl();
    }
}
