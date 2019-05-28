package lev.filippov.dependencyinjectiondemo.controllers;

import lev.filippov.dependencyinjectiondemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedService {
    GreetingService greetingService;

    public ConstructorInjectedService(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
