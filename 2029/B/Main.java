import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();
      String r = sc.next();

      System.out.println(solve(s, r) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String r) {
    int[] counts = new int[2];
    for (char c : s.toCharArray()) {
      ++counts[c - '0'];
    }

    for (char c : r.toCharArray()) {
      if (counts[0] == 0 || counts[1] == 0) {
        return false;
      }

      --counts[1 - (c - '0')];
    }

    return true;
  }
}