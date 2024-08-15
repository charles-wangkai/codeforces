import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int n = a.length;

    boolean[] occupied = new boolean[n];
    for (int i = 0; i < a.length; ++i) {
      if (i != 0 && (a[i] == 1 || !occupied[a[i] - 2]) && (a[i] == n || !occupied[a[i]])) {
        return false;
      }

      occupied[a[i] - 1] = true;
    }

    return true;
  }
}