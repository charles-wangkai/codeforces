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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] counts = new int[3];
    for (int ai : a) {
      ++counts[ai % 3];
    }

    int result = 0;
    for (int i = 0; i < 5; ++i) {
      int delta = Math.max(0, counts[i % counts.length] - a.length / 3);
      result += delta;
      counts[i % counts.length] -= delta;
      counts[(i + 1) % counts.length] += delta;
    }

    return result;
  }
}
