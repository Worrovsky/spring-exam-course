package spring.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class MyCustomServiceImplNo3 implements MyCustomService {
}
