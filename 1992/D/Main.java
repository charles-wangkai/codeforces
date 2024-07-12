import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      String a = sc.next();

      System.out.println(solve(a, m, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a, int m, int k) {
    boolean[] possibles = new boolean[a.length()];
    for (int i = possibles.length - 1; i >= 0; --i) {
      possibles[i] =
          (a.charAt(i) == 'L')
              || ((a.charAt(i) == 'W') && (i == possibles.length - 1 || possibles[i + 1]));
    }

    int swimCount = 0;
    int index = -1;
    while (index < a.length()) {
      if (index == -1 || a.charAt(index) == 'L') {
        int jump = findJump(a, m, possibles, index);
        if (jump == -1) {
          return false;
        }

        index += jump;
      } else {
        ++swimCount;
        ++index;
      }
    }

    return swimCount <= k;
  }

  static int findJump(String a, int m, boolean[] possibles, int index) {
    if (index + m >= a.length()) {
      return m;
    }

    for (int i = m; i >= 1; --i) {
      if (a.charAt(index + i) == 'L') {
        return i;
      }
    }

    for (int i = m; i >= 1; --i) {
      if (possibles[index + i]) {
        return i;
      }
    }

    return -1;
  }
}