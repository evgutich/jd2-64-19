package by.it.academy.scientific_activity.repository;

import by.it.academy.scientific_activity.entity.Department;
import by.it.academy.scientific_activity.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findDepartmentByEmployeesContains(Employee employee);
}
