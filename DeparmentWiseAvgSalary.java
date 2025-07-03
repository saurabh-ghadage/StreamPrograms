import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DeparmentWiseAvgSalary {
    // 1. Find the average salary across all employees
    // 2. Find the max salary by departments
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 75000, "Engineering"),
            new Employee("Bob", 50000, "Marketing"),
            new Employee("Charlie", 120000, "Engineering"),
            new Employee("David", 90000, "Marketing"),
            new Employee("Eve", 100000, "Engineering")
        );
        //1. avg sal by streams
        double avgSal = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println(avgSal);

        // avg salary by for loop
        avgSal = 0;
        for(Employee emp: employees) {
            avgSal += emp.getSalary();
        }
        System.out.println(avgSal/employees.size());

        // 2. max sal by dept using stream
        Map<String, Optional<Employee>> maxSalDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(maxSalDept);

        maxSalDept.forEach((dept, emp) -> 
            System.out.println("Department: " + dept + ", Max Salary Employee: " + emp.get().salary)
        );

        // max sal by dept without stream
    }
}

class Employee {
    String name;
    double salary;
    String dept;
    
    public Employee(String name, double salary, String dept) {
        this.name =name;
        this.salary = salary;
        this.dept = dept;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDept() {
        return this.dept;
    }
}
