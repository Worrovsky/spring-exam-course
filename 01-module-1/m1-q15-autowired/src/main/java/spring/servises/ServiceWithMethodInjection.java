package spring.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.beans.BeanExists;
import spring.beans.BeanNotExists;

import java.util.Optional;

@Service
public class ServiceWithMethodInjection {

    private BeanExists beanNo1;
    private BeanNotExists beanNo2;
    private Optional<BeanNotExists> beanNo3;
    private BeanExists beanNo4;
    private BeanNotExists beanNo5;

    public ServiceWithMethodInjection() {
        System.out.println("");
        System.out.println(getClass().getName() + ": constructor done!");

    }

    // Note access modifiers are different

    @Autowired
    private void setterWithExistingBeans(BeanExists beanExists) {
        this.beanNo1 = beanExists;
        System.out.println(getClass().getName() + " method setterWithExistingBeans() called");
    }

    // this method didn't called
    @Autowired(required = false)
    void setterWithNotExistingBeans(BeanNotExists beanNotExists) {
        this.beanNo2 = beanNotExists;
        System.out.println(getClass().getName() + " method setterWithNotExistingBeans() didn't called");
    }

    @Autowired
    public void setterWithNotExistingBeansButOptional(Optional<BeanNotExists> beanNotExists) {
        this.beanNo3 = beanNotExists;
        System.out.println(getClass().getName() + " method setterWithNotExistingBeansButOptional() called");
    }

    @Autowired
    void setterWithExistingAndNotExistingBeans(BeanExists beanExists
            , @Autowired(required = false) BeanNotExists beanNotExists) {
        this.beanNo4 = beanExists;
        this.beanNo5 = beanNotExists;
        System.out.println(getClass().getName() + " method setterWithExistingAndNotExistingBeans() called");

    }

    public void check() {

        System.out.println("\n" + getClass().getName() + " check:");
        System.out.println("  configuration.method.bean #1 (exists): " + beanNo1);
        System.out.println("  configuration.method.bean #2 (not exists, method with required=false): " + beanNo2);
        System.out.println("  configuration.method.bean #3 (not exists, optional): " + beanNo3);
        System.out.println("  configuration.method.bean #4 (exists): " + beanNo4);
        System.out.println("  configuration.method.bean #5 (not exists, param with required=false): " + beanNo5);

    }



}
