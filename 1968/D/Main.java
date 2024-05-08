import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int pb = sc.nextInt();
      int ps = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(p, a, k, pb, ps));
    }

    sc.close();
  }

  static String solve(int[] p, int[] a, int k, int pb, int ps) {
    long scoreB = computeScore(p, a, k, pb);
    long scoreS = computeScore(p, a, k, ps);

    if (scoreB > scoreS) {
      return "Bodya";
    }
    if (scoreB < scoreS) {
      return "Sasha";
    }

    return "Draw";
  }

  static long computeScore(int[] p, int[] a, int k, int pos) {
    int n = p.length;

    long result = -1;
    boolean[] visited = new boolean[n];
    int index = pos - 1;
    long sum = 0;
    for (int i = 0; i < k && !visited[index]; ++i) {
      visited[index] = true;
      sum += a[index];
      result = Math.max(result, sum + a[index] * (k - i - 1L));

      index = p[index] - 1;
    }

    return result;
  }
}