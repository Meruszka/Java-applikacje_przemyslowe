package pl.smerski.app.lab03.serviceBean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import pl.smerski.app.lab03.domain.Person;

@Configuration
@ImportResource("classpath:beans.xml")
public class PersonConfig {
    @Bean()
    public Person prezes() {
        return new Person("31", "Chrystal", "Hovoc", "chavocr@yahoo.com", "Mymm");
    }
}
