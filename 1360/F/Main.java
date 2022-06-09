import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      sc.nextInt();
      String[] a = new String[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.next();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(String[] a) {
    int m = a[0].length();

    for (int i = 0; i < m; ++i) {
      int i_ = i;
      OptionalInt otherIndex =
          IntStream.range(1, a.length).filter(j -> !isMatched(a[0], a[j], i_)).findAny();
      if (otherIndex.isPresent()) {
        String s =
            IntStream.range(0, m)
                .mapToObj(j -> String.valueOf(a[(j == i_) ? otherIndex.getAsInt() : 0].charAt(j)))
                .collect(Collectors.joining());
        if (check(a, s)) {
          return s;
        }
      } else {
        return IntStream.range(0, m)
            .mapToObj(j -> String.valueOf((j == i_) ? 'a' : a[0].charAt(j)))
            .collect(Collectors.joining());
      }
    }

    return "-1";
  }

  static boolean check(String[] a, String s) {
    return Arrays.stream(a)
        .allMatch(
            ai ->
                IntStream.range(0, s.length()).filter(j -> ai.charAt(j) != s.charAt(j)).count()
                    <= 1);
  }

  static boolean isMatched(String s1, String s2, int excludedIndex) {
    return IntStream.range(0, s1.length())
        .allMatch(i -> i == excludedIndex || s1.charAt(i) == s2.charAt(i));
  }
}