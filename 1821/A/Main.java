import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return (s.charAt(0) == '0')
        ? 0
        : IntStream.range(0, s.length())
            .map(i -> (s.charAt(i) == '?') ? ((i == 0) ? 9 : 10) : 1)
            .reduce((acc, x) -> acc * x)
            .getAsInt();
  }
}
