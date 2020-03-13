package by.it.academy.scientific_activity.beans;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {
    private Long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;
    private Double salary;
    private LocalDate dateOfBirth;
}
