package by.it.academy.scientific_activity.repository;

import by.it.academy.scientific_activity.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
