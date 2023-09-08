package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public void EmployeeStream() {
    System.out.println("Hello world!");

    List<Employee> employees = new ArrayList<>();
    Employee employee1 = new Employee("1",2000d);
    Employee employee2 = new Employee("1",3000d);

    employees.add(employee1);
    employees.add(employee2);
    Double averageSalary = employees.stream().collect(Collectors.averagingDouble(e -> e.salary)).doubleValue();
   List<Employee> employeeSalaryMoreThanAvg = employees.stream().filter(e-> e.salary > averageSalary).collect(Collectors.toList());




  }

  class Employee
  {

    private String id ;
    private double salary ;

    public Employee(String id, double salary) {
      this.id = id;
      this.salary = salary;
    }
  }
}