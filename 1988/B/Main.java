import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a) {
    return a.chars().filter(c -> c == '1').count()
        > IntStream.range(0, a.length())
            .filter(i -> a.charAt(i) == '0' && (i == 0 || a.charAt(i - 1) == '1'))
            .count();
  }
}