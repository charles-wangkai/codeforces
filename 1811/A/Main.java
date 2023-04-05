import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int d = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, d));
    }

    sc.close();
  }

  static String solve(String s, int d) {
    int firstLargerIndex =
        IntStream.range(0, s.length())
            .filter(i -> d > s.charAt(i) - '0')
            .findFirst()
            .orElse(s.length());

    return String.format(
        "%s%d%s", s.substring(0, firstLargerIndex), d, s.substring(firstLargerIndex));
  }
}
