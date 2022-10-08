import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, k));

    sc.close();
  }

  static String solve(String s, int k) {
    return IntStream.rangeClosed(1, s.length())
        .mapToObj(
            i ->
                IntStream.range(0, k)
                    .mapToObj(j -> s.charAt(j % i))
                    .map(String::valueOf)
                    .collect(Collectors.joining()))
        .min(Comparator.naturalOrder())
        .get();
  }
}
