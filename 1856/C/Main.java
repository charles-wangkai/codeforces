import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 200_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    return IntStream.range(0, a.length).map(i -> findMax(a, k, i)).max().getAsInt();
  }

  static int findMax(int[] a, int k, int index) {
    int result = -1;
    int lower = a[index];
    int upper = LIMIT;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, k, index, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int k, int index, int target) {
    long operationNum = 0;
    for (int i = index; i <= a.length; ++i) {
      if (i == a.length) {
        return false;
      }
      if (target <= a[i]) {
        break;
      }

      operationNum += target - a[i];
      --target;
    }

    return operationNum <= k;
  }
}