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
        System.out.println(System.lineSeparator());
        streamService.groupEmployeesByCity(empList);
        System.out.println(System.lineSeparator());
        streamService.groupEmployeesByAge(empList);
        System.out.println(System.lineSeparator());
        streamService.countEmployeesByGender(empList);
        System.out.println(System.lineSeparator());
        streamService.printAllDepartments(empList);
        System.out.println(System.lineSeparator());
        streamService.findEmployeesOlderThan28(empList);
        System.out.println(System.lineSeparator());
        streamService.findMaxAge(empList);
        System.out.println(System.lineSeparator());
        streamService.findAverageAgeByGender(empList);
        System.out.println(System.lineSeparator());
        streamService.findNumberOfEmployeesByDepartment(empList);
        System.out.println(System.lineSeparator());
        streamService.findOldestEmployee(empList);
        System.out.println(System.lineSeparator());
        streamService.findYoungestFemale(empList);
        System.out.println(System.lineSeparator());
        streamService.findEmployeesWithAgeGreaterOrLessThan30(empList);
        System.out.println(System.lineSeparator());
        streamService.findDepartmentWithMoreEmployees(empList);
        System.out.println(System.lineSeparator());
        streamService.findAnyEmployeeFromHR(empList);
        System.out.println(System.lineSeparator());
        streamService.findDepartmentWithMoreThan3Employees(empList);
        System.out.println(System.lineSeparator());
        streamService.listDepartmentDistinct(empList);
        System.out.println(System.lineSeparator());
        streamService.printEmployeesFromCityOrdered(empList,"Blore");
        System.out.println(System.lineSeparator());
        streamService.countTotalEmployees(empList);
        System.out.println(System.lineSeparator());
        streamService.countEmployeesByDepartment(empList);
        System.out.println(System.lineSeparator());
        streamService.findDepartmentWithMostEmployees(empList);
        System.out.println(System.lineSeparator());
        streamService.listEmployeeSortedByAgeAndName(empList);
        System.out.println(System.lineSeparator());
        streamService.findTheMostExperiencedEmployee(empList);
        streamService.findTheMostExperiencedEmployeeV2(empList);
        System.out.println(System.lineSeparator());
        streamService.findAverageAndTotalSalary(empList);
        System.out.println(System.lineSeparator());
        streamService.findAverageSalaryByDepartment(empList);
        System.out.println(System.lineSeparator());
        streamService.findHighestSalary(empList);
        streamService.findHighestSalaryV2(empList);
        System.out.println(System.lineSeparator());
        streamService.findSecondHighestSalary(empList);
        System.out.println(System.lineSeparator());
        streamService.findNthHighestSalary(empList, 10);
        System.out.println(System.lineSeparator());
        streamService.findHighestSalaryByGender(empList);
        System.out.println(System.lineSeparator());
        streamService.findLowestSalaryByGender(empList);
        System.out.println(System.lineSeparator());
        streamService.listSalaryASC(empList);
        System.out.println(System.lineSeparator());
        streamService.listSalaryDESC(empList);
        System.out.println(System.lineSeparator());
        streamService.findHighestSalaryByDepartment(empList);
        System.out.println(System.lineSeparator());
        streamService.listEmployeeByDepartmentASC(empList);
        System.out.println(System.lineSeparator());
        streamService.listEmployeeByDepartmentDESC(empList);
    }
}
