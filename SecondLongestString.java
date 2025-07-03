import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondLongestString {
    public static void main(String[] args) {
        List<String> strings = Arrays
              .asList( "banana","banana", "apple", "cherry", "date", "grapefruit");
        Optional<String> longest = 
            strings.stream()
            .distinct()
            .sorted(Comparator.comparing(String::length).reversed())
            .skip(2)
            .findFirst();
        System.out.println(longest);
        longest.ifPresent(System.out::println);
    }
}