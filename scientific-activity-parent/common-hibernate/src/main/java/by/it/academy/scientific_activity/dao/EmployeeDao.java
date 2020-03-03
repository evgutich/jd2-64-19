package by.it.academy.scientific_activity.dao;

import by.it.academy.scientific_activity.entity.EmployeeCriteria;

import java.util.List;

public interface EmployeeDao {

    List<EmployeeCriteria> getAll();

    List<EmployeeCriteria> getByName(String name);

    List<EmployeeCriteria> getAllWithNameNotNull();

    List<EmployeeCriteria> getSalaryGraterThan(Double salary);

    List<EmployeeCriteria> getSalaryGraterThanOrderDesc(Double salary);

    List<EmployeeCriteria> getSalaryLessOrEqual(Double salary);

    List<EmployeeCriteria> getByAgeBetween(Integer from, Integer to);

    List<EmployeeCriteria> getByAgeAndName(String name, Integer age);

    List<EmployeeCriteria> getByAgeOrName(String name, Integer age);

    long getEmployeeCount();

    Double getAverageSalary();

    Double getMaxSalary();

    int getMinAge();

    Double getAverageSalaryByDep(Long depId);
}
