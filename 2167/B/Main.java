import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    return buildKey(s).equals(buildKey(t));
  }

  static String buildKey(String str) {
    return str.chars()
        .sorted()
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}