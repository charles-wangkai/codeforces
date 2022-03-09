import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();
      char c = sc.next().charAt(0);

      System.out.println(solve(s, c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, char c) {
    return IntStream.range(0, s.length()).anyMatch(i -> i % 2 == 0 && s.charAt(i) == c);
  }
}