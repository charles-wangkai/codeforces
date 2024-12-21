import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
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
    return IntStream.range(0, s.length())
            .map(
                i ->
                    (i == 0 && s.charAt(i) == 's')
                        ? '.'
                        : ((i == s.length() - 1 && s.charAt(i) == 'p') ? '.' : s.charAt(i)))
            .filter(c -> c != '.')
            .distinct()
            .count()
        <= 1;
  }
}