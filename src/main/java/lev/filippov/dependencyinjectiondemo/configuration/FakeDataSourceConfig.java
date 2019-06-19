package lev.filippov.dependencyinjectiondemo.configuration;

import lev.filippov.dependencyinjectiondemo.dataSourses.FakeDataSourse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties") //говорим, где PropertySourcesPlaceholderConfigurer будет искать файл конфигурации
public class FakeDataSourceConfig {

    @Value("${fake.username}") //запись на языке Spring expression lang
    private String username;
    @Value ("${fake.password}")
    private String password;
    @Value("${fake.url}") //  highcase == lowerCase! (highcase is not allowed!!!)
    private String url;

    @Bean
    public FakeDataSourse fakeDataSourse(){
        FakeDataSourse fakeDataSourse = new FakeDataSourse();
        fakeDataSourse.setUsername(username);
        fakeDataSourse.setPassword(password);
        fakeDataSourse.setUrl(url);
        return fakeDataSourse;
    }

    @Bean //эта штука занимается поиском файла конфигурации, она должна быть именно в таком виде
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
