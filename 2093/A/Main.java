import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();

      System.out.println(solve(k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int k) {
    return k % 2 == 1;
  }
}