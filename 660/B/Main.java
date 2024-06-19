import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static String solve(int n, int m) {
    return IntStream.range(0, m)
        .boxed()
        .sorted(
            Comparator.<Integer, Integer>comparing(i -> i % (2 * n) / 2)
                .thenComparing(i -> i % 2)
                .thenComparing(Comparator.<Integer, Integer>comparing(i -> i / (2 * n)).reversed()))
        .map(i -> i + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}