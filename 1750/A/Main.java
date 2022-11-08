import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    for (int k = a.length - 1; k >= 0; --k) {
      if (a[k] != k + 1) {
        int k_ = k;
        int j = IntStream.range(0, k).filter(x -> a[x] == k_ + 1).findAny().getAsInt();
        if (IntStream.range(0, j).allMatch(x -> a[x] > a[k_])) {
          return false;
        }

        int temp = a[j];
        a[j] = a[k];
        a[k] = temp;
      }
    }

    return true;
  }
}
