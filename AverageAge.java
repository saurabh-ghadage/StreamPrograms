import java.util.Arrays;
import java.util.List;

public class AverageAge {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 35)
        );
        
        Double avgAge = persons.stream()
                            .mapToInt(person -> person.age)
                            .average()
                            .orElse(0);
        System.out.println("avg: " + avgAge);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}