import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();

      System.out.println(solve(m));
    }

    sc.close();
  }

  static int solve(int m) {
    int round = 1;
    while (round * 10 <= m) {
      round *= 10;
    }

    return m - round;
  }
}