package lev.filippov.services;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en":
                return new DefaultGreetingService(greetingRepository);
            case "it":
                return new PrimaryItalianGreetingService(greetingRepository);
            case "rus":
                return new PrimaryRusGreetingService(greetingRepository);
            default:
            return new DefaultGreetingService(greetingRepository);
         }
    }
}
