package lev.filippov.dependencyinjectiondemo;

import lev.filippov.dependencyinjectiondemo.controllers.ConstructorInjectedService;
import lev.filippov.dependencyinjectiondemo.controllers.MyController;
import lev.filippov.dependencyinjectiondemo.controllers.PropertyInjectedController;
import lev.filippov.dependencyinjectiondemo.controllers.SettersInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionDemoApplication.class, args);
        MyController controller = (MyController)applicationContext.getBean("myController");
        System.out.println(controller.hello());
        System.out.println(applicationContext.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(SettersInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(ConstructorInjectedService.class).sayHello() );
    }

}
