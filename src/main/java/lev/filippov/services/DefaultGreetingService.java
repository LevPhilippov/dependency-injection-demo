package lev.filippov.services;

public class DefaultGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public DefaultGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
