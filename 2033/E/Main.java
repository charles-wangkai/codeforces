// https://codeforces.com/blog/entry/135520

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int result = 0;
    boolean[] visited = new boolean[p.length];
    for (int i = 0; i < visited.length; ++i) {
      if (!visited[i]) {
        result += (search(visited, p, i) - 1) / 2;
      }
    }

    return result;
  }

  static int search(boolean[] visited, int[] p, int index) {
    int result = 0;
    while (!visited[index]) {
      visited[index] = true;
      ++result;
      index = p[index] - 1;
    }

    return result;
  }
}