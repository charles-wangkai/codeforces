import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b, k) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] b, int k) {
    int index = b.length - 1;
    boolean[] visited = new boolean[b.length];
    for (int i = 0; i < k; ++i) {
      if (b[index] > b.length) {
        return false;
      }

      if (visited[index]) {
        return true;
      }
      visited[index] = true;

      index = Math.floorMod(index - b[index], b.length);
    }

    return true;
  }
}