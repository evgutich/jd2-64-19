package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.dao.impl.EmployeeDaoImpl;
import by.it.academy.scientific_activity.entity.DepartmentHQL;
import by.it.academy.scientific_activity.entity.EmployeeHQL;
import by.it.academy.scientific_activity.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.ArrayList;

@Slf4j
public class AppHQL {
    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = EmployeeDaoImpl.getInstance();

        DepartmentHQL dev = new DepartmentHQL(null, "Development", new ArrayList<>());
        DepartmentHQL hr = new DepartmentHQL(null, "hr", new ArrayList<>());

        EmployeeHQL ivan = new EmployeeHQL(null, "Ivan", 300.0, 23, dev);
        EmployeeHQL stepan = new EmployeeHQL(null, "Stepan", 400.0, 25, dev);
        EmployeeHQL volodia = new EmployeeHQL(null, "Volodia", 200.0, 21, hr);

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
