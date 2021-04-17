package spring.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.beans.MyCustomService;

import java.util.List;

@Service
public class ServiceWithListOfBeans {

    @Autowired
    public void setList(List<MyCustomService> serviceList) {
        System.out.println("\n" + getClass().getName() + ": list of services in order:");
        serviceList.stream()
                .map(service -> "\t" + service.getClass().getName())
                .forEach(System.out::println);
    }
}
