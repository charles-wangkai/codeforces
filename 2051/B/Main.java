import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(n, a, b, c));
    }

    sc.close();
  }

  static int solve(int n, int a, int b, int c) {
    int result = n / (a + b + c) * 3;
    n %= a + b + c;

    int[] distances = {a, b, c};
    for (int distance : distances) {
      if (n <= 0) {
        break;
      }

      ++result;
      n -= distance;
    }

    return result;
  }
}