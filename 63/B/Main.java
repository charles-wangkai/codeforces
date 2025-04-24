import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static int solve(int[] a, int k) {
    int[] counts = new int[k + 1];
    for (int ai : a) {
      ++counts[ai];
    }

    int result = 0;
    while (counts[k] != a.length) {
      for (int i = k - 1; i >= 1; --i) {
        if (counts[i] != 0) {
          --counts[i];
          ++counts[i + 1];
        }
      }

      ++result;
    }

    return result;
  }
}