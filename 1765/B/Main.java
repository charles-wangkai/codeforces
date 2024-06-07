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
    return (s.length() % 3 != 2)
        && IntStream.range(0, s.length() / 3)
            .allMatch(i -> s.charAt(i * 3 + 1) == s.charAt(i * 3 + 2));
  }
}