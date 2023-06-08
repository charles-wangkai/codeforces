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
    return IntStream.rangeClosed('a', 'z')
        .map(target -> computeOperationNum(s, (char) target))
        .min()
        .getAsInt();
  }

  static int computeOperationNum(String s, char target) {
    int result = 0;
    int count = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != s.length() && s.charAt(i) != target) {
        ++count;
      } else {
        result = Math.max(result, f(count));
        count = 0;
      }
    }

    return result;
  }

  static int f(int x) {
    return (x <= 1) ? x : (1 + f(x / 2));
  }
}
