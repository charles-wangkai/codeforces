import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }
    int T = sc.nextInt();

    System.out.println(solve(t, T));

    sc.close();
  }

  static int solve(int[] t, int T) {
    Arrays.sort(t);

    int result = -1;
    for (int i = 0; i < t.length; ++i) {
      for (int j = i; j < t.length; ++j) {
        if (t[j] - t[i] <= T) {
          result = Math.max(result, j - i + 1);
        }
      }
    }

    return result;
  }
}