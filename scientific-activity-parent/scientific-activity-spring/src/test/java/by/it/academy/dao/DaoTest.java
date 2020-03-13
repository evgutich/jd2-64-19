package by.it.academy.dao;

import by.it.academy.scientific_activity.dao.impl.EmployeeDaoImpl;
import by.it.academy.scientific_activity.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-dao.xml")
public class DaoTest {
    @Autowired
    private EmployeeDaoImpl employeeDao;
    @Test
    public void createEmployee() {
        Employee e = new Employee();
        e.setFirstName("Ivan");
        e.setLastName("Ivanov");
        e = employeeDao.add(e);
        Assert.assertEquals("Ivan", employeeDao.read(e.getId()).getFirstName());
    }
}
