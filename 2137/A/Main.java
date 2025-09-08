import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(k, x));
    }

    sc.close();
  }

  static int solve(int k, int x) {
    return x << k;
  }
}