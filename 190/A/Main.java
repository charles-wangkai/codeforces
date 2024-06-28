import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static String solve(int n, int m) {
    if (n == 0 && m != 0) {
      return "Impossible";
    }

    int minFare = Math.max(n, m);
    int maxFare = n + m - ((m == 0) ? 0 : 1);

    return "%d %d".formatted(minFare, maxFare);
  }
}