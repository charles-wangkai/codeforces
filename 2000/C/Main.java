import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
      int m = sc.nextInt();
      String[] s = new String[m];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static String solve(int[] a, String[] s) {
    int[] compressd = compress(a);

    return Arrays.stream(s)
        .map(si -> Arrays.equals(compress(si.chars().toArray()), compressd) ? "YES" : "NO")
        .collect(Collectors.joining("\n"));
  }

  static int[] compress(int[] values) {
    Map<Integer, Integer> valueToCompressed = new HashMap<>();
    for (int value : values) {
      if (!valueToCompressed.containsKey(value)) {
        valueToCompressed.put(value, valueToCompressed.size());
      }
    }

    return Arrays.stream(values).map(valueToCompressed::get).toArray();
  }
}