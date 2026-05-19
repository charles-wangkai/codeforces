import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, a, b));
    }

    sc.close();
  }

  static long solve(int n, int a, int b) {
    long result = (n / 3L) * Math.min(3 * a, b);

    int rest = n % 3;
    if (rest != 0) {
      result += Math.min(rest * a, b);
    }

    return result;
  }
}