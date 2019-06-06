package lev.filippov.services;


public class PrimaryItalianGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryItalianGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getItalianGreeting();
    }
}
