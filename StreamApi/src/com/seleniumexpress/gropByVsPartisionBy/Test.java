package com.seleniumexpress.gropByVsPartisionBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.seleniumexpress.streamApiExample.Employee;

public class Test {
	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeUtils.getEmployeeList();

		System.out.println("GroupBy Employee based on their department");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment)).entrySet().stream()
				.forEach((entry) -> System.out
						.println("Department=>" + entry.getKey() + "+++++List of Employee=>" + entry.getValue()));
		System.out.println("***************************************");
		System.out.println("Count the Employee on each department");
		employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment, Collectors.counting()))
				.entrySet().stream().forEach(entry -> System.out.println("Department Name==>" + entry.getKey() + "***"
						+ "Total No of Employee in the department is:" + entry.getValue()));
		System.out.println("***************************************");
		System.out.println("Average Salary of  each department");
		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartment,
						Collectors.averagingDouble(Employee::getEmployeeSalary)))
				.entrySet().stream().forEach(entry -> System.out.println("Department Name==>" + entry.getKey() + "***"
						+ "Average Salary of all employee in the department is:" + entry.getValue()));
		System.out.println("***************************************");
		System.out.println("Employee Names by each department");
		Map<String, List<String>> collect = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getEmployeeDepartment, Collectors.mapping(Employee::getEmployeeName, Collectors.toList())));
		System.out.println(collect);
		System.out.println("***************************************");
		System.out.println("Employee With highest salary in each department");

		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartment,
						Collectors.maxBy(Comparator.comparingDouble(Employee::getEmployeeSalary))))
				.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "====" + entry.getValue()));
		System.out.println("***************************************");

		System.out.println("=========================================================================");

		System.out.println("***++++++PARTISIONING BY++++++***");

		System.out.println("partisioning employee by using Male and Female");

		Map<Boolean, List<Employee>> collect2 = employeeList.stream()
				.collect(Collectors.partitioningBy(Employee::isMarried));

		System.out.println(collect2);

		System.out.println("partisioning employee by using Salary > 50000");
		Map<Boolean, List<Employee>> collect3 = employeeList.stream().collect(Collectors.partitioningBy(emp -> {
			return emp.getEmployeeSalary() >= 50000 ? true : false;
		}));

		collect3.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "===" + entry.getValue()));

		System.out.println("Count employee by using their age above 30");

		employeeList.stream().collect(Collectors.partitioningBy(emp -> {
			return emp.getEmployeeAge() >= 30;
		})).entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "****" + entry.getValue().size()));

		System.out.println("==============Combine Complex Operation=============");
		System.out.println("Sort By using employee department and then by using employee Salary");
		employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeDepartment)

				.thenComparing(Comparator.comparing(Employee::getEmployeeSalary).reversed()))
				.forEach(emp -> System.out.println(emp));

		System.out.println("Find the 3rd highest salary from employeeList");

		Employee employee = employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeSalary).reversed())
				.skip(2).findFirst().get();

		System.out.println(employee);

		DoubleSummaryStatistics collect4 = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getEmployeeSalary));
		System.out.println(collect4.getAverage());
		System.out.println(collect4.getCount());
		System.out.println(collect4.getMax());
		System.out.println(collect4.getMin());
		System.out.println(collect4.getSum());

		Map<Boolean, List<Employee>> collect5 = employeeList.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getEmployeeGender().equals('M')));

		System.out.println(collect5);
		System.out.println("*******************************");

		collect5.forEach((flag, list) -> {

			if (flag) {
				System.out.println("MALE Employee");
				DoubleSummaryStatistics collect6 = list.stream()
						.collect(Collectors.summarizingDouble(Employee::getEmployeeSalary));
				System.out.println("Male Employee max:" + collect6.getMax());
				System.out.println("Male Employee min:" + collect6.getMin());
				System.out.println("Male Employee average:" + collect6.getAverage());
				System.out.println("Male Employee count:" + collect6.getCount());
				System.out.println("Male Employee sum:" + collect6.getSum());
				// list.forEach(emp -> System.out.println(emp));
			} else {
				System.out.println("FEMALE Employee");
				DoubleSummaryStatistics collect6 = list.stream()
						.collect(Collectors.summarizingDouble(Employee::getEmployeeSalary));
				System.out.println("FeMale Employee max:" + collect6.getMax());
				System.out.println("FeMale Employee min:" + collect6.getMin());
				System.out.println("FeMale Employee average:" + collect6.getAverage());
				System.out.println("FeMale Employee count:" + collect6.getCount());
				System.out.println("FeMale Employee sum:" + collect6.getSum());

				// list.forEach(emp -> System.out.println(emp));
			}

		});

		System.out.println("============1.=Reduce=======================");

		Employee employee2 = employeeList.stream().collect(Collectors.reducing(new BinaryOperator<Employee>() {

			@Override
			public Employee apply(Employee e1, Employee e2) {

				return e2;
			}

		})).get();
		System.out.println("============1.=Reduce=======================");

		System.out.println("Total Sum of salary of all employee");

		Double collect6 = employeeList.stream().collect(Collectors.reducing(

				0.0, // Identity
				Employee::getEmployeeSalary, // Mapper: Employee → salary
				Double::sum // Combiner
		));

		System.out.println("Sum of all Employee Salaries:" + collect6);

		System.out.println(" 2.Total Sum of salary of all employee");

		Double collect7 = employeeList.stream().map(Employee::getEmployeeSalary)
				.collect(Collectors.reducing(0.0, Double::sum));

		System.out.println("Remove duplicate employee By Name");
		/*
		 * 
		 * What is Collectors.collectingAndThen? collectingAndThen is a wrapper
		 * collector used when you: First collect data using any other collector Then
		 * apply a finishing transformation (via a function) on the collected result
		 * 
		 * downstream: the main collector (e.g. toList(), toSet(), counting())
		 * 
		 * finisher: a function applied after collection is complete
		 * 
		 * 
		 * 
		 */
		System.out.println("Count employees from Mumbai and convert to String");

		List<Employee> collect8 = employeeList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),

				list -> list.stream().filter(e -> e.getEmployeeCity().equalsIgnoreCase("Mumbai")).toList()

		));
		System.out.println(collect8);

		System.out.println("**************************");

		System.out.println("Highest Paid Employee’s Name");

		String collect9 = employeeList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),

				list -> list.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getEmployeeSalary)))
						.stream().map(emp -> emp.getEmployeeName()).findFirst().get()

		));

		System.out.println("Highest Salaried employee:" + collect9);

		List<Employee> collect10 = employeeList.stream()
				.collect(Collectors.collectingAndThen(Collectors.toMap(Employee::getEmployeeName, e -> e),
						entry -> entry.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList())));

		collect10.forEach(System.out::println);
	}

}
