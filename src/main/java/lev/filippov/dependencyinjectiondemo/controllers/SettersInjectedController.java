package lev.filippov.dependencyinjectiondemo.controllers;

import lev.filippov.dependencyinjectiondemo.services.GreetingService;
import lev.filippov.dependencyinjectiondemo.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SettersInjectedController {
    private GreetingService greetingService;

    @Autowired
    @Qualifier("getterGreetingService") //когда подходящих Bean-ов больше одного необходимо добавлять Qualifier - в параметре - имя класса сострочной буквы
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.seyHello();
    }
}
