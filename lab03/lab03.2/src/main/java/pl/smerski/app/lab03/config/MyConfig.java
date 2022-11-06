package pl.smerski.app.lab03.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.smerski.app.lab03.serviceBean.PersonManagerInMemory;

@Configuration
public class MyConfig {
    @Bean(name = {"myBean", "myBean2"})
    public PersonManagerInMemory loadData() {
        return new PersonManagerInMemory();
    }
}
