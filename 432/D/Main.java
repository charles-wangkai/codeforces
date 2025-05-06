// https://codeforces.com/blog/entry/12310
// https://cp-algorithms.com/string/prefix-function.html
// https://cp-algorithms.com/string/z-function.html

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int[] pi = prefixFunction(s);

    int[] z = zFunction(s);
    int[] counts = new int[s.length()];
    for (int zi : z) {
      ++counts[zi];
    }

    int[] suffixSums = new int[counts.length + 1];
    for (int i = suffixSums.length - 2; i >= 0; --i) {
      suffixSums[i] = suffixSums[i + 1] + counts[i];
    }

    List<String> outputs = new ArrayList<>();
    int length = s.length();
    while (length != 0) {
      outputs.add("%d %d".formatted(length, suffixSums[length] + 1));

      length = pi[length - 1];
    }
    Collections.reverse(outputs);

    return "%d\n%s".formatted(outputs.size(), String.join("\n", outputs));
  }

  static int[] zFunction(String s) {
    int n = s.length();

    int[] z = new int[n];
    int l = 0;
    int r = 0;
    for (int i = 1; i < n; ++i) {
      if (i < r) {
        z[i] = Math.min(r - i, z[i - l]);
      }
      while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
        ++z[i];
      }
      if (i + z[i] > r) {
        l = i;
        r = i + z[i];
      }
    }

    return z;
  }

  static int[] prefixFunction(String s) {
    int n = s.length();

    int[] pi = new int[n];
    for (int i = 1; i < n; ++i) {
      int j = pi[i - 1];
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = pi[j - 1];
      }
      if (s.charAt(i) == s.charAt(j)) {
        ++j;
      }
      pi[i] = j;
    }

    return pi;
  }
}
