import java.util.Arrays;
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
    Arrays.sort(a);

    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int waitingTime) {
    int carverCount = 0;
    long upper = -1;
    for (int ai : a) {
      if (ai > upper) {
        ++carverCount;
        upper = ai + 2L * waitingTime;
      }
    }

    return carverCount <= 3;
  }
}
