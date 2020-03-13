package by.it.academy.scientific_activity.annotations;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Slf4j
@Component("person")
public class Person {
    @Value("1")
    private Long id;
    @Value("Semen")
    private String name;
    @Value("Semenov")
    private String surname;
    @Autowired
    @Qualifier("personInfo")
    private PersonInfo personInfo;

    public void init(){
        log.info("init method");
    }

    public void destroy(){
        log.info("destroy method");
    }

}
