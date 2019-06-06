package lev.filippov.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("it")
public class ItalianGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Saluto a Servizio Primo";
    }
}
