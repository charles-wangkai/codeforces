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
    int beginIndex = s.indexOf('1');

    return (beginIndex == -1)
        ? 0
        : (int)
            IntStream.range(beginIndex, s.length())
                .filter(i -> i == beginIndex || s.charAt(i) != s.charAt(i - 1))
                .count();
  }
}