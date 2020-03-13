package by.it.academy.scientific_activity.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.it.academy.scientific_activity.annotations")
public class NoXMLConfiguration {
    @Bean(value = "personBean", initMethod = "init", destroyMethod = "destroy")
    public Person getPerson() {
        return new Person();
    }
}
