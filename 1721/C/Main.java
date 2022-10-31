import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    return String.format("%s\n%s", computeMinPossibles(a, b), computeMaxPossibles(a, b));
  }

  static String computeMinPossibles(int[] a, int[] b) {
    int[] result = new int[a.length];
    int bIndex = 0;
    for (int i = 0; i < result.length; ++i) {
      while (b[bIndex] < a[i]) {
        ++bIndex;
      }
      result[i] = b[bIndex] - a[i];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static String computeMaxPossibles(int[] a, int[] b) {
    int[] result = new int[a.length];
    int bIndex = b.length - 1;
    for (int i = a.length - 1; i >= 0; --i) {
      result[i] = b[bIndex] - a[i];

      if (i != 0 && a[i] > b[i - 1]) {
        bIndex = i - 1;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
