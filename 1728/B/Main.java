import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int[] tail = (n % 2 == 0) ? new int[] {n - 1, n} : new int[] {n - 2, n};
    int[] head =
        IntStream.rangeClosed(1, n)
            .filter(i -> Arrays.stream(tail).allMatch(x -> x != i))
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();

    return IntStream.concat(Arrays.stream(head), Arrays.stream(tail))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}