package lev.filippov.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("default")
public class DefaultGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Приветствие - дефолтная служба приветствия!";
    }
}
