import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static String solve(String s, int k) {
    int[] counts = new int[26];
    for (char c : s.toCharArray()) {
      ++counts[c - 'a'];
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < k; ++i) {
      int mex = 0;
      for (int j = 0; j < s.length() / k; ++j) {
        if (counts[mex] == 0) {
          break;
        }

        --counts[mex];
        ++mex;
      }

      result.append((char) ('a' + mex));
    }

    return result.toString();
  }
}