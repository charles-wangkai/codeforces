import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "2020";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    return IntStream.rangeClosed(0, TARGET.length())
        .anyMatch(
            leftLength ->
                s.startsWith(TARGET.substring(0, leftLength))
                    && s.endsWith(TARGET.substring(leftLength)));
  }
}
