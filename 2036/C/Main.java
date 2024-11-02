import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "1100";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();
      int q = sc.nextInt();
      int[] positions = new int[q];
      int[] v = new int[q];
      for (int i = 0; i < q; ++i) {
        positions[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(s, positions, v));
    }

    sc.close();
  }

  static String solve(String s, int[] positions, int[] v) {
    char[] digits = s.toCharArray();

    Set<Integer> beginIndices =
        IntStream.range(0, s.length())
            .filter(i -> check(digits, i))
            .boxed()
            .collect(Collectors.toSet());

    String[] result = new String[positions.length];
    for (int i = 0; i < result.length; ++i) {
      digits[positions[i] - 1] = (char) (v[i] + '0');
      for (int beginIndex = positions[i] - TARGET.length();
          beginIndex <= positions[i] - 1;
          ++beginIndex) {
        if (check(digits, beginIndex)) {
          beginIndices.add(beginIndex);
        } else {
          beginIndices.remove(beginIndex);
        }
      }

      result[i] = beginIndices.isEmpty() ? "NO" : "YES";
    }

    return String.join("\n", result);
  }

  static boolean check(char[] digits, int beginIndex) {
    return beginIndex >= 0
        && beginIndex + TARGET.length() <= digits.length
        && IntStream.range(0, TARGET.length())
            .allMatch(i -> digits[beginIndex + i] == TARGET.charAt(i));
  }
}