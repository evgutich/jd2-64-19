package by.it.academy.scientific_activity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class EmployeeCriteria {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Double salary;
    @Column
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private DepartmentCriteria department;
}
