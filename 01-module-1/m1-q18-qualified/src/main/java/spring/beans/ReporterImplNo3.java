package spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
@Qualifier("some-custom-qualifier")
public class ReporterImplNo3 implements Reporter {

}
