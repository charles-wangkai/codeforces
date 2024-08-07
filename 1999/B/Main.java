import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int b1 = sc.nextInt();
      int b2 = sc.nextInt();

      System.out.println(solve(a1, a2, b1, b2));
    }

    sc.close();
  }

  static int solve(int a1, int a2, int b1, int b2) {
    return ((isWin(a1, b1, a2, b2) ? 1 : 0) + (isWin(a1, b2, a2, b1) ? 1 : 0)) * 2;
  }

  static boolean isWin(int firstA, int firstB, int secondA, int secondB) {
    return !(firstA == firstB && secondA == secondB) && firstA >= firstB && secondA >= secondB;
  }
}