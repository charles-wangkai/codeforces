import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String tower1 = sc.next();
      String tower2 = sc.next();

      System.out.println(solve(tower1, tower2) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String tower1, String tower2) {
    String s = tower1 + new StringBuilder(tower2).reverse().toString();

    return IntStream.rangeClosed(1, s.length() - 1)
        .anyMatch(
            length1 ->
                IntStream.range(0, length1 - 1).allMatch(i -> s.charAt(i) != s.charAt(i + 1))
                    && IntStream.range(length1, s.length() - 1)
                        .allMatch(i -> s.charAt(i) != s.charAt(i + 1)));
  }
}
