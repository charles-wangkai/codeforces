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
    if (n == 1) {
      return "1";
    }

    return (n % 2 == 0)
        ? IntStream.range(0, n)
            .map(i -> i / 2 * 2 + 2 - i % 2)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "))
        : "-1";
  }
}
