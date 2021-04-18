package component.level.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("real")
public class ServiceInterfaceProfileReal implements ServiceInterface {
}
