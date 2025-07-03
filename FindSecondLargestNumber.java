import java.util.Arrays;
import java.util.Comparator;

public class FindSecondLargestNumber {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,5};
        
        Integer secondLargest = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondLargest);
    }
}
