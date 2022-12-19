import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int r0c0 = sc.nextInt();
      int r0c1 = sc.nextInt();
      int r1c0 = sc.nextInt();
      int r1c1 = sc.nextInt();

      System.out.println(solve(r0c0, r0c1, r1c0, r1c1) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int r0c0, int r0c1, int r1c0, int r1c1) {
    return check(r0c0, r0c1, r1c0, r1c1, 3);
  }

  static boolean check(int r0c0, int r0c1, int r1c0, int r1c1, int restRotateNum) {
    return (r0c0 < r0c1 && r1c0 < r1c1 && r0c0 < r1c0 && r0c1 < r1c1)
        || (restRotateNum != 0 && check(r1c0, r0c0, r1c1, r0c1, restRotateNum - 1));
  }
}
