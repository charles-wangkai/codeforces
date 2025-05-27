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
    int[] counts = new int[2];
    for (char c : s.toCharArray()) {
      ++counts[c - '0'];
    }

    int diffPair = s.length() / 2 - k;

    return Math.min(counts[0], counts[1]) >= diffPair
        && (counts[0] - diffPair) % 2 == 0
        && (counts[1] - diffPair) % 2 == 0;
  }
}