package by.it.academy.scientific_activity.dao;

import by.it.academy.scientific_activity.entity.EmployeeHQL;

import java.util.List;

public interface EmployeeDao {

    List<EmployeeHQL> getAll();

    List<EmployeeHQL> getByName(String name);

    List<EmployeeHQL> getAllWithNameNotNull();

    List<EmployeeHQL> getSalaryGraterThan(Double salary);

    List<EmployeeHQL> getSalaryGraterThanOrderDesc(Double salary);

    List<EmployeeHQL> getSalaryLessOrEqual(Double salary);

    List<EmployeeHQL> getByAgeBetween(Integer from, Integer to);

    List<EmployeeHQL> getByAgeAndName(String name, Integer age);

    List<EmployeeHQL> getByAgeOrName(String name, Integer age);

    long getEmployeeCount();

    Double getAverageSalary();

    Double getMaxSalary();

    int getMinAge();

    Double getAverageSalaryByDep(Long depId);
}
