package lev.filippov.services;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/24/17.
 */
@Service
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello - Primary Greeting service";
    }

    @Override
    public String getItalianGreeting() {
        return "Ciao a Servizio Primo!";
    }

    @Override
    public String getRusGreeting() {
        return "Приветствие - дефолтная служба приветствия!";
    }
}
