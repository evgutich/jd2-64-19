package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.beans.Meeting;
import by.it.academy.scientific_activity.beans.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Slf4j
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = context.getBean("person", Person.class);
        log.info("Person info: " + person);
        List<Meeting> meetingList = person.getMeetings();
        log.info("Meetings: " + meetingList);
    }
}
