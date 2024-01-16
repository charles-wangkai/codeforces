import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();
      String f = sc.next();

      System.out.println(solve(s, f));
    }

    sc.close();
  }

  static int solve(String s, String f) {
    return Math.max(
        (int)
            IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) == '0' && f.charAt(i) == '1')
                .count(),
        (int)
            IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) == '1' && f.charAt(i) == '0')
                .count());
  }
}