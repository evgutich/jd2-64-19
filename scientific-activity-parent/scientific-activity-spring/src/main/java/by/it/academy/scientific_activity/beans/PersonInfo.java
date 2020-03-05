package by.it.academy.scientific_activity.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {
    private Long id;
    private Person person;
    private Double salary;
    private LocalDate dateOfBirth;
}
