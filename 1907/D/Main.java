import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static int solve(int[] l, int[] r) {
    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(r).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(l, r, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] l, int[] r, int distance) {
    int left = 0;
    int right = 0;
    for (int i = 0; i < l.length; ++i) {
      int nextLeft = Math.max(l[i], left - distance);
      int nextRight = Math.min(r[i], right + distance);
      if (nextLeft > nextRight) {
        return false;
      }

      left = nextLeft;
      right = nextRight;
    }

    return true;
  }
}