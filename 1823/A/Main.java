import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    for (int i = 0; i <= n; ++i) {
      if (i * (i - 1) / 2 + (n - i) * (n - i - 1) / 2 == k) {
        int i_ = i;
        return String.format(
            "YES\n%s",
            IntStream.range(0, n)
                .map(j -> (j < i_) ? 1 : -1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
      }
    }

    return "NO";
  }
}
