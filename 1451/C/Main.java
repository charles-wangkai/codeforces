import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b, k) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(String a, String b, int k) {
    int[] aCounts = buildCounts(a);
    int[] bCounts = buildCounts(b);
    for (int i = bCounts.length - 1; i >= 0; --i) {
      while (bCounts[i] != 0) {
        if (bCounts[i] >= k) {
          int j = i;
          while (j != -1 && aCounts[j] < k) {
            --j;
          }
          if (j == -1) {
            return false;
          }
          aCounts[j] -= k;
          bCounts[i] -= k;
        } else {
          if (aCounts[i] == 0) {
            return false;
          }
          --aCounts[i];
          --bCounts[i];
        }
      }
    }

    return true;
  }

  static int[] buildCounts(String s) {
    int[] counts = new int[26];
    for (char ch : s.toCharArray()) {
      ++counts[ch - 'a'];
    }

    return counts;
  }
}
