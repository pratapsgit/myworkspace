package com.pkmexer.lambadas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamDemo {

	public static void main(String[] args) {
		int[] values = { 34, 76, 12, 90, 45, 21, 56, 32, 88 };
		
		String str = "hello Lambda";
		
		System.out.println("Inside forEach");
		IntStream.of(values).forEach( value -> System.out.printf("%s-%d ", str, value));
		
		System.out.println("\nInside IntConsumer");
		IntStream.of(values).forEach(new IntConsumer() {

			@Override
			public void accept(int arg0) {
				System.out.printf("%s-%d ",str, arg0);
				
			}
			
		});
		
		//forEach is a terminal operation, it performs a task on each element
		//it's an IntConsumer
		
		//context of the lambda expression determine the type of the variables 
		//used in lambda expression
		
		//We can use the local variables from the scope in lambda expression
		//But the local variables should be final and non modifiable
		
		//We can use the this variable within the lambda expression
		
		//Variables should have different name than any existing variable in the scope
		
		
		//Intermediate Stream Operations
		//------------------------------
		/*
		 * filter - locate elements matches a particular criteria
		 * 
		 * distinct - returns unique elements
		 * 
		 * limit - limit on the maximum number of elements for the stream
		 * 
		 * map - maps the original values to a different value
		 * 
		 * sorted - allows to sort the elements in the stream
		 */
		
		//Terminal Operations
		//-------------------------------
		/*
		 * forEach - process each element from the stream
		 * 
		 * Reduction operations - take all values in the stream and return a single value
		 * --------------------
		 * average
		 * 
		 * sum
		 * 
		 * max
		 * 
		 * min
		 * 
		 * count
		 * 
		 * reduce
		 * 
		 * Mutable reduction operations - Creates a container
		 * ----------------------------
		 * 
		 * collect
		 * 
		 * toArray
		 * 
		 * Search Operations - does a search with or without criteria
		 * -----------------
		 * 
		 * findFirst
		 * 
		 * findAny
		 * 
		 * anyMatch
		 * 
		 * allMatch
		 */

		System.out.printf("%ncount() : %d%n",IntStream.of(values).count());
		//getAsInt() throws no NoSuchElement exception, if there are no elements
		//Alternative is orElse method
		System.out.printf("min() : %d%n",IntStream.of(values).min().getAsInt());
		System.out.printf("max() : %d%n",IntStream.of(values).max().getAsInt());
		System.out.printf("average() : %.2f%n",IntStream.of(values).average().getAsDouble());
		System.out.printf("sum() : %d%n",IntStream.of(values).sum());
		
		//reduce method allows you to create your own custom reductions
		//Sum of all numbers
		System.out.printf("Sum of all elemnts : %d%n", IntStream.of(values)
				.reduce(0, (x, y) -> (x+y))
				);
		
		System.out.printf("Sum of squares %d%n", IntStream.of(values)
				.reduce(0, (x, y) -> (x + y*y))
				);
		
		int[] valuep = { 3, 2, 6, 8, 9, 5 };
		System.out.printf("Product of all numbers %d%n", IntStream.of(valuep)
				.reduce(1, (x, y) -> (x * y))
				);
		
		System.out.println("Display the even values in sorted order");
		IntStream.of(valuep).filter(value -> value%2 == 0)
			.forEach(value -> System.out.printf("%d, ", value));
		System.out.println();
		
		System.out.println("Display odd elements multiplied by 50");
		IntStream.of(valuep)
			.filter(value -> value%2 != 0)
			.map(value -> value * 50)
			.sorted()
			.forEach(value -> System.out.printf("%d -> %d, ", value/50, value));
		System.out.println();
		
		IntPredicate oddPred = value -> value%2 != 0;
		IntPredicate greaterThan5 = value -> value>5;
		
		System.out.println("Odd elements greater than 5");
		IntStream.of(valuep)
			.filter(oddPred.and(greaterThan5))
			.sorted()
			.forEach(value -> System.out.printf("%d, ", value));
		System.out.println();
		
		System.out.println("range() - exclusive Last element");
		IntStream.range(20,  30).forEach(value -> System.out.printf("%d, ", value));
		System.out.println();
		
		System.out.println("rangeClosed() - inclusive Last element");
		IntStream.rangeClosed(20,  30).forEach(value -> System.out.printf("%d, ", value));
		System.out.println();
	
		
		//IntStream.of(intvalues) == Arrays.stream(intvalues)
		Integer[] intValues = { 45, 23, 90, 78 };
		System.out.printf("%s%n", Arrays.asList(intValues));
		
		System.out.printf("Sorted list %s%n",
				Arrays.stream(intValues)
				.sorted()
				.collect(Collectors.toList()));
		
		System.out.println("Values greater than 50");
		List<Integer> valuesGreaterThan50 = Arrays.stream(intValues)
				.filter(value -> value > 50)
				.sorted()
				.collect(Collectors.toList());
		System.out.printf("%s%n",valuesGreaterThan50);
		
		System.out.printf("Integers greater than 50 sorted in reverse order %n%s%n",
				valuesGreaterThan50.stream()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList()));
		
		//Method Reference
		/*
		 *  instance method
		 *  String::toUpperCase
		 * 
		 *  instance method of specific object
		 *  System.out::println
		 *  
		 *  static method
		 *  Math::sqrt
		 *  
		 *  constructor
		 *  TreeMap::new
		 *  
		 */
		
		String strSimple = "My name is Don, I rule the world, but I know there is someone who will take my place one day.";
		
		List<String> stringList = Arrays.asList(strSimple.split(" "));
		
		System.out.println("Original list has following elements");
		stringList.stream().forEach(value -> System.out.printf("%s, ", value));
		System.out.println();
		
		System.out.println("Convert it to uppercase uisng Method reference");
		System.out.printf("%s%n", stringList.stream().map(String::toUpperCase).collect(
				Collectors.toList()
				));
		
		System.out.println("Sort the strings in acending order");
		stringList.stream()
			.filter(s -> s.compareToIgnoreCase("f") > 0)
			.sorted(String.CASE_INSENSITIVE_ORDER)
			.forEach(value -> System.out.printf("%s, ", value));
		System.out.println();
		
		System.out.println("Sort the strings in descending order");
		stringList.stream()
			.filter(s -> s.compareToIgnoreCase("f") > 0)
			.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
			.forEach(value -> System.out.printf("%s, ", value));
		System.out.println();
		
		Employee[] employees =  {
				new Employee("Pratap", "Mallick", 50000.67, "IT"),
				new Employee("Piyus", "Pradhan", 80000.24, "Banking"),
				new Employee("Ravel", "Jindal", 30000.56, "Facility"),
				new Employee("Janmenjay", "Dibakar", 40000.87, "Marketing"),
				new Employee("Dheeren", "K", 89622.45, "Sales"),
				new Employee("Bhaskar", "Jindal", 76232.65, "IT"),
				new Employee("Komal", "Ahuja", 100089.34, "Banking"),
				new Employee("Bhanu", "Jain", 985636.56, "Sales"),
				new Employee("Robet", "Pattainaik", 76343.78, "Marketing"),
				new Employee("Kiril", "Bhavesh", 67923.89, "Finance"),
			};
		
		System.out.println("Employee databse");
		//Arrays.asList(employees).stream().forEach(value -> System.out.printf("%s%n", value));
		Arrays.asList(employees).stream().forEach(System.out::println);
		
		Predicate<Employee> salaryBetween5To9 = (Employee e) -> e.getSalary() >=50000 && e.getSalary()<=90000;
		System.out.println("Employees with salary between 50000 to 90000");
		Arrays.asList(employees).stream()
			.filter(salaryBetween5To9)
			.forEach(System.out::println);
		
		System.out.println("Employees with salary between 50000 to 90000 sorted by salary");
		Arrays.asList(employees).stream()
			.filter(salaryBetween5To9)
			.sorted(Comparator.comparing(Employee::getSalary))
			.forEach(System.out::println);
		
		System.out.println("FIrst employees with salary between 50000 to 90000\n"+
		Arrays.asList(employees).stream()
			.filter(salaryBetween5To9)
			.findFirst()
			.orElse(new Employee("None", "None", 0.0, "None")));
		
		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;
		
		Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);
		System.out.println("Sort emplyees by their last name then by first name");
		Arrays.asList(employees).stream()
			.sorted(lastThenFirst)
			.forEach(System.out::println);	

		System.out.println("Sort emplyees by their last name then by first name in reverse order");
		Arrays.asList(employees).stream()
			.sorted(lastThenFirst.reversed())
			.forEach(System.out::println);
		
		System.out.println("Sort emplyees last names and should be disctinct");
		Arrays.asList(employees).stream()
			.map(Employee::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("Sort emplyees last name and then first name and print the names");
		Arrays.asList(employees).stream()
			.sorted(lastThenFirst)
			.map(Employee::getName)
			.forEach(System.out::println);
		
		Map<String, List<Employee>> groupByDepartment = Arrays.asList(employees)
				.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		groupByDepartment.forEach(
				(department, employeeInDept) -> {
					System.out.println(department);
					employeeInDept.stream().forEach(System.out::println);
				}
				);
		
		Map<String, Long> employeeCountByDepartment = Arrays.asList(employees)
				.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
		
		employeeCountByDepartment.forEach(
				(department, count) -> {
					System.out.println(department);
					System.out.println("\tnumber of employees are "+count);
				}
				);
		
		double salarySum = Arrays.asList(employees).stream()
				.mapToDouble(Employee::getSalary)
				.sum();
		System.out.println("Sum of salary of all employees "+salarySum);

		double salarySumReduce = Arrays.asList(employees).stream()
				.mapToDouble(Employee::getSalary)
				.reduce(0, (v1, v2) -> v1+v2);
		System.out.println("Sum of salary of all employees "+salarySumReduce);
		
		double salaryAverage = Arrays.asList(employees).stream()
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0);
		System.out.println("Average salary of all employees "+salaryAverage);
		
	}
	
}
