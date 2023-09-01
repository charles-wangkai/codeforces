import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a, String b) {
    return IntStream.range(0, a.length() - 1)
        .anyMatch(i -> a.startsWith("01", i) && b.startsWith("01", i));
  }
}
