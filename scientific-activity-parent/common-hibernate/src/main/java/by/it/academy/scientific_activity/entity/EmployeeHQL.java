package by.it.academy.scientific_activity.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EMPLOYEE_HQL")
public class EmployeeHQL {
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
    private DepartmentHQL department;
}
