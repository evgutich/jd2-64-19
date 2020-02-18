package by.it.academy.scientific_activity.dao.impl;

import by.it.academy.scientific_activity.dao.EmployeeDao;
import by.it.academy.scientific_activity.entity.EmployeeHQL;
import by.it.academy.scientific_activity.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    public static EmployeeDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<EmployeeHQL> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("from EmployeeHQL", EmployeeHQL.class);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.name =: name", EmployeeHQL.class);
        query.setParameter("name", name);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getAllWithNameNotNull() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.name is not null", EmployeeHQL.class);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getSalaryGraterThan(Double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.salary >: salary", EmployeeHQL.class);
        query.setParameter("salary", salary);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getSalaryGraterThanOrderDesc(Double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.salary >: salary order by e.salary desc", EmployeeHQL.class);
        query.setParameter("salary", salary);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getSalaryLessOrEqual(Double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.salary <=: salary", EmployeeHQL.class);
        query.setParameter("salary", salary);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getByAgeBetween(Integer from, Integer to) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.age >=: from and e.age <=: to", EmployeeHQL.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getByAgeAndName(String name, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.name =: name and e.age =: age", EmployeeHQL.class);
        query.setParameter("name", name);
        query.setParameter("age", age);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeHQL> getByAgeOrName(String name, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<EmployeeHQL> query = session.createQuery("select e from EmployeeHQL e where e.name =: name or e.age =: age", EmployeeHQL.class);
        query.setParameter("name", name);
        query.setParameter("age", age);
        List<EmployeeHQL> employees = query.list();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Long> query = session.createQuery("select count(e) from EmployeeHQL e", Long.class);
        Long count = query.getSingleResult();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Double> query = session.createQuery("select avg(e.salary) from EmployeeHQL e", Double.class);
        Double avg = query.getSingleResult();
        return avg;
    }

    @Override
    public Double getMaxSalary() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Double> query = session.createQuery("select max(e.salary) from EmployeeHQL e", Double.class);
        Double maxSalary = query.getSingleResult();
        return maxSalary;
    }

    @Override
    public int getMinAge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Integer> query = session.createQuery("select min (e.age) from EmployeeHQL e", Integer.class);
        Integer minAge = query.getSingleResult();
        return minAge;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Double> query = session.createQuery("select avg (e.salary) from EmployeeHQL e where e.department.id = : depId", Double.class);
        query.setParameter("depId", depId);
        Double minAge = query.getSingleResult();
        return minAge;
    }
}
