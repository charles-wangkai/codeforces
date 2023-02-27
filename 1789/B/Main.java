import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(String s) {
    return IntStream.range(0, s.length() / 2)
            .filter(
                i ->
                    s.charAt(i) != s.charAt(s.length() - 1 - i)
                        && (i == 0 || s.charAt(i - 1) == s.charAt(s.length() - i)))
            .count()
        <= 1;
  }
}
