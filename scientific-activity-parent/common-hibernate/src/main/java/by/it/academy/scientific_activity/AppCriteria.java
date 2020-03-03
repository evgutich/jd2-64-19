package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.dao.impl.EmployeeDaoImpl;
import by.it.academy.scientific_activity.entity.DepartmentCriteria;
import by.it.academy.scientific_activity.entity.DepartmentHQL;
import by.it.academy.scientific_activity.entity.EmployeeCriteria;
import by.it.academy.scientific_activity.entity.EmployeeHQL;
import by.it.academy.scientific_activity.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.ArrayList;

@Slf4j
public class AppCriteria {
    public static void main(String[] args) {

        EmployeeDaoImpl employeeDao = EmployeeDaoImpl.getInstance();

        DepartmentCriteria dev = new DepartmentCriteria(null, "Development", new ArrayList<>());
        DepartmentCriteria hr = new DepartmentCriteria(null, "hr", new ArrayList<>());

        EmployeeCriteria ivan = new EmployeeCriteria(null, "Ivan", 300.0, 23, dev);
        EmployeeCriteria stepan = new EmployeeCriteria(null, "Stepan", 400.0, 25, dev);
        EmployeeCriteria volodia = new EmployeeCriteria(null, "Volodia", 200.0, 21, hr);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(ivan);
        session.save(stepan);
        session.save(volodia);
        session.save(dev);
        session.save(hr);

        session.getTransaction().commit();
        session.close();

        log.info(employeeDao.getAllWithNameNotNull().toString());
        log.info(employeeDao.getByName("Ivan").toString());
        log.info(employeeDao.getSalaryGraterThan(250.0).toString());
        log.info(employeeDao.getSalaryGraterThanOrderDesc(250.0).toString());
        log.info(employeeDao.getByAgeBetween(24, 28).toString());
        log.info("count: " + employeeDao.getEmployeeCount());
        log.info("avg: " + employeeDao.getAverageSalary());
        log.info("max salary: " + employeeDao.getMaxSalary());
        log.info("min age: " + employeeDao.getMinAge());
        log.info("avg salary by dep: " + employeeDao.getAverageSalaryByDep(4L));

    }
}
