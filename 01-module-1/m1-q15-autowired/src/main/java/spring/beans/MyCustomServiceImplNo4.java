package spring.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;

@Service
@Priority(2)
public class MyCustomServiceImplNo4 implements MyCustomService {
}
