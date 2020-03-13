package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.annotations.NoXMLConfiguration;
import by.it.academy.scientific_activity.annotations.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoXMLConfiguration.class);
        context.refresh();
        context.start();
        PersonService service = context.getBean(PersonService.class);
        log.info("Person name: " + service.getPersonName());
        context.close();
    }
}
