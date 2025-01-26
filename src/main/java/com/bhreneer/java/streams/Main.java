package com.bhreneer.java.streams;

import com.bhreneer.java.streams.domain.Employee;
import com.bhreneer.java.streams.service.StreamService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java Streams Examples");

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123L, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120L, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115L, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125L, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150L, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140L, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130L, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145L, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160L, "M", "IT", "Blore", 2010));

        StreamService streamService = new StreamService();
        streamService.groupEmployeesByCity(empList);
        streamService.groupEmployeesByAge(empList);
        streamService.countEmployeesByGender(empList);
        streamService.printAllDepartments(empList);
        streamService.findEmployeesOlderThan28(empList);
        streamService.findMaxAge(empList);
        streamService.findAverageAgeByGender(empList);
        streamService.findNumberOfEmployeesByDepartment(empList);
        streamService.findOldestEmployee(empList);
        streamService.findYoungestFemale(empList);

    }
}
