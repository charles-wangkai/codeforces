import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long p = sc.nextLong();
      long q = sc.nextLong();

      System.out.println(solve(p, q));
    }

    sc.close();
  }

  static String solve(long p, long q) {
    return (p >= q || 3 * p < 2 * q) ? "Alice" : "Bob";
  }
}