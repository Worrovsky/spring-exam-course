package springboot.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("email")
public class RecorderFileImpl implements Recorder {
}
