import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int[] sameIndices =
        IntStream.range(0, s.length() - 1).filter(i -> s.charAt(i) == s.charAt(i + 1)).toArray();
    if (sameIndices.length < 2) {
      return true;
    }

    int beginIndex = sameIndices[0] + 1;
    int endIndex = sameIndices[sameIndices.length - 1];

    return isAlternating(
            "%s%s%s"
                .formatted(
                    s.substring(0, beginIndex),
                    reverse(s.substring(beginIndex, endIndex + 1)),
                    s.substring(endIndex + 1)))
        || isAlternating(
            "%s%s%s"
                .formatted(
                    s.substring(0, beginIndex),
                    reverse(invert(s.substring(beginIndex, endIndex + 1))),
                    s.substring(endIndex + 1)));
  }

  static String invert(String str) {
    return str.chars()
        .mapToObj(c -> (char) ('a' + 'b' - c))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  static boolean isAlternating(String str) {
    return IntStream.range(0, str.length() - 1).allMatch(i -> str.charAt(i) != str.charAt(i + 1));
  }
}