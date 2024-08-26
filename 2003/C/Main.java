import java.util.Scanner;

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

  static String solve(String s) {
    int[] counts = new int[26];
    for (char c : s.toCharArray()) {
      ++counts[c - 'a'];
    }

    StringBuilder result = new StringBuilder();
    while (result.length() != s.length()) {
      for (int i = 0; i < counts.length; ++i) {
        if (counts[i] != 0) {
          result.append((char) (i + 'a'));
          --counts[i];
        }
      }
    }

    return result.toString();
  }
}