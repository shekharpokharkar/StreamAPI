package com.seleniumexpress.streamApiExample;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {

		List<Employee> employeeList = EmployeeUtils.getEmployeeList();

		System.out.println("1.Get All Employee Name as list");

		employeeList.stream().filter(emp -> emp.getEmployeeAge() > 25).map(Employee::getEmployeeName)
				.forEach(e -> System.out.print(e + "=="));
		System.out.println("1.Get Count All Employee whose salary > 20000");
		long count = employeeList.stream().filter(emp -> emp.getEmployeeSalary() > 20000.00).count();
		System.out.println("Count All Employee whose salary > 20000:=" + count);
		System.out.println("************************");
		System.out.println("check whether any emploee age < 15");

		boolean anyMatch = employeeList.stream().anyMatch(emp -> emp.getEmployeeAge() < 15);
		System.out.println("Result:" + anyMatch);

		System.out.println("Check every employee joined after 2000 or not");

		boolean allMatch = employeeList.stream()
				.allMatch(emp -> emp.getJoingDateDate().isAfter(LocalDate.of(2000, 01, 01)));

		System.out.println("All Employee joined after 2000>>" + allMatch);

		System.out.println("Get all Employee in Sorting order");

		employeeList.stream().sorted().forEach(System.out::println);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("Get all Employee salaray high to low in Sorting order");

		employeeList.stream().sorted((e1, e2) -> {
			/*
			 * return e1.getEmployeeSalary() < e2.getEmployeeSalary() ? 1 :
			 * e1.getEmployeeSalary() > e2.getEmployeeSalary() ? -1 : 0;
			 */

			return (int) (e2.getEmployeeSalary() - e1.getEmployeeSalary());
		}).forEach(System.out::println);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("Minnimum Salary Employee details");

		Employee employee = employeeList.stream().sorted(
				Comparator.comparingDouble(Employee::getEmployeeSalary).thenComparing(Employee::getEmployeeName))
				.findFirst().get();

		System.out.println(employee);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("Average Salary of all Employee");

		double asDouble = employeeList.stream().mapToDouble(Employee::getEmployeeSalary).average().getAsDouble();
		System.out.println("Average Salary of All Employee:" + asDouble);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Average Age of all Employee");

		double asDouble2 = employeeList.stream().mapToInt(Employee::getEmployeeAge).average().getAsDouble();
		System.out.println("Average age of All Employee:" + asDouble2);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Uses of peek method");

		employeeList.stream().peek(emp -> System.out.println(emp)).map(e -> e.getEmployeeSalary())
				.forEach(System.out::println);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Department Wise employee");

		Map<String, Double> collect = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getEmployeeDepartment, Collectors.averagingDouble(Employee::getEmployeeSalary)));
		System.out.println(collect);

		System.out.println("Department Wise HighestSalaried employee");

		Map<String, Optional<Employee>> collect2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartment,
						Collectors.maxBy(Comparator.comparingDouble(Employee::getEmployeeSalary))));
		collect2.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "====" + e.getValue()));

		Map<String, Optional<Employee>> collect3 = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getEmployeeName, Collectors.minBy(Comparator.comparingInt(Employee::getEmployeeAge))));

		collect3.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "====" + e.getValue()));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Count employee Gender wise");
		Map<Character, Long> collect4 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeGender, Collectors.counting()));
		System.out.println(collect4);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Count employee Gender wise");

		System.out.println("=======++++++++++++++++++++++++====================");
//		🔹 Stream API Practice Problem Set for Employee
//		📦 Basic Level
//		Filter all employees whose salary is greater than 50,000.

		System.out.println("1.Filter all employees whose salary is greater than 50,000");

		employeeList.stream().filter(emp -> emp.getEmployeeSalary() > 50000).forEach(System.out::println);

//		Get a list of all employee names.
		System.out.println("2.Get a list of all employee names");
		employeeList.stream().map(Employee::getEmployeeName).forEach(System.out::println);

//		Find the count of employees in the list.
		System.out.println("3.Find the count of employees in the list");
		long count2 = employeeList.stream().count();
		System.out.println("4.Total employee in list are:" + count2);
