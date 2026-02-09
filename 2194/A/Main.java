import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int w = sc.nextInt();

      System.out.println(solve(n, w));
    }

    sc.close();
  }

  static int solve(int n, int w) {
    return n - n / w;
  }
}