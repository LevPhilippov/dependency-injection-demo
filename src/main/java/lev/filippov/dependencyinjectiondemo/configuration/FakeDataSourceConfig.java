package lev.filippov.dependencyinjectiondemo.configuration;

import lev.filippov.dependencyinjectiondemo.dataSourses.AnotherOneFakeDataSource;
import lev.filippov.dependencyinjectiondemo.dataSourses.FakeDataSourceForYML;
import lev.filippov.dependencyinjectiondemo.dataSourses.FakeDataSourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:moredatasource.properties"})
// говорим, где PropertySourcesPlaceholderConfigurer будет искать файл конфигурации
//можно создать массив URI для @PropertySourse или использовать @PropertySources, где внутри в {} указать каждый @PropertySource
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:moredatasource.properties")
})
//также можно определить properties в application.properties - для этого не нужны @PropertySource/s и PSPH
public class FakeDataSourceConfig {

    @Autowired
    Environment environment; //объект, хранящий системные переменные (их можно задать прямо из IDE)

    @Value("${fake.username}") //запись на языке Spring expression lang
    private String username;
    @Value ("${fake.password}")
    private String password;
    @Value("${fake.url}") //  highcase == lowerCase! (highcase is not allowed!!!)
    private String url;

    //creating a Multi-property class
    @Value("${fake.more.username}")
    private String moreusername;
    @Value ("${fake.more.password}")
    private String morepassword;
    @Value("${fake.more.url}")
    private String moreurl;

    //binding setting from YML
    @Value("${fake.yamlusername}")
    private String ymlusername;
    @Value ("${fake.yamlpassword}")
    private String ymlpassword;
    @Value("${fake.yamlurl}")
    private String ymlurl;


    @Bean
    public FakeDataSourse fakeDataSourse(){
        FakeDataSourse fakeDataSourse = new FakeDataSourse();
        fakeDataSourse.setUsername(environment.getProperty("MYUSERNAME")); //используем определенную в IDE системную переменную среды
        fakeDataSourse.setPassword(password);
        fakeDataSourse.setUrl(url);
        return fakeDataSourse;
    }

    @Bean
    public AnotherOneFakeDataSource anotherOneFakeDataSource(){
        AnotherOneFakeDataSource anotherOneFakeDataSource = new AnotherOneFakeDataSource();
        anotherOneFakeDataSource.setUrl(moreurl);
        anotherOneFakeDataSource.setUsername(moreusername);
        anotherOneFakeDataSource.setPassword(morepassword);
        return anotherOneFakeDataSource;
    }

    @Bean
    public FakeDataSourceForYML fakeDataSourceForYML() {
        FakeDataSourceForYML fakeDataSourceForYML = new FakeDataSourceForYML();
        fakeDataSourceForYML.setUsername(ymlusername);
        fakeDataSourceForYML.setPassword(ymlpassword);
        fakeDataSourceForYML.setUrl(ymlurl);
        return fakeDataSourceForYML;
    }

    @Bean //эта штука занимается поиском файла конфигурации, она должна быть именно в таком виде
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
