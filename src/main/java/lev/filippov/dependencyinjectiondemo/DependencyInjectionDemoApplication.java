package lev.filippov.dependencyinjectiondemo;

import lev.filippov.dependencyinjectiondemo.controllers.ConstructorInjectedService;
import lev.filippov.dependencyinjectiondemo.controllers.MyController;
import lev.filippov.dependencyinjectiondemo.controllers.PropertyInjectedController;
import lev.filippov.dependencyinjectiondemo.controllers.SettersInjectedController;
import lev.filippov.dependencyinjectiondemo.dataSourses.AnotherOneFakeDataSource;
import lev.filippov.dependencyinjectiondemo.dataSourses.FakeDataSourceForYML;
import lev.filippov.dependencyinjectiondemo.dataSourses.FakeDataSourse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//спринг сканирует на наличие аннотаций packageб в котором располагается и все дочерние. Если bean-ы находятся
//в других package или выше Спринг не ищет их автоматически- мы используем @ComponentScan - аннотацию чтобы указатьб где искать.
@ComponentScan(basePackages = {"lev.filippov.services", "lev.filippov.dependencyinjectiondemo"})
public class DependencyInjectionDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionDemoApplication.class, args);
        //injectionDemoWithDifferentControllers(applicationContext);

        System.out.println(applicationContext.getBean(FakeDataSourse.class).getUrl());
        System.out.println(applicationContext.getBean(FakeDataSourse.class).getUsername());
        //вызов параметров из другого класса
        System.out.println(applicationContext.getBean(AnotherOneFakeDataSource.class).getUrl());
        //вызов параметров класса от YAML
        System.out.println(applicationContext.getBean(FakeDataSourceForYML.class).getPassword());
    }

    private static void injectionDemoWithDifferentControllers(ApplicationContext applicationContext) {
        MyController controller = (MyController)applicationContext.getBean("myController");
        System.out.println(controller.hello());
        System.out.println(applicationContext.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(SettersInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(ConstructorInjectedService.class).sayHello() );
    }

}
