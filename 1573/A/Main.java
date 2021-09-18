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
    return IntStream.range(0, s.length())
        .map(i -> (s.charAt(i) == '0') ? 0 : (s.charAt(i) - '0' + ((i == s.length() - 1) ? 0 : 1)))
        .sum();
  }
}
