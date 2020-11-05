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
    return Math.min(computeMinOperNum(s, '0'), computeMinOperNum(s, '1'));
  }

  static int computeMinOperNum(String s, char targetAtEvenIndex) {
    Boolean[] matched =
        IntStream.range(0, s.length())
            .mapToObj(i -> (i % 2 == 0) == (s.charAt(i) == targetAtEvenIndex))
            .toArray(Boolean[]::new);

    return (int)
        IntStream.range(0, matched.length)
            .filter(i -> !matched[i] && (i == 0 || matched[i - 1]))
            .count();
  }
}
