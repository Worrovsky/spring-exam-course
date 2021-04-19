import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }

    @Bean
    SpringBeanNo1 beanNo1() {
        return new SpringBeanNo1();
    }

    @Bean
    SpringBeanNo2 beanNo2() {
        return new SpringBeanNo2();
    }
}
