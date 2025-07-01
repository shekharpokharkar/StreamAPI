package com.seleniumexpress.streamApiExample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

	public static List<Employee> getEmployeeList() {
		List<Employee> employees = new ArrayList<>();

		employees.add(
				new Employee(115, "Farhan", "Civil", "Satara", 30, 43000.00, true, 'M', LocalDate.of(2017, 7, 29)));
		employees.add(new Employee(102, "Xavior", "Electronics", "Satara", 25, 15962.00, false, 'M',
				LocalDate.of(2019, 3, 10)));
		employees.add(new Employee(110, "Nikhil", "Mechanical", "Delhi", 32, 59000.00, true, 'M',
				LocalDate.of(2016, 12, 17)));
		employees.add(new Employee(120, "Geeta", "Electronics", "Pune", 31, 49500.00, false, 'F',
				LocalDate.of(2020, 12, 31)));
		employees.add(
				new Employee(106, "Vikram", "Design", "Nashik", 27, 42000.00, true, 'M', LocalDate.of(2022, 2, 18)));
		employees.add(new Employee(113, "Priya", "Design", "Aurangabad", 28, 51000.00, false, 'F',
				LocalDate.of(2022, 5, 23)));
		employees.add(new Employee(101, "Shekhar", "Mechanical", "Pune", 25, 15962.00, false, 'M',
				LocalDate.of(2020, 1, 15)));
		employees.add(
				new Employee(117, "Jay", "Mechanical", "Nagpur", 26, 47000.00, false, 'M', LocalDate.of(2022, 3, 15)));
		employees.add(
				new Employee(109, "Ritika", "Marketing", "Mumbai", 25, 41000.00, false, 'F', LocalDate.of(2023, 4, 1)));
		employees.add(new Employee(104, "Ravi", "IT", "Delhi", 28, 60000.00, true, 'M', LocalDate.of(2021, 7, 12)));
		employees.add(
				new Employee(112, "Kiran", "Finance", "Kolhapur", 26, 39000.00, true, 'M', LocalDate.of(2020, 10, 19)));
		employees.add(new Employee(108, "Suresh", "Civil", "Pune", 31, 46000.00, true, 'M', LocalDate.of(2019, 9, 30)));
		employees.add(new Employee(114, "Omkar", "IT", "Pune", 29, 58000.00, true, 'M', LocalDate.of(2018, 1, 3)));
		employees.add(new Employee(103, "Neha", "HR", "Mumbai", 30, 55000.00, true, 'F', LocalDate.of(2018, 5, 20)));
		employees
				.add(new Employee(105, "Asha", "Finance", "Pune", 26, 47000.00, false, 'F', LocalDate.of(2020, 11, 5)));
		employees.add(
				new Employee(118, "Sneha", "Marketing", "Nashik", 27, 45000.00, true, 'F', LocalDate.of(2021, 9, 9)));
		employees.add(new Employee(119, "Amit", "IT", "Delhi", 28, 62000.00, true, 'M', LocalDate.of(2016, 6, 6)));
		employees.add(new Employee(107, "Lata", "HR", "Nagpur", 29, 52000.00, false, 'F', LocalDate.of(2017, 8, 24)));
		employees.add(new Employee(111, "Deepa", "Electronics", "Thane", 27, 48000.00, false, 'F',
				LocalDate.of(2021, 6, 11)));
		employees.add(new Employee(116, "Rani", "HR", "Mumbai", 24, 40000.00, false, 'F', LocalDate.of(2023, 2, 7)));

		return employees;

	}

}
