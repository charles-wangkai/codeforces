import java.util.Scanner;

public class Main implements Runnable {
  public static void main(String[] args) {
    new Thread(null, new Main(), "Main", 1 << 28).start();
  }

  public void run() {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String s = sc.next();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(s, l, r));
    }

    sc.close();
  }

  static int solve(String s, int[] l, int[] r) {
    return search(s, l, r, 0);
  }

  static int search(String s, int[] l, int[] r, int node) {
    if (l[node] == 0 && r[node] == 0) {
      return 0;
    }

    int result = Integer.MAX_VALUE;
    if (l[node] != 0) {
      result = Math.min(result, ((s.charAt(node) == 'L') ? 0 : 1) + search(s, l, r, l[node] - 1));
    }
    if (r[node] != 0) {
      result = Math.min(result, ((s.charAt(node) == 'R') ? 0 : 1) + search(s, l, r, r[node] - 1));
    }

    return result;
  }
}