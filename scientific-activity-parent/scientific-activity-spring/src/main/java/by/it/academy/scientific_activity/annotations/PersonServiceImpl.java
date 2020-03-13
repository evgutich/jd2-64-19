package by.it.academy.scientific_activity.annotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private Person person;

    @PostConstruct
    public void init(){
        log.info("post construct annotation");
    }

    @PreDestroy
    public void destroy(){
        log.info("pre destroy annotation");
    }

    @Override
    public String getPersonName() {
        return person.getName();
    }
}
