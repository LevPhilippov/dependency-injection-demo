package lev.filippov.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

@Service //делает класс Bean-он Spring
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "HelloWorld! - Original";
    }
}
