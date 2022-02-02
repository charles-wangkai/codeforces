import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long hc = sc.nextLong();
      int dc = sc.nextInt();
      long hm = sc.nextLong();
      int dm = sc.nextInt();
      int k = sc.nextInt();
      int w = sc.nextInt();
      long a = sc.nextLong();

      System.out.println(solve(hc, dc, hm, dm, k, w, a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long hc, int dc, long hm, int dm, int k, int w, long a) {
    return IntStream.rangeClosed(0, k)
        .anyMatch(i -> isWin(hc + (k - i) * a, (long) dc + i * w, hm, dm));
  }

  static boolean isWin(long cHealth, long cDamage, long mHealth, int mDamage) {
    return (mHealth + cDamage - 1) / cDamage <= (cHealth + mDamage - 1) / mDamage;
  }
}