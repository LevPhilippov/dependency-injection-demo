package lev.filippov.dependencyinjectiondemo.controllers;

import lev.filippov.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedService {
    GreetingService greetingService;

    @Autowired
    public ConstructorInjectedService(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
