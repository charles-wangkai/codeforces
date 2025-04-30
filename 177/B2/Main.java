import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    for (int i = 2; i * i <= n; ++i) {
      if (n % i == 0) {
        return n + solve(n / i);
      }
    }

    return n + 1;
  }
}