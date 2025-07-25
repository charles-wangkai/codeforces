import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(n, u, v));

    sc.close();
  }

  static int solve(int n, int[] u, int[] v) {
    int maxDiv2Difficulty = 1;
    int minDiv1Difficulty = n;
    for (int i = 0; i < u.length; ++i) {
      maxDiv2Difficulty = Math.max(maxDiv2Difficulty, Math.min(u[i], v[i]));
      minDiv1Difficulty = Math.min(minDiv1Difficulty, Math.max(u[i], v[i]));
    }

    return Math.max(0, minDiv1Difficulty - maxDiv2Difficulty);
  }
}