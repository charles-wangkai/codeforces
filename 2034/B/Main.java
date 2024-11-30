import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, m, k));
    }

    sc.close();
  }

  static int solve(String s, int m, int k) {
    int result = 0;
    int index = 0;
    int zeroCount = 0;
    while (index < s.length()) {
      if (s.charAt(index) == '0') {
        ++zeroCount;
        if (zeroCount == m) {
          ++result;
          zeroCount = 0;
          index += k;
        } else {
          ++index;
        }
      } else {
        zeroCount = 0;
        ++index;
      }
    }

    return result;
  }
}