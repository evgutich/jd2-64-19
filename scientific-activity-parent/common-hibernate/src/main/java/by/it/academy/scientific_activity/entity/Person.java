package by.it.academy.scientific_activity.entity;

import by.it.academy.scientific_activity.embedded.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON_TABLE")
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USER_NAME", nullable = false)
    private String name;
    @Column(name = "USER_SURNAME", nullable = false)
    private String surname;
    @Formula("AS CONCAT ('USER_NAME', 'USER_SURNAME')")
    private String fullName;
    @Column(length = 3)
    private Integer age;
    @Embedded
    private Address address;

}
