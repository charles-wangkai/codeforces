import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int a3 = sc.nextInt();
      int a4 = sc.nextInt();

      System.out.println(solve(a1, a2, a3, a4));
    }

    sc.close();
  }

  static int solve(int a1, int a2, int a3, int a4) {
    return Math.max(
        Math.max(Math.min(a1, a2) * Math.min(a3, a4), Math.min(a1, a3) * Math.min(a2, a4)),
        Math.min(a1, a4) * Math.min(a2, a3));
  }
}