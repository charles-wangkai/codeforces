import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    if (N == 1) {
      return 3;
    }
    if (N == 2) {
      return 5;
    }

    return 7 + (N - 3) / 3 * 4 + (N - 3) % 3;
  }
}