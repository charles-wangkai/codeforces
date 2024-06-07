import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    int result = -1;
    for (int i = 1; i * i <= n; ++i) {
      if (n % i == 0) {
        result = 2 * (i + n / i);
      }
    }

    return result;
  }
}