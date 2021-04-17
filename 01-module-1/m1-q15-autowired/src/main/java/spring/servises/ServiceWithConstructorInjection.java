package spring.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import spring.beans.BeanExists;
import spring.beans.BeanNotExists;

import java.util.Optional;

@Service
public class ServiceWithConstructorInjection {

    private BeanExists beanNo1;
    private BeanExists beanNo2;
    private BeanExists beanNo3;
    private BeanNotExists beanNo4;
    private Optional<BeanNotExists> beanNo5;

    // with single constructor no need @Autowired
    public ServiceWithConstructorInjection(BeanExists beanNo1
            , BeanExists beanNo2
            , @Autowired(required = false) BeanExists beanNo3
            , @Nullable BeanNotExists beanNo4
            , Optional<BeanNotExists> beanNo5) {

        this.beanNo1 = beanNo1;
        this.beanNo2 = beanNo2;
        this.beanNo3 = beanNo3;
        this.beanNo4 = beanNo4;
        this.beanNo5 = beanNo5;

        System.out.println(getClass().getName() + ": constructor done");
        System.out.println("  bean #1: " + beanNo1);
        System.out.println("  bean #2: " + beanNo2);
        System.out.println("  bean #3 (exist, required = false): " + beanNo3);
        System.out.println("  bean #4 (not exist, @Nullable): " + beanNo4);
        System.out.println("  bean #5 (not exist, Optional): " + beanNo5);
        System.out.println("");
    }
}
