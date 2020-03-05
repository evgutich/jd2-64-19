package by.it.academy.scientific_activity.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("work")
public class Work {

    public void beforeWork() {
        log.info("Before work");
    }

    public void afterWork() {
        log.info("After work");
    }

    public void afterWorkProblems() {
        log.error("After work problems!");
    }

}
