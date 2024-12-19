import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int l1 = sc.nextInt();
      int r1 = sc.nextInt();
      int l2 = sc.nextInt();
      int r2 = sc.nextInt();

      System.out.println(solve(k, l1, r1, l2, r2));
    }

    sc.close();
  }

  static long solve(int k, int l1, int r1, int l2, int r2) {
    long result = 0;
    for (long power = 1; l1 * power <= r2; power *= k) {
      result += Math.max(0, Math.min(r1, r2 / power) - Math.max(l1, (l2 + power - 1) / power) + 1);
    }

    return result;
  }
}