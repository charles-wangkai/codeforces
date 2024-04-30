import java.util.ArrayList;
import java.util.List;
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
    List<String> operations = new ArrayList<>();
    for (int i = n - 1; i >= 0; --i) {
      for (int type = 1; type <= 2; ++type) {
        operations.add(
            String.format(
                "%d %d %s",
                type,
                i + 1,
                IntStream.rangeClosed(1, n)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "))));
      }
    }

    int sum = IntStream.rangeClosed(1, n).map(i -> i * (2 * i - 1)).sum();

    return String.format("%d %d\n%s", sum, operations.size(), String.join("\n", operations));
  }
}
