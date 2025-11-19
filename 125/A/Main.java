import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    if (n % 3 == 2) {
      ++n;
    }

    return "%d %d".formatted(n / 36, n % 36 / 3);
  }
}