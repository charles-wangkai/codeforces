import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "abc";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    return IntStream.range(0, s.length()).anyMatch(i -> s.charAt(i) == TARGET.charAt(i));
  }
}
