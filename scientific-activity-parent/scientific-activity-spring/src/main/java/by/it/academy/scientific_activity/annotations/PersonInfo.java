package by.it.academy.scientific_activity.annotations;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("personInfo")
public class PersonInfo {
    @Value("666")
    private Double salary;
    @Value("1999-1-1")
    private String dateOfBirth;
}
