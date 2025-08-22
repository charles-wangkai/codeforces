import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(long n) {
    List<Long> xs = new ArrayList<>();
    for (long i = 10; i + 1 <= n; i *= 10) {
      if (n % (i + 1) == 0) {
        xs.add(n / (i + 1));
      }
    }
    Collections.sort(xs);

    return "%d\n%s"
        .formatted(xs.size(), xs.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}