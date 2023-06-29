import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c, x) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int[] c, int x) {
    int knowledge = 0;
    for (int[] stack : new int[][] {a, b, c}) {
      for (int rating : stack) {
        if ((rating | x) != x) {
          break;
        }

        knowledge |= rating;
      }
    }

    return knowledge == x;
  }
}
