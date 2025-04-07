import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a, String b) {
    int n = a.length();

    return computeOneNum(a, b) <= n / 2 && computeOneNum(b, a) <= (n + 1) / 2;
  }

  static int computeOneNum(String s1, String s2) {
    return IntStream.range(0, s1.length()).map(i -> ((i % 2 == 0) ? s1 : s2).charAt(i) - '0').sum();
  }
}