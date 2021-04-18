package springboot.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("sql")
public class RecorderSqlImpl implements Recorder {
}
