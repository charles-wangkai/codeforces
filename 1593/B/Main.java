import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String n = sc.next();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(String n) {
    return Stream.of("00", "25", "50", "75")
        .mapToInt(suffix -> computeRemoveNum(n, suffix))
        .min()
        .getAsInt();
  }

  static int computeRemoveNum(String n, String suffix) {
    int lastIndex = n.length() - 1;
    for (int i = suffix.length() - 1; i >= 0; --i) {
      int index = n.lastIndexOf(suffix.charAt(i), lastIndex);
      if (index == -1) {
        return Integer.MAX_VALUE;
      }

      lastIndex = index - 1;
    }

    return n.length() - 1 - lastIndex - suffix.length();
  }
}
