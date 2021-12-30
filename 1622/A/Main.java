import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l1 = sc.nextInt();
      int l2 = sc.nextInt();
      int l3 = sc.nextInt();

      System.out.println(solve(l1, l2, l3) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int l1, int l2, int l3) {
    return l1 + l2 == l3
        || l2 + l3 == l1
        || l3 + l1 == l2
        || (l1 == l2 && l3 % 2 == 0)
        || (l2 == l3 && l1 % 2 == 0)
        || (l3 == l1 && l2 % 2 == 0);
  }
}
