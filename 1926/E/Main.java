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
    int remainder = 1;
    int cycle = 2;
    while (true) {
      int number = (n - remainder) / cycle + 1;
      if (k <= number) {
        return (k - 1) * cycle + remainder;
      }

      k -= number;
      remainder *= 2;
      cycle *= 2;
    }
  }
}