import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] counts = new int[10];
    for (char c : s.toCharArray()) {
      ++counts[c - '0'];
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      for (int j = 9 - i; ; ++j) {
        if (counts[j] != 0) {
          result.append(j);
          --counts[j];

          break;
        }
      }
    }

    return result.toString();
  }
}