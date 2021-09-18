import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      long m = sc.nextLong();

      System.out.println(solve(l, r, m));
    }

    sc.close();
  }

  static String solve(int l, int r, long m) {
    for (int a = l; ; ++a) {
      int remainder = (int) (m % a);
      if (l + remainder <= r && m != remainder) {
        return String.format("%d %d %d", a, l + remainder, l);
      }
      if (a - remainder <= r - l) {
        return String.format("%d %d %d", a, r - (a - remainder), r);
      }
    }
  }
}
