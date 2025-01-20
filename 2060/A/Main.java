import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int a4 = sc.nextInt();
      int a5 = sc.nextInt();

      System.out.println(solve(a1, a2, a4, a5));
    }

    sc.close();
  }

  static int solve(int a1, int a2, int a4, int a5) {
    return Math.max(
        Math.max(
            computeFibonacciness(a1, a2, a1 + a2, a4, a5),
            computeFibonacciness(a1, a2, a4 - a2, a4, a5)),
        computeFibonacciness(a1, a2, a5 - a4, a4, a5));
  }

  static int computeFibonacciness(int a1, int a2, int a3, int a4, int a5) {
    return ((a1 + a2 == a3) ? 1 : 0) + ((a2 + a3 == a4) ? 1 : 0) + ((a3 + a4 == a5) ? 1 : 0);
  }
}