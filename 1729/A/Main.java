import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int a, int b, int c) {
    int time1 = Math.abs(a - 1);
    int time2 = Math.abs(b - c) + Math.abs(c - 1);

    if (time1 < time2) {
      return 1;
    }
    if (time1 > time2) {
      return 2;
    }

    return 3;
  }
}