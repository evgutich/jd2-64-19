package by.it.academy.scientific_activity.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("taskService")
public class TaskService {

    public void performJob() {
        log.info("Perform job");
    }
    public void performExceptionJob() throws Exception {
        log.info("Trow exception in job");
        throw new Exception("Exception Job");
    }

    public String performJobAround(){
        log.info("perform around job");
        return "Success";
    }
}
