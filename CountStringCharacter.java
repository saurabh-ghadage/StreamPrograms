public class CountStringCharacter {
    public static void main(String[] args) {
        String str = "abdsjhbas";
        long count = str.chars().mapToObj(i -> (char) i)
        .count();
        System.err.println(count);
    }
}
