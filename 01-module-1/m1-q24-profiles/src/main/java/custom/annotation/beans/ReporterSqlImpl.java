package custom.annotation.beans;

import custom.annotation.annotations.SqlProfile;
import org.springframework.stereotype.Component;

@SqlProfile
@Component
public class ReporterSqlImpl implements Reporter {
}
