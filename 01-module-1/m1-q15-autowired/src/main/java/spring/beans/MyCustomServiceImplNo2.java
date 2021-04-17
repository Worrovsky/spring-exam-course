package spring.beans;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

@Service
public class MyCustomServiceImplNo2 implements MyCustomService, Ordered {
    @Override
    public int getOrder() {
        return 4;
    }
}
