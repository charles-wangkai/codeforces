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
    return IntStream.range(0, a.length()).filter(i -> i % 2 == 0 && a.charAt(i) == '0').count()
            == IntStream.range(0, b.length()).filter(i -> i % 2 == 0 && b.charAt(i) == '0').count()
        && IntStream.range(0, a.length()).filter(i -> i % 2 == 1 && a.charAt(i) == '0').count()
            == IntStream.range(0, b.length()).filter(i -> i % 2 == 1 && b.charAt(i) == '0').count();
  }
}