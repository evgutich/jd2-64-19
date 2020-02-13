package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.entity.Department;
import by.it.academy.scientific_activity.entity.Employee;
import by.it.academy.scientific_activity.entity.EmployeeDetail;
import by.it.academy.scientific_activity.entity.Meeting;
import by.it.academy.scientific_activity.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.HashSet;

@Slf4j
public class App {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = new Employee(null, "Ivan", "Ivanov", LocalDateTime.now(), null, null, new HashSet<>());

        EmployeeDetail detail = new EmployeeDetail(null, "street", "city", "country", null);
        e.setEmployeeDetail(detail);
        detail.setEmployee(e);
        session.save(e);
        log.info(e.toString());

        Department department = new Department(null, "Dev", new HashSet<>());
        e.setDepartment(department);
        session.save(e);
        session.save(department);
        log.info(e.toString());

        Meeting meeting = new Meeting(null, "Java EE", LocalDateTime.now(), new HashSet<>());
        e.getMeetingList().add(meeting);
        meeting.getEmployees().add(e);
        session.saveOrUpdate(e);
        session.save(meeting);
        log.info(e.toString());

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutDown();
    }
}
