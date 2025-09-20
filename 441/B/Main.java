import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int v = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, v));

    sc.close();
  }

  static int solve(int[] a, int[] b, int v) {
    int[] fruitNums = new int[Arrays.stream(a).max().getAsInt() + 2];
    for (int i = 0; i < a.length; ++i) {
      fruitNums[a[i]] += b[i];
    }

    int result = 0;
    for (int i = 1; i < fruitNums.length; ++i) {
      int prev = Math.min(fruitNums[i - 1], v);
      int curr = Math.min(fruitNums[i], v - prev);

      result += prev + curr;
      fruitNums[i] -= curr;
    }

    return result;
  }
}