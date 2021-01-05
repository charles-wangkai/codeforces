import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int w = sc.nextInt();
      int h = sc.nextInt();
      int n = sc.nextInt();

      System.out.println(solve(w, h, n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int w, int h, int n) {
    return (1 << (Integer.numberOfTrailingZeros(w * h))) >= n;
  }
}
