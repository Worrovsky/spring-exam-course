package custom.annotation.beans;

import custom.annotation.annotations.FileProfile;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@FileProfile
@Component
//@Profile("file")
public class ReporterFileImpl implements Reporter {
}
