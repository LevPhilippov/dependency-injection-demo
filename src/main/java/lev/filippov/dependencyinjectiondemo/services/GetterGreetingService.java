package lev.filippov.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

@Service
public class GetterGreetingService implements GreetingService {
    @Override
    public String seyHello() {
        return "Hello - I was injected by getter";
    }
}
