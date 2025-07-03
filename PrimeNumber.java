import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        numbers.stream()
                                    .distinct()
                                    .forEach(no -> isPrime(no));
    }

    public static void isPrime(Integer no){
        if(no<=1) {
            return;
        } 
        for (int i = 2; i <= Math.sqrt(no); i++) {
            if (no % i == 0) {
                return;
            }
          }
          System.out.println(no);;
    }
}
