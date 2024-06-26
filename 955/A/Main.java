import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int hh = sc.nextInt();
    int mm = sc.nextInt();
    int H = sc.nextInt();
    int D = sc.nextInt();
    int C = sc.nextInt();
    int N = sc.nextInt();

    System.out.println(String.format("%.9f", solve(hh, mm, H, D, C, N)));

    sc.close();
  }

  static double solve(int hh, int mm, int H, int D, int C, int N) {
    return Math.min(
        (H + N - 1) / N * C, (H + D * Math.max(0, 20 * 60 - (hh * 60 + mm)) + N - 1) / N * C * 0.8);
  }
}