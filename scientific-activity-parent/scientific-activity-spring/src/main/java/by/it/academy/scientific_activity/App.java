package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.entity.Department;
import by.it.academy.scientific_activity.entity.Employee;
import by.it.academy.scientific_activity.entity.EmployeeDetail;
import by.it.academy.scientific_activity.entity.Meeting;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Slf4j
public class App {
    public static void main(String[] args) {

    }
        Department dev = new Department("dev");
        Department hr = new Department("HR");

        Employee ivan = new Employee(null, "Ivan", "Ivanov", LocalDateTime.now(), null, dev, new ArrayList<>());
        EmployeeDetail ivanDetail = new EmployeeDetail(null, "Minsk", "Belarus", null);

        Employee stepan = new Employee(null, "Stepan", "Stepanov", LocalDateTime.now(), null, dev, new ArrayList<>());
        EmployeeDetail stepanDetail = new EmployeeDetail(null, "Moscow", "Russia", null);

        Employee fedor = new Employee(null, "Fedor", "Fedorov", LocalDateTime.now(), null, hr, new ArrayList<>());
        EmployeeDetail fedorDetail = new EmployeeDetail(null, "Warsaw", "Poland", null);

        Meeting meeting1 = new Meeting(null, "Rammstein in JDBC", LocalDateTime.now().plusDays(2), new ArrayList<>());
        Meeting meeting2 = new Meeting(null, "Bob Marley as abstract class", LocalDateTime.now().plusDays(3), new ArrayList<>());


    }
