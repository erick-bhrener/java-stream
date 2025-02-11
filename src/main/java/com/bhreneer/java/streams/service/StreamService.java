package com.bhreneer.java.streams.service;

import com.bhreneer.java.streams.domain.Employee;
import com.bhreneer.java.streams.util.PrintUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StreamService {

    public Map<String, List<Employee>> groupEmployeesByCity(List<Employee> list) {
        Map<String, List<Employee>> mapCity = list.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("#> Employees by city: \n" + mapCity);

        return mapCity;
    }

    public Map<Integer, List<Employee>> groupEmployeesByAge(List<Employee> list) {
        Map<Integer, List<Employee>> mapAge = list.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("#> Employees by age: \n" + mapAge);
        return mapAge;
    }

    public Map<String, Long> countEmployeesByGender(List<Employee> list) {
        Map<String, Long> mapByGender = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("#> Count employees by gender: " + mapByGender);
        return mapByGender;
    }

    public List<String> printAllDepartments(List<Employee> list) {
        List<String> listOfDepartments = list.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        System.out.println("#> List of departments: ");
        listOfDepartments.forEach(System.out::println);
        return listOfDepartments;
    }

    public List<Employee> findEmployeesOlderThan28(List<Employee> list) {
        System.out.println("#> Employees older than 28: ");
        List<Employee> listEmployee = list.stream().filter(employee -> employee.getAge() > 28).collect(Collectors.toList());
        listEmployee.forEach(System.out::println);
        return listEmployee;
    }

    public OptionalInt findMaxAge(List<Employee> list) {
        OptionalInt age = list.stream().mapToInt(Employee::getAge).max();
        if(age.isPresent())
            System.out.println("#> Max age: " + age.getAsInt());
        return age;
    }

    public Map<String, Double> findAverageAgeByGender(List<Employee> list) {
        Map<String, Double> mapAvg = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("#> Average age by gender: "+ System.lineSeparator() + mapAvg);
        return mapAvg;
    }

    public Map<String, Long> findNumberOfEmployeesByDepartment(List<Employee> list) {
        Map<String, Long> mapCount = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("#> Number of employees by department: "+ System.lineSeparator() + mapCount);
        return mapCount;
    }

    public Optional<Employee> findOldestEmployee(List<Employee> list) {
        Optional<Employee> oldestEmployee = list.stream().max(Comparator.comparingInt(Employee::getAge));
        oldestEmployee.ifPresent(employee -> System.out.println("#> Oldest employee: " + System.lineSeparator() + employee));
        return oldestEmployee;
    }

    public Optional<Employee> findYoungestFemale(List<Employee> list) {
        Optional<Employee> youngestEmployee = list.stream().filter(employee -> employee.getGender().equals("F")).min(Comparator.comparingInt(Employee::getAge));
        youngestEmployee.ifPresent(employee -> System.out.println("#> Youngest female employee: " + System.lineSeparator() + employee));
        return  youngestEmployee;
    }

    public Map<Boolean, List<Employee>> findEmployeesWithAgeGreaterOrLessThan30(List<Employee> list) {
        Map<Boolean, List<Employee>> mapEmployees = list.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 30));
        mapEmployees.keySet().forEach(key -> {
            if(Boolean.TRUE.equals(key)) {
                System.out.println("#> Employees older than 30: " + System.lineSeparator() + mapEmployees.get(true));
            } else {
                System.out.println("#> Employees with less than 30: " + System.lineSeparator() + mapEmployees.get(key));
            }
        });

        return mapEmployees;
    }

    public Map.Entry<String, Long> findDepartmentWithMoreEmployees(List<Employee> list) {
        Map.Entry<String, Long> mapDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("#> Department with more employees: " + mapDepartment.getKey());
        return mapDepartment;
    }

    public Optional<Employee> findAnyEmployeeFromHR(List<Employee> list) {
        Optional<Employee> employeeFromHR = list.stream().filter(employee -> employee.getDeptName().equals("HR")).findAny();
        employeeFromHR.ifPresent(employee -> System.out.println("#> Employee from HR: " + System.lineSeparator() + employee));

        return employeeFromHR;
    }

    public List<String> findDepartmentWithMoreThan3Employees(List<Employee> list) {
        List<String> listDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 3).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("#> List of departments with more than 3 employees: ");
        listDepartment.forEach(System.out::println);
        return listDepartment;
    }

    public List<String> listDepartmentDistinct(List<Employee> list) {
        List<String> listOfDepartment = list.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        System.out.println("#> List of departments: ");
        listOfDepartment.forEach(System.out::println);
        return listOfDepartment;
    }

    public List<String> printEmployeesFromCityOrdered(List<Employee> list, String city) {
        List<String> listEmployeeFromCity = list.stream()
                .filter(employee -> employee.getCity().equals(city))
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("#> Employees from " + city + ":");
        listEmployeeFromCity.forEach(System.out::println);
        return listEmployeeFromCity;
    }

    public long countTotalEmployees(List<Employee> list) {
        long totalEmployee = list.stream().count();
        System.out.println("#> Total employees: " + totalEmployee);
        return totalEmployee;
    }

    public Map<String, Long> countEmployeesByDepartment(List<Employee> list) {
        Map<String, Long> mapDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("#> Number of employees by department: " + System.lineSeparator() + mapDepartment);
        return mapDepartment;
    }

    public Optional<Map.Entry<String, Long>> findDepartmentWithMostEmployees(List<Employee> list) {
        Optional<Map.Entry<String, Long>> mapDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        mapDepartment.ifPresent(entry -> System.out.println("#> Department with most employees: " + entry.getKey()));
        return mapDepartment;
    }

    public List<Employee> listEmployeeSortedByAgeAndName(List<Employee> list) {
        Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge);
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        List<Employee> listOrdered = list.stream()
                .sorted(ageComparator.thenComparing(nameComparator))
                .collect(Collectors.toList());
        System.out.println("#> Employess ordered by age, then name: ");
        listOrdered.forEach(System.out::println);
        return listOrdered;
    }

    public Optional<Employee> findTheMostExperiencedEmployee(List<Employee> list) {
        Optional<Employee> mostExperienced = list.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        mostExperienced.ifPresent(employee ->
                System.out.println("#> Most experienced employee: " + System.lineSeparator() + employee)
        );
        return mostExperienced;
    }

    public Optional<Employee> findTheMostExperiencedEmployeeV2(List<Employee> list) {
        Optional<Employee> mostExperienced = list.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
        mostExperienced.ifPresent(employee ->
                System.out.println("#> Most experienced employee V2: " + System.lineSeparator() + employee)
        );
        return mostExperienced;
    }

    public DoubleSummaryStatistics findAverageAndTotalSalary(List<Employee> list) {
        DoubleSummaryStatistics salaryStatistics = list.stream().collect(Collectors.summarizingDouble(Employee::getYearOfJoining));

        System.out.println("#> Average salary: " + PrintUtils.formatDouble(salaryStatistics.getAverage()));
        System.out.println("#> Total salary: " + salaryStatistics.getSum());
        return salaryStatistics;
    }

    public Map<String, Double> findAverageSalaryByDepartment(List<Employee> list) {
        Map<String, Double> mapSalary = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("#> Average salary by department: " + System.lineSeparator() + mapSalary);
        return mapSalary;
    }

    public Optional<Employee> findHighestSalary(List<Employee> list) {
        Optional<Employee> highestSalary = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
        highestSalary.ifPresent(employee -> System.out.println("#> Highest salary: " + System.lineSeparator() + employee));
        return highestSalary;
    }

    public Optional<Employee> findHighestSalaryV2(List<Employee> list) {
        Optional<Employee> employeeOptional = list.stream().max(Comparator.comparingDouble(Employee::getSalary));
        employeeOptional.ifPresent(employee -> System.out.println("#> Highest salary V2: " + System.lineSeparator() + employee));
        return employeeOptional;
    }

    public Optional<Employee> findSecondHighestSalary(List<Employee> list) {
        Optional<Employee> employeeOptional = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
        employeeOptional.ifPresent(employee -> System.out.println("#> Second highest salary: " + System.lineSeparator() + employee));
        return employeeOptional;
    }

    public Optional<Employee> findNthHighestSalary(List<Employee> list, int n) {
        Integer finalN = n;
        if(Integer.compare(finalN, list.size()) > 0) finalN = list.size();
        Optional<Employee> employeeOptional = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(finalN-1).findFirst();
        if(employeeOptional.isPresent()) {
            System.out.println("#> The " + finalN + "th highest salary: " + System.lineSeparator() + employeeOptional.get());
        }
        return employeeOptional;
    }

    public Map<String, Optional<Employee>> findHighestSalaryByGender(List<Employee> list) {
        Map<String, Optional<Employee>> mapSalaryByGender = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println("#> Highest salary by gender: " + System.lineSeparator() + mapSalaryByGender);
        return mapSalaryByGender;
    }

    public Map<String, Optional<Employee>> findLowestSalaryByGender(List<Employee> list) {
        Map<String, Optional<Employee>> mapSalaryByGender = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.minBy((e1,e2) -> (int) (e1.getSalary() - e2.getSalary()))));
        System.out.println("#> Lowest salary by gender: " + System.lineSeparator() + mapSalaryByGender);
        return mapSalaryByGender;
    }

    public List<Employee> listSalaryASC(List<Employee> list) {
        List<Employee> sortedASC = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
        System.out.println("#> Employees list ASC by Salary: ");
        sortedASC.forEach(System.out::println);
        return sortedASC;
    }

    public List<Employee> listSalaryDESC(List<Employee> list) {
        List<Employee> sortedDESC = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println("#> Employees list DESC by Salary: ");
        sortedDESC.forEach(System.out::println);
        return sortedDESC;
    }

    public Map<String, Optional<Employee>> findHighestSalaryByDepartment(List<Employee> list) {
        Map<String, Optional<Employee>> mapSalary = list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                empList -> empList.stream()
                                        .max(Comparator.comparingDouble(Employee::getSalary))
                        )
                )
        );
        System.out.println("#> Highest salary by department: " + System.lineSeparator() + mapSalary);
        return mapSalary;
    }

    public Map<String, List<Employee>> listEmployeeByDepartmentASC(List<Employee> list) {
        Map<String, List<Employee>> mapEmployeeASC = list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                empList -> empList.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary))
                                        .collect(Collectors.toList())
                        )
                ));
        System.out.println("#> Employees by department sorted by salary ASC: ");
        mapEmployeeASC.forEach((department, employees) -> {
            System.out.println(department);
            employees.forEach(System.out::println);
        });
        return mapEmployeeASC;
    }

    public Map<String, List<Employee>> listEmployeeByDepartmentDESC(List<Employee> list) {
        Map<String, List<Employee>> mapEmployeeDESC = list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                employees -> employees.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary))
                                        .collect(Collectors.toList()))
                )
        );
        System.out.println("#> Employees sorted by salary DESC by department: ");
        mapEmployeeDESC.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            employees.forEach(System.out::println);
        });
        return mapEmployeeDESC;
    }
}
