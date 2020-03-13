package by.it.academy.scientific_activity.dao.impl;

import by.it.academy.scientific_activity.dao.BaseDao;
import by.it.academy.scientific_activity.dao.EmployeeDao;
import by.it.academy.scientific_activity.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

}
