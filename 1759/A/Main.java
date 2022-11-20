import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "Yes";

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
    int index = TARGET.indexOf(s.charAt(0));
    if (index == -1) {
      return false;
    }

    return IntStream.range(0, s.length())
        .allMatch(i -> s.charAt(i) == TARGET.charAt((i + index) % TARGET.length()));
  }
}
