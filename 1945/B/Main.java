import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long m = sc.nextLong();

      System.out.println(solve(a, b, m));
    }

    sc.close();
  }

  static long solve(long a, long b, long m) {
    return 2 + m / a + m / b;
  }
}