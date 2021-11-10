import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      char c = sc.next().charAt(0);
      String s = sc.next();

      System.out.println(solve(s, c));
    }

    sc.close();
  }

  static String solve(String s, char c) {
    int n = s.length();

    Set<Integer> diffIndicies =
        IntStream.range(0, n).filter(i -> s.charAt(i) != c).boxed().collect(Collectors.toSet());

    if (diffIndicies.isEmpty()) {
      return "0";
    }

    for (int x = 1; x <= n; ++x) {
      if (check(n, diffIndicies, x)) {
        return String.format("1\n%d", x);
      }
    }

    return String.format("2\n%d %d", n - 1, n);
  }

  static boolean check(int n, Set<Integer> diffIndicies, int x) {
    for (int i = x; i <= n; i += x) {
      if (diffIndicies.contains(i - 1)) {
        return false;
      }
    }

    return true;
  }
}
