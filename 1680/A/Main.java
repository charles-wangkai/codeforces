import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l1 = sc.nextInt();
      int r1 = sc.nextInt();
      int l2 = sc.nextInt();
      int r2 = sc.nextInt();

      System.out.println(solve(l1, r1, l2, r2));
    }

    sc.close();
  }

  static int solve(int l1, int r1, int l2, int r2) {
    int lower = Math.max(l1, l2);
    int upper = Math.min(r1, r2);

    return (lower <= upper) ? lower : (l1 + l2);
  }
}