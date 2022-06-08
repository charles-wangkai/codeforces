import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    int result = Integer.MAX_VALUE;
    int wCount = (int) IntStream.range(0, k - 1).filter(i -> s.charAt(i) == 'W').count();
    for (int endIndex = k - 1; endIndex < s.length(); ++endIndex) {
      wCount += (s.charAt(endIndex) == 'W') ? 1 : 0;
      result = Math.min(result, wCount);

      wCount -= (s.charAt(endIndex - k + 1) == 'W') ? 1 : 0;
    }

    return result;
  }
}