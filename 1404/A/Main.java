import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, int k) {
    char[] chs = s.toCharArray();
    for (int i = 0; i < k; ++i) {
      char target = chs[i];
      for (int j = i + k; j < chs.length; j += k) {
        if (chs[j] != '?') {
          if (target != '?' && chs[j] != target) {
            return false;
          }

          target = chs[j];
        }
      }

      chs[i] = target;
    }

    int count0 = 0;
    int count1 = 0;
    int countMask = 0;
    for (int i = 0; i < k; ++i) {
      if (chs[i] == '0') {
        ++count0;
      } else if (chs[i] == '1') {
        ++count1;
      } else {
        ++countMask;
      }
    }

    return Math.abs(count0 - count1) <= countMask;
  }
}
