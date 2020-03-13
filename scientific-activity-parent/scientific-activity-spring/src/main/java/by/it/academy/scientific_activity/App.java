package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.entity.Department;
import by.it.academy.scientific_activity.entity.Employee;
import by.it.academy.scientific_activity.entity.EmployeeDetail;
import by.it.academy.scientific_activity.entity.Meeting;
import by.it.academy.scientific_activity.repository.DepartmentRepository;
import by.it.academy.scientific_activity.repository.EmployeeDetailRepository;
import by.it.academy.scientific_activity.repository.EmployeeRepository;
import by.it.academy.scientific_activity.repository.MeetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Slf4j
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        EmployeeDetailRepository employeeDetailRepository = context.getBean(EmployeeDetailRepository.class);
        MeetingRepository meetingRepository = context.getBean(MeetingRepository.class);

//        DepartmentService departmentService = context.getBean(DepartmentService.class);

        Department dev = new Department(null, "dev", new ArrayList<>());
        Department hr = new Department(null, "HR", new ArrayList<>());

        Employee ivan = new Employee(null, "Ivan", "Ivanov", LocalDateTime.now(), null, dev, new ArrayList<>());
        EmployeeDetail ivanDetail = new EmployeeDetail(null, "Minsk", "Belarus", null);

        Employee stepan = new Employee(null, "Stepan", "Stepanov", LocalDateTime.now(), null, dev, new ArrayList<>());
        EmployeeDetail stepanDetail = new EmployeeDetail(null, "Moscow", "Russia", null);

        Employee fedor = new Employee(null, "Fedor", "Fedorov", LocalDateTime.now(), null, hr, new ArrayList<>());
        EmployeeDetail fedorDetail = new EmployeeDetail(null, "Warsaw", "Poland", null);

        Meeting meeting1 = new Meeting(null, "Rammstein in JDBC", LocalDateTime.now().plusDays(2), new ArrayList<>());
        Meeting meeting2 = new Meeting(null, "Bob Marley as abstract class", LocalDateTime.now().plusDays(3), new ArrayList<>());

        dev.getEmployees().add(ivan);
        dev.getEmployees().add(stepan);
        hr.getEmployees().add(fedor);

        ivanDetail.setEmployee(ivan);
        stepanDetail.setEmployee(stepan);
        fedorDetail.setEmployee(fedor);

        ivan.setEmployeeDetail(ivanDetail);
        stepan.setEmployeeDetail(stepanDetail);
        fedor.setEmployeeDetail(fedorDetail);

        meeting1.getEmployees().add(ivan);
        meeting1.getEmployees().add(fedor);
        meeting2.getEmployees().add(stepan);

        ivan.getMeetings().add(meeting1);
        fedor.getMeetings().add(meeting1);
        stepan.getMeetings().add(meeting2);

        employeeRepository.save(ivan);
        employeeRepository.save(stepan);
        employeeRepository.save(fedor);

        meetingRepository.save(meeting1);
        meetingRepository.save(meeting2);

        employeeDetailRepository.save(ivanDetail);
        employeeDetailRepository.save(fedorDetail);
        employeeDetailRepository.save(stepanDetail);

        departmentRepository.save(dev);
        departmentRepository.save(hr);

        System.out.println(departmentRepository.findDepartmentByEmployeesContains(ivan));
    }
}
