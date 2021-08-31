import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int c = sc.nextInt();
      int d = sc.nextInt();

      System.out.println(solve(c, d));
    }

    sc.close();
  }

  static int solve(int c, int d) {
    if ((c + d) % 2 != 0) {
      return -1;
    }
    if (c == 0 && d == 0) {
      return 0;
    }

    return (c == d) ? 1 : 2;
  }
}
