package custom.annotation.annotations;

import org.springframework.context.annotation.Profile;

@Profile("sql")
public @interface SqlProfile {
}
