import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();

    System.out.println(solve(n, a));

    sc.close();
  }

  static int solve(int n, int a) {
    return (a % 2 == 0) ? (n / 2 - a / 2 + 1) : (a / 2 + 1);
  }
}