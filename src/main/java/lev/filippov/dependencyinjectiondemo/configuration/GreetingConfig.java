package lev.filippov.dependencyinjectiondemo.configuration;

import lev.filippov.services.GreetingRepository;
import lev.filippov.services.GreetingService;
import lev.filippov.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository){
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    @Primary
    @Profile("it")
    GreetingService getItGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("it");
    }

    @Bean
    @Primary
    @Profile("rus")
    GreetingService getRusGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("rus");
    }

    @Bean
    @Primary
    @Profile({"en","default"})
    GreetingService getEnGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("en");
    }
}
