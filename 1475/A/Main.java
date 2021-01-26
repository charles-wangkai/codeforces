import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long n) {
    return Long.bitCount(n) != 1;
  }
}
