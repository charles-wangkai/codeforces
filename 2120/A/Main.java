import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l1 = sc.nextInt();
      int b1 = sc.nextInt();
      int l2 = sc.nextInt();
      int b2 = sc.nextInt();
      int l3 = sc.nextInt();
      int b3 = sc.nextInt();

      System.out.println(solve(l1, b1, l2, b2, l3, b3) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int l1, int b1, int l2, int b2, int l3, int b3) {
    return (b1 == b2 && b2 == b3 && l1 + l2 + l3 == b1)
        || (l2 == l3 && b2 + b3 == b1 && l1 + l2 == b1)
        || (l1 == l2 && l2 == l3 && b1 + b2 + b3 == l1)
        || (b2 == b3 && l2 + l3 == l1 && b1 + b2 == l1);
  }
}