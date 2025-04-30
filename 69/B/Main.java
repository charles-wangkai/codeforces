import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] l = new int[m];
    int[] r = new int[m];
    int[] t = new int[m];
    int[] c = new int[m];
    for (int i = 0; i < m; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
      t[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(n, l, r, t, c));

    sc.close();
  }

  static int solve(int n, int[] l, int[] r, int[] t, int[] c) {
    int[] winners = new int[n];
    Arrays.fill(winners, -1);

    for (int i = 0; i < l.length; ++i) {
      for (int j = l[i] - 1; j <= r[i] - 1; ++j) {
        if (winners[j] == -1 || t[i] < t[winners[j]]) {
          winners[j] = i;
        }
      }
    }

    return Arrays.stream(winners).filter(winner -> winner != -1).map(winner -> c[winner]).sum();
  }
}