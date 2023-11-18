package organization;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Nurasyl", "Sakayev");
        Employee employee2 = new Employee("Askar", "Kazihan");
        System.out.println(employee1.getSurname());
        System.out.println(employee2.getName());
        employee1.setSalary(250000);
        employee1.setPosition("Junior");
        employee2.setSalary(560000);
        employee2.setPosition("Strong Middle");

        Department department = new Department("Backend department");
        department.acceptEmployee(employee1);
        department.acceptEmployee(employee2);
        System.out.println(department.getDepartmentName());
        System.out.println(department.numberOfEmployees());
        department.pointsToEmployee("Nurasyl", "Sakayev");
        System.out.println(department.totalSalary());
        department.dismissEmployee("Nurasyl", "Sakayev", "Junior");
        System.out.println(department.numberOfEmployees());
        Employee[] employees = department.getAll();
        for(Employee employee: employees){
            System.out.println(employee);
        }
       // System.out.println(Arrays.toString(employees));
        Employee[] employees1 = department.getSorted();
        for(Employee employee:employees1){
            System.out.println(employee);
        }
    }
}
