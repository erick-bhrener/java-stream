package com.bhreneer.java.streams.service;

import com.bhreneer.java.streams.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamServiceTest {

    private List<Employee> empList;

    private StreamService streamService;

    @BeforeEach
    void setUp() {
        empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123L, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120L, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115L, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125L, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150L, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140L, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130L, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145L, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160L, "M", "IT", "Blore", 2010));

        streamService = new StreamService();
    }

    //    streamService.groupEmployeesByCity(empList);
    @Test
    void testGroupEmployeesByCity() {
        Map<String, List<Employee>> mapCity = streamService.groupEmployeesByCity(empList);
        assertEquals(7, mapCity.keySet().size());
        assertEquals(2, mapCity.get("Blore").size());
        assertEquals(1, mapCity.get("Pune").size());
    }
//    streamService.groupEmployeesByAge(empList);
    @Test
    void testGroupEmployeesByAge() {
        Map<Integer, List<Employee>> mapAge = streamService.groupEmployeesByAge(empList);
        assertEquals(9, mapAge.keySet().size());
    }
//    streamService.countEmployeesByGender(empList);
    @Test
    void testCountEmployeesByGender(){
        Map<String, Long> mapByGender = streamService.countEmployeesByGender(empList);
        assertEquals(2, mapByGender.keySet().size());
        assertEquals(5, mapByGender.get("F"));
        assertEquals(4, mapByGender.get("M"));
    }
    //    streamService.printAllDepartments(empList);
    @Test
    void testListAllDepartments(){
        List<String> listOfDepartments = streamService.printAllDepartments(empList);
        assertEquals(2, listOfDepartments.size(), "Total number of departments.");
        assertTrue(listOfDepartments.contains("IT"));
        assertTrue(listOfDepartments.contains("HR"));
    }
//    streamService.findEmployeesOlderThan28(empList);
    @Test
    void testFindEmployeesOlderThan28() {
        List<Employee> listEmployee = streamService.findEmployeesOlderThan28(empList);
        assertEquals(3, listEmployee.size());
        assertTrue(listEmployee.stream().anyMatch(employee -> employee.getName().equalsIgnoreCase("xyz")));
        assertTrue(listEmployee.stream().noneMatch(employee -> employee.getName().equalsIgnoreCase("abc")));
    }
//    streamService.findMaxAge(empList);
    @Test
    void testFindMaxAge() {
        OptionalInt age = streamService.findMaxAge(empList);
        assertTrue(age.isPresent());
        assertEquals(32, age.getAsInt());
    }
//    streamService.findAverageAgeByGender(empList);
    @Test
    void testFindAverageAgeByGender(){
        Map<String, Double> mapAvg = streamService.findAverageAgeByGender(empList);
        assertEquals(2, mapAvg.keySet().size());
        assertEquals(27.4, mapAvg.get("F"));
        assertEquals(26.25, mapAvg.get("M"));
    }
//    streamService.findNumberOfEmployeesByDepartment(empList);
    @Test
    void testFindNumberOfEmployeesByDepartment() {
        Map<String, Long> mapCount = streamService.findNumberOfEmployeesByDepartment(empList);
        assertEquals(2, mapCount.keySet().size());
        assertEquals(5, mapCount.get("IT"));
        assertEquals(4, mapCount.get("HR"));
    }
//    streamService.findOldestEmployee(empList);
//    streamService.findYoungestFemale(empList);
//    streamService.findEmployeesWithAgeGreaterOrLessThan30(empList);
//    streamService.findDepartmentWithMoreEmployees(empList);
//    streamService.findAnyEmployeeFromHR(empList);
//    streamService.findDepartmentWithMoreThan3Employees(empList);
//    streamService.listDepartmentDistinct(empList);
//    streamService.printEmployeesFromCityOrdered(empList,"Blore");
//    streamService.countTotalEmployees(empList);
//    streamService.countEmployeesByDepartment(empList);
//    streamService.findDepartmentWithMostEmployees(empList);
//    streamService.listEmployeeSortedByAgeAndName(empList);
//    streamService.findTheMostExperiencedEmployee(empList);
//    streamService.findTheMostExperiencedEmployeeV2(empList);
//    streamService.findAverageAndTotalSalary(empList);
//    streamService.findAverageSalaryByDepartment(empList);
//    streamService.findHighestSalary(empList);
//    streamService.findHighestSalaryV2(empList);
//    streamService.findSecondHighestSalary(empList);
//    streamService.findNthHighestSalary(empList, 10);
//    streamService.findHighestSalaryByGender(empList);
//    streamService.findLowestSalaryByGender(empList);
//    streamService.listSalaryASC(empList);
//    streamService.listSalaryDESC(empList);
//    streamService.findHighestSalaryByDepartment(empList);
//    streamService.listEmployeeByDepartmentASC(empList);
//    streamService.listEmployeeByDepartmentDESC(empList);

}
