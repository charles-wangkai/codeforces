import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    int result = 0;
    for (int power = 1; ; power *= 2) {
      for (int i = 0; i < k; ++i) {
        if (n < power) {
          return result;
        }

        n -= power;
        ++result;
      }
    }
  }
}