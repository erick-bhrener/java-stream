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
        System.out.println("#> Oldest employee: " + System.lineSeparator() + oldestEmployee.get());
    }

    public void findYoungestFemale(List<Employee> list) {
        Optional<Employee> youngestEmploee = list.stream().filter(employee -> employee.getGender().equals("F")).min(Comparator.comparingInt(Employee::getAge));
        System.out.println("#> Youngest female employee: " + System.lineSeparator() + youngestEmploee.get());
    }
}
