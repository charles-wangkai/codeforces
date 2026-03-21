import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String X = sc.next();

      System.out.println(solve(X) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String X) {
    return (X.length() % 2 == 0)
        ? checkEvenLength(X)
        : (X.charAt(0) != 'b' && checkEvenLength(X.substring(1)));
  }

  static boolean checkEvenLength(String x) {
    return IntStream.range(0, x.length() / 2)
        .allMatch(
            i -> {
              char c1 = x.charAt(i * 2);
              char c2 = x.charAt(i * 2 + 1);

              return c1 == '?' || c2 == '?' || c1 != c2;
            });
  }
}