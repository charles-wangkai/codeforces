import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return Math.max(
        0,
        (int) IntStream.range(1, s.length()).filter(i -> s.charAt(i) != s.charAt(i - 1)).count()
            - ((s.charAt(0) == '0') ? 1 : 0));
  }
}
