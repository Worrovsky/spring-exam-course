package spring.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import spring.beans.BeanExists;
import spring.beans.BeanNotExists;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class ServiceWithFieldInjection {

    @Autowired
    private BeanExists beanNo1;

    @Autowired(required = false)
    public BeanNotExists beanNo2;

//    @Autowired
//    public BeanNotExists throwExceptionBean;

    @Autowired
    @Nullable
    public BeanNotExists beanNo3;

    @Autowired
    public Optional<BeanNotExists> beanNo4;

    @Autowired
    protected Optional<BeanExists> beanNo5;

    public ServiceWithFieldInjection() {
        System.out.println(getClass().getName() + ": constructor done:");
        System.out.println(" configuration.method.bean #1: (autowired) " + beanNo1);
        System.out.println(" configuration.method.bean #2: (no such configuration.method.bean, not required) " + beanNo2);
        System.out.println(" configuration.method.bean #3: (no such configuration.method.bean, @Nullable) " + beanNo3);
        System.out.println(" configuration.method.bean #4: (no such configuration.method.bean, Optional) " + beanNo4);
        System.out.println(" configuration.method.bean #5: (exists, Optional) " + beanNo5);
    }


    @PostConstruct
    public void checkFields() {
        System.out.println("");
        System.out.println(getClass().getName() + " @PostConstruct:");
        System.out.println("  configuration.method.bean #1: (autowired) " + beanNo1);
        System.out.println("  configuration.method.bean #2: (no such configuration.method.bean, not required) " + beanNo2);
        System.out.println("  configuration.method.bean #3: (no such configuration.method.bean, @Nullable) " + beanNo3);
        System.out.println("  configuration.method.bean #4: (no such configuration.method.bean, Optional) " + beanNo4);
        System.out.println("  configuration.method.bean #5: (no such configuration.method.bean, Optional) " + beanNo5);
    }
}
