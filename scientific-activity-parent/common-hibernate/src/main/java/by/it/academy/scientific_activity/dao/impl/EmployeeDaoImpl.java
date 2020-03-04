package by.it.academy.scientific_activity.dao.impl;

import by.it.academy.scientific_activity.dao.EmployeeDao;
import by.it.academy.scientific_activity.entity.DepartmentCriteria;
import by.it.academy.scientific_activity.entity.EmployeeCriteria;
import by.it.academy.scientific_activity.entity.EmployeeHQL;
import by.it.academy.scientific_activity.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();


    public static EmployeeDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<EmployeeCriteria> getAll() {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root);
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByName(String name) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getAllWithNameNotNull() {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root).where(criteriaBuilder.isNotNull(root.get("name")));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryGraterThan(Double salary) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root).where(criteriaBuilder.gt(root.get("salary"), salary));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryGraterThanOrderDesc(Double salary) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root).where(criteriaBuilder.gt(root.get("salary"), salary)).orderBy(criteriaBuilder.desc(root.get("salary")));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryLessOrEqual(Double salary) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root).where(criteriaBuilder.le(root.get("salary"), salary));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeBetween(Integer from, Integer to) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root).where(criteriaBuilder.between(root.get("age"), from, to));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeAndName(String name, Integer age) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), name), criteriaBuilder.equal(root.get("age"), age));
        query.select(root).where(predicate);
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeOrName(String name, Integer age) {
        CriteriaQuery<EmployeeCriteria> query = criteriaBuilder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        Predicate predicate = criteriaBuilder.or(criteriaBuilder.equal(root.get("name"), name), criteriaBuilder.equal(root.get("age"), age));
        query.select(root).where(predicate);
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        query.select(criteriaBuilder.count(query.from(EmployeeCriteria.class)));
        long count = sessionFactory.openSession().createQuery(query).getSingleResult();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        query.select(criteriaBuilder.avg(query.from(EmployeeCriteria.class).get("salary")));
        Double avgSalary = sessionFactory.openSession().createQuery(query).getSingleResult();
        return avgSalary;
    }

    @Override
    public Double getMaxSalary() {
        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        query.select(criteriaBuilder.max(query.from(EmployeeCriteria.class).get("salary")));
        Double maxSalary = sessionFactory.openSession().createQuery(query).getSingleResult();
        return maxSalary;
    }

    @Override
    public int getMinAge() {
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        query.select(criteriaBuilder.min(query.from(EmployeeCriteria.class).get("age")));
        Integer minAge = sessionFactory.openSession().createQuery(query).getSingleResult();
        return minAge;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        Root<EmployeeCriteria> employee = query.from(EmployeeCriteria.class);

        Join<EmployeeCriteria, DepartmentCriteria> employeeJoin = employee.join("department", JoinType.INNER);
        query.select(criteriaBuilder.avg(employee.get("salary"))).where(criteriaBuilder.equal(employeeJoin.get("id"), depId));
        Double minAge = sessionFactory.openSession().createQuery(query).getSingleResult();
        return minAge;
    }
}
