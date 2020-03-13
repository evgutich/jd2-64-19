package by.it.academy.scientific_activity.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@ToString(exclude = {"department"})
@EqualsAndHashCode(exclude = {"department", "employeeDetail", "meetings"})
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @CreationTimestamp
    private LocalDateTime dateTime;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeDetail employeeDetail;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Meeting> meetings = new ArrayList<>();
}
