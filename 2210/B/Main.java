import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    Set<Integer> marked = new HashSet<>();
    for (int i = 0; i < p.length; ++i) {
      if (marked.contains(i + 1)) {
        marked.remove(i + 1);
      }

      marked.add(p[i]);
      result = Math.max(result, marked.size());
    }

    return result;
  }
}