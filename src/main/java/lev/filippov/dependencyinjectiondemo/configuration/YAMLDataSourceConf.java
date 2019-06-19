package lev.filippov.dependencyinjectiondemo.configuration;

import lev.filippov.dependencyinjectiondemo.dataSourses.FakeDataSourceForYML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YAMLDataSourceConf {
    //binding setting from YML
    @Value("${fake.yamlusername}")
    private String ymlusername;
    @Value ("${fake.yamlpassword}")
    private String ymlpassword;
    @Value("${fake.yamlurl}")
    private String ymlurl;

    @Bean
    public FakeDataSourceForYML fakeDataSourceForYML() {
        FakeDataSourceForYML fakeDataSourceForYML = new FakeDataSourceForYML();
        fakeDataSourceForYML.setUsername(ymlusername);
        fakeDataSourceForYML.setPassword(ymlpassword);
        fakeDataSourceForYML.setUrl(ymlurl);
        return fakeDataSourceForYML;
    }
}
