import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }

      System.out.println(solve(w));
    }

    sc.close();
  }

  static int solve(int[] w) {
    int[] counts = new int[3];
    for (int wi : w) {
      ++counts[wi];
    }

    int common12 = Math.min(counts[1], counts[2]);

    return counts[0] + common12 + (counts[1] - common12) / 3 + (counts[2] - common12) / 3;
  }
}