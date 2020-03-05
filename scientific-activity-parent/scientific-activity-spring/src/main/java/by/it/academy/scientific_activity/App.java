package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.aop.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        TaskService taskService = (TaskService) context.getBean("taskService");
        taskService.performJob();
        taskService.performJobAround();
        try{
            taskService.performExceptionJob();
        }catch (Exception e){
            log.error("Error", e);
        }
        context.close();
    }
}
