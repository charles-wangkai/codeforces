import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(int[] s) {
    int[] result = new int[s.length];
    int beginIndex = 0;
    while (beginIndex != s.length) {
      int endIndex = beginIndex;
      while (endIndex + 1 != s.length && s[endIndex + 1] == s[endIndex]) {
        ++endIndex;
      }

      if (endIndex == beginIndex) {
        return "-1";
      }

      for (int i = beginIndex; i <= endIndex; ++i) {
        result[i] = ((i == endIndex) ? beginIndex : (i + 1)) + 1;
      }

      beginIndex = endIndex + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}