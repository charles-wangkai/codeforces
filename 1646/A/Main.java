import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long s = sc.nextLong();

      System.out.println(solve(n, s));
    }

    sc.close();
  }

  static long solve(int n, long s) {
    return s / ((long) n * n);
  }
}