package lev.filippov.dependencyinjectiondemo.controllers;

import lev.filippov.dependencyinjectiondemo.services.GreetingService;
import lev.filippov.dependencyinjectiondemo.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingService greetingServiceImpl;
    //можно сделать даже так. (У нас 2 имплементации Greeting Service, но если название поля совпадает
    //с именем класса, который имплементирует этот интерфейс - Спринг понимает, что нужно использовать его )

    public String sayHello(){
        return  greetingServiceImpl.seyHello();
        }
}