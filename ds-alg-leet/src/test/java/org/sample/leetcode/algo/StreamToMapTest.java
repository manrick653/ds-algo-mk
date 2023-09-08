package org.sample.leetcode.algo;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamToMapTest {

  @Test
  void when_string_to_frequncy_greaterThan_three_Test(){
    String givenString = "manish kumar is good boy, manish kumar manish kumar 123";
    Function<String,String> keyMapper = e -> {if(e.charAt(e.length()-1)==','){
      return e.subSequence(0,e.length()-1).toString();
    }else{
      return e ;
    }
    };
    Function<String,Integer> valueMapper = e -> 1;

    Map<String,Integer> keyToCount = Arrays.stream(givenString.split(" ")).
        collect(Collectors.toMap(keyMapper,valueMapper, Integer::sum)) ;
    Map<String,Integer> filteredKeyToCount = keyToCount.entrySet().stream().filter(e -> e.getValue()>=3).collect(
        Collectors.toMap(Entry::getKey, Entry::getValue));

    Map<String,Integer> expectedMap = new HashMap<>();
    expectedMap.put("manish",3);
    expectedMap.put("kumar",3);
    Assertions.assertTrue(filteredKeyToCount.keySet().containsAll(expectedMap.keySet()));
  }

  @Test
  void when_streamOfInteger_find_max(){

    System.out.println(Stream.of(1, 3, 7, 10, 36, 25).max(Comparator.comparingInt(n -> n)).get());
    System.out.println(Stream.of(1, 3, 7, 10, 36, 25).max(Comparator.comparingInt(n -> n)));

  }

  @Test
  void groupByTest(){
    Employee employee1 = new Employee("x",34,"sales");
    Employee employee2 = new Employee("y",39,"sales");
    Employee employee3 = new Employee("z",30,"marketing");
    Employee employee5 = new Employee("z",30,"finance");

    Collector<Employee, ?, Integer> summingSalaries
        = Collectors.summingInt(Employee::getSalary) ;

    Collector<Employee, ?, Map<String, Integer>> summingSalariesByDept
        = Collectors.groupingBy(Employee::getDepartment, summingSalaries);
    System.out.println(summingSalariesByDept);
    Integer salarySum = Stream.of(employee1,employee2,employee3,employee5).collect(summingSalaries);

    System.out.println(salarySum);

    Map<String, Integer> map = Stream.of(employee1,employee2,employee3,employee5).collect(summingSalariesByDept);
    System.out.println(map);
    Stream<Employee> streamOfEmployee =  Stream.of(employee1,employee2,employee3,employee5) ;

    double averageSalary =  streamOfEmployee.collect(Collectors.averagingDouble(e -> e.salary));
    System.out.println("average salary "+averageSalary);
    Stream<Employee> streamOfEmployee2 =  Stream.of(employee1,employee2,employee3,employee5) ;
    Map<String,Double> averageSalaryByDept = streamOfEmployee2.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(e -> e.salary)));
    System.out.println("avg salary by dept id "+averageSalaryByDept);
    Stream<Employee> streamOfEmployee3 =  Stream.of(employee1,employee2,employee3,employee5) ;
    Map<String,Optional<StreamToMapTest.Employee>> maxSalaryByDept = streamOfEmployee3.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary()))));
    System.out.println("maxSalaryByDept "+ maxSalaryByDept);
    for(Entry<String,Optional<StreamToMapTest.Employee>> entry :maxSalaryByDept.entrySet()){
      Optional<StreamToMapTest.Employee> val = entry.getValue() ;
      System.out.println("key"+entry.getKey()+":: "+val.get().salary);
    }


  }
  @Test
  void whenAsListIsModified(){

    List<Integer> integers = Arrays.asList(1,2,3,4);
    List<Integer> k = integers ;
    k.add(5);
  }
  @Test
   void gotIsPreset(){

    Optional got = Optional.of("manish");
    String [] str = new String[10];
    Optional strOpt = Optional.ofNullable(str[9]);
    System.out.println(strOpt.isPresent());
    System.out.println(got.isPresent());

  }
  class Employee{
    String name ;
    Integer salary ;
    String department ;

    public Employee(String name, Integer salary,String department) {
      this.name = name;
      this.salary = salary;
      this.department = department;
    }

    public String getName() {
      return name;
    }

    public Integer getSalary() {
      return salary;
    }

    public String getDepartment() {
      return department;
    }
  }
}
