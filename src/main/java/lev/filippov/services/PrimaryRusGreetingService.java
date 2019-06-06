package lev.filippov.services;


public class PrimaryRusGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryRusGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getRusGreeting();
    }
}
