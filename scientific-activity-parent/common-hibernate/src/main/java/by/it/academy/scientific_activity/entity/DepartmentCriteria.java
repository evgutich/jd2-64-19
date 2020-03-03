package by.it.academy.scientific_activity.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentCriteria {
    @Id
    @GeneratedValue
    @Column(name = "DEPARTMENT_ID")
    private Long id;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmployeeCriteria> employees = new ArrayList<>();
}