//		Get a list of employees from the city "Pune".
		System.out.println("5.Get a list of employees from the city \"Pune\"");

		employeeList.stream().filter(emp -> emp.getEmployeeCity().equalsIgnoreCase("pune"))
				.forEach(System.out::println);

//		Sort employees by their salary in ascending order.
		System.out.println("6.Sort employees by their salary in ascending order");
		employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeSalary)).forEach(System.out::println);

//		📊 Intermediate Level
//		Group employees by their department	Map<String, List<Employee>>

		System.out.println("7.Group employees by their department");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment)).entrySet().stream()
				.forEach(System.out::println);
//		Find the highest salary among all employees.

		System.out.println("8.Find the highest salary among all employees");
		Employee employee2 = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getEmployeeSalary))).get();

		System.out.println(employee2);

//		Find the employee with the lowest age.
		System.out.println("9.Find the employee with the lowest age");

		Employee employee3 = employeeList.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Employee::getEmployeeSalary))).get();
		System.out.println(employee3);

//		List of employee names sorted by joining date (oldest to newest).

		System.out.println("10.List of employee names sorted by joining date (oldest to newest)");

		employeeList.stream().sorted(Comparator.comparing(Employee::getJoingDateDate)).map(Employee::getEmployeeName)
				.forEach(System.out::println);

//		Get the average salary of all employees.

		System.out.println("11.Get the average salary of all employees");

		Double collect5 = employeeList.stream().collect(Collectors.averagingDouble(Employee::getEmployeeSalary));
		System.out.println("average salary of all employees" + collect5);
//		Partition employees based on their marital status.Map<Boolean, List<Employee>>

		System.out.println("12.Partition employees based on their marital status");

		employeeList.stream().collect(Collectors.groupingBy(Employee::isMarried)).entrySet().stream()
				.forEach(System.out::println);

//		Count employees in each department.	Map<String, Long>

		System.out.println("13.Count employees in each department");

		employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment, Collectors.counting()))
				.entrySet().stream().forEach(System.out::println);

//		Find the average age of employees grouped by gender	Map<Character, Double>
		System.out.println("14.Find the average age of employees grouped by gender");

		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeGender,
						Collectors.averagingInt(Employee::getEmployeeAge)))
				.entrySet().stream().forEach(System.out::println);

//		Get a comma-separated string of all employee names.
//		Example: "John, Mary, Alex, ..."
		System.out.println("15.Get a comma-separated string of all employee names");

		String collect6 = employeeList.stream().map(Employee::getEmployeeName).collect(Collectors.joining(","));

		System.out.println(collect6);

//		Find whether any employee has salary more than 1 lakh.		boolean anyMatch
//
		System.out.println("16.Find whether any employee has salary more than 1 lakh");

		boolean anyMatch2 = employeeList.stream().anyMatch(emp -> emp.getEmployeeSalary() > 100000.00);

		System.out.println(anyMatch2);

//		🧠 Advanced Level
//		Find the second highest salaried employee.
//
//		Group employees by department and find the highest salaried employee in each department.	Map<String, Optional<Employee>>
		System.out
				.println("17.Group employees by department and find the highest salaried employee in each department");

		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartment,
						Collectors.maxBy(Comparator.comparing(Employee::getEmployeeSalary))))
				.entrySet().forEach(System.out::println);

//		List employees who joined after 2020 and belong to "IT" department.

		System.out.println("18.List employees who joined after 2020 and belong to \"IT\" department.");

		Predicate<Employee> predicate1 = emp -> emp.getJoingDateDate().isAfter(LocalDate.of(2020, 01, 01));
		Predicate<Employee> predicate2 = emp -> emp.getEmployeeDepartment().equalsIgnoreCase("IT");
		Predicate<Employee> predicate3 = predicate1.and(predicate2);

		List<Employee> list = employeeList.stream()
				.filter(emp -> emp.getJoingDateDate().isAfter(LocalDate.of(2020, 01, 01)))
				.filter(emp -> emp.getEmployeeDepartment().equalsIgnoreCase("IT")).toList();
		System.out.println(list);
		System.out.println("*************************");
		List<Employee> list2 = employeeList.stream().filter(predicate3).toList();
		System.out.println(list2);

