import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int x = 0;
    int step = 1;
    for (int i = 0; ; ++i) {
      x += ((i % 2 == 0) ? -1 : 1) * step;
      if (Math.abs(x) > n) {
        return (i % 2 == 0) ? "Sakurako" : "Kosuke";
      }

      step += 2;
    }
  }
}