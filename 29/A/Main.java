import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    int[] d = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(x, d) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] x, int[] d) {
    for (int i = 0; i < x.length; ++i) {
      for (int j = i + 1; j < x.length; ++j) {
        if (x[i] + d[i] == x[j] && x[j] + d[j] == x[i]) {
          return true;
        }
      }
    }

    return false;
  }
}