//		Create a custom comparator to sort employees by salary desc, then age asc.

		System.out.println("19.Create a custom comparator to sort employees by salary desc, then age asc");

		employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeSalary).reversed()
				.thenComparing(Comparator.comparing(Employee::getEmployeeAge))).forEach(System.out::println);

//		Find the name(s) of the highest paid female employee(s).

		System.out.println("20.Find the name(s) of the highest paid female employee(s)");

		Employee employee4 = employeeList.stream().filter(emp -> emp.getEmployeeGender().equals('F'))
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getEmployeeSalary))).get();
		System.out.println(employee4);
//		Group employees by city, then by department.	Map<String, Map<String, List<Employee>>>
		System.out.println("21.Group employees by city, then by department");

		Map<String, Map<String, List<Employee>>> collect7 = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getEmployeeCity, Collectors.groupingBy(Employee::getEmployeeDepartment)));

		collect7.forEach((city, deptMap) -> {
			System.out.println("City: " + city);
			deptMap.forEach((dept, emps) -> {
				System.out.println("  Department: " + dept);
				emps.forEach(emp -> System.out.println("    " + emp.getEmployeeName()));

			});
		});

//		List all departments sorted by average employee salary descending.
		System.out.println("22.List all departments sorted by average employee salary descending");
		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartment,
						Collectors.averagingDouble(Employee::getEmployeeSalary)))
				.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.forEach(System.out::println);

//		Get a list of top 3 youngest employees.
		System.out.println("23.Get a list of top 3 youngest employees");

		employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeAge)).limit(3)
				.forEach(System.out::println);

//		List employees joined in the current year.
		System.out.println("24.List employees joined in the current year");
		List<Employee> list3 = employeeList.stream().filter(
				emp -> emp.getJoingDateDate() != null && emp.getJoingDateDate().getYear() == LocalDate.now().getYear())
				.toList();

		System.out.println(list3);

		// Check if all employees are older than 25 years.
		System.out.println("20.Check if all employees are older than 25 years.");
		boolean allMatch2 = employeeList.stream().allMatch(emp -> emp.getEmployeeAge() > 25);
		System.out.println("Check if all employees are older than 25 years." + allMatch2);

		System.out.println(" Find the 4th Highest Salaried Employee");

		Optional<Employee> first = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getEmployeeSalary).reversed()).skip(3).findFirst();

		if (first.isPresent()) {
			Employee employee5 = first.get();
			System.out.println(employee5);
		}

		System.out.println(" Create a Map of Employee Name → Age");

		employeeList.stream().collect(Collectors.toMap(Employee::getEmployeeName, Employee::getEmployeeAge)).entrySet()
				.stream().forEach((entry) -> System.out.println(entry.getKey() + " " + entry.getValue()));
		System.out.println(" List Departments With More Than 3 Employees");

		employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment)).entrySet().stream()
				.filter(entry -> entry.getValue().size() >= 3).forEach(entry -> System.out.println(entry.getKey()));

		System.out.println("Print Employees Grouped by Gender and Sorted by Salary");

		employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeSalary))
				.collect(Collectors.groupingBy(Employee::getEmployeeGender))
				.forEach((key, value) -> System.out.println(key + " " + value));

		System.out.println("Find Employees Whose Name Starts and Ends With Same Character");

		List<Employee> list4 = employeeList.stream().filter(emp -> emp.getEmployeeName().charAt(0) == emp
				.getEmployeeName().charAt(emp.getEmployeeName().length() - 1)).toList();

		System.out.println(list4);

		System.out.println("Find the Department With the Highest Average Salary");

		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartment,
						Collectors.averagingDouble(Employee::getEmployeeSalary)))
				.entrySet().stream()
				.sorted((s1, s2) -> (int) (s1.getValue() - s2.getValue())).findFirst()
				//sorted(Map.Entry.comparingByValue()).findFirst()
				.ifPresent(emp -> System.out.println(emp.getKey()));

	}

}
