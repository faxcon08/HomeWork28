package ru.skypro.lesson_28;
import ru.skypro.lesson_28.DAO.EmployeeDAO;
import ru.skypro.lesson_28.DAO.EmployeeDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        System.out.println("-----------First Task---------------");
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee testEmployee = new Employee("Sergeeva", "Nataliy", 19, "female", 1);
        employeeDAO.addEmployee(testEmployee);
        int id = +employeeDAO.getIDbyEmployee(testEmployee);
        System.out.println("Add new Employee with ID="+id);
        System.out.println("----- ALL Employees -----");
        employeeDAO.printAllEmployees();
        System.out.println("------ Empoyee with ID = "+id+" -------");
        Optional<Employee> employee = employeeDAO.getEmployeeByID(id);
        System.out.println(employee);
        Employee updatedTestEmployee = new Employee(id, "Tihonova", "Elena", 27, "female", 2);
        System.out.println("------ Updated Employee with ID = "+id+"-----");
        employeeDAO.updateEmployee(updatedTestEmployee);
        System.out.println(employeeDAO.getEmployeeByID(id));
        System.out.println("----- REMOVE Empoyee with ID = "+id+"-------");
        employeeDAO.deleteEmployee(updatedTestEmployee);
        System.out.println("----- ALL Employees -----");
        employeeDAO.printAllEmployees();

    }
}
