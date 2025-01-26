package com.bhreneer.java.streams.service;

import com.bhreneer.java.streams.domain.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamService {

    public void groupEmployeesByCity(List<Employee> list) {
        Map<String, List<Employee>> mapCity = list.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("#> Employees by city: \n" + mapCity);
    }

    public void groupEmployeesByAge(List<Employee> list) {
        Map<Integer, List<Employee>> mapAge = list.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("#> Employees by age: \n" + mapAge);
    }

    public void countEmployeesByGender(List<Employee> list) {
        Map<String, Long> mapByGender = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("#> Count employees by gender: " + mapByGender);
    }

    public void printAllDepartments(List<Employee> list) {
        List<String> listOfDepartments = list.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        System.out.println("#> List of departments: ");
        listOfDepartments.forEach(System.out::println);
    }

    public void findEmployeesOlderThan28(List<Employee> list) {
        System.out.println("#> Employees older than 28: ");
        list.stream().filter(employee -> employee.getAge() > 28).forEach(System.out::println);
    }

    public void findMaxAge(List<Employee> list) {
        OptionalInt age = list.stream().mapToInt(Employee::getAge).max();
        if(age.isPresent())
            System.out.println("#> Max age: " + age.getAsInt());
    }

    public void findAverageAgeByGender(List<Employee> list) {
        Map<String, Double> mapAvg = list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("#> Average age by gender: "+ System.lineSeparator() + mapAvg);
    }

    public void findNumberOfEmployeesByDepartment(List<Employee> list) {
        Map<String, Long> mapCount = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("#> Number of employees by department: "+ System.lineSeparator() + mapCount);
    }

    public void findOldestEmployee(List<Employee> list) {
        Optional<Employee> oldestEmployee = list.stream().max(Comparator.comparingInt(Employee::getAge));
        oldestEmployee.ifPresent(employee -> System.out.println("#> Oldest employee: " + System.lineSeparator() + employee));
    }

    public void findYoungestFemale(List<Employee> list) {
        Optional<Employee> youngestEmployee = list.stream().filter(employee -> employee.getGender().equals("F")).min(Comparator.comparingInt(Employee::getAge));
        youngestEmployee.ifPresent(employee -> System.out.println("#> Youngest female employee: " + System.lineSeparator() + employee));
    }

    public void findEmployeesWithAgeGreaterOrLessThan30(List<Employee> list) {
        Map<Boolean, List<Employee>> mapEmployees = list.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 30));
        mapEmployees.keySet().forEach(key -> {
            if(Boolean.TRUE.equals(key)) {
                System.out.println("#> Employees older than 30: " + System.lineSeparator() + mapEmployees.get(true));
            } else {
                System.out.println("#> Employees with less than 30: " + System.lineSeparator() + mapEmployees.get(key));
            }
        });
    }

    public void findDepartmentWithMoreEmployees(List<Employee> list) {
        Map.Entry<String, Long> mapDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("#> Department with more employees: " + mapDepartment.getKey());
    }

    public void findAnyEmployeeFromHR(List<Employee> list) {
        Optional<Employee> employeeFromHR = list.stream().filter(employee -> employee.getDeptName().equals("HR")).findAny();
        employeeFromHR.ifPresent(employee -> System.out.println("#> Employee from HR: " + System.lineSeparator() + employee));
    }

    public void findDepartmentWithMoreThan3Employees(List<Employee> list) {
        List<String> listDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 3).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("#> List of departments with more than 3 employees: ");
        listDepartment.forEach(System.out::println);
    }

    public void listDepartmentDistinct(List<Employee> list) {
        List<String> listOfDepartment = list.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        System.out.println("#> List of departments: ");
        listOfDepartment.forEach(System.out::println);
    }

    public void printEmployeesFromCityOrdered(List<Employee> list, String city) {
        List<String> listEmployeeFromCity = list.stream()
                .filter(employee -> employee.getCity().equals(city))
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("#> Employees from " + city + ":");
        listEmployeeFromCity.forEach(System.out::println);
    }

    public void countTotalEmployees(List<Employee> list) {
        long totalEmployee = list.stream().count();
        System.out.println("#> Total employees: " + totalEmployee);
    }

    public void countEmployeesByDepartment(List<Employee> list) {
        Map<String, Long> mapDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("#> Number of employees by department: " + System.lineSeparator() + mapDepartment);
    }

    public void findDepartmentWithMostEmployees(List<Employee> list) {
        Optional<Map.Entry<String, Long>> mapDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        mapDepartment.ifPresent(entry -> System.out.println("#> Department with most employees: " + entry.getKey()));
    }

    public void listEmployeeSortedByAgeAndName(List<Employee> list) {
        Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge);
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        List<Employee> listOrdered = list.stream()
                .sorted(ageComparator.thenComparing(nameComparator))
                .collect(Collectors.toList());
        System.out.println("#> Employess ordered by age, then name: ");
        listOrdered.forEach(System.out::println);
    }
}
