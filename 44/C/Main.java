import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static String solve(int n, int[] a, int[] b) {
    int[] counts = new int[n];
    for (int i = 0; i < a.length; ++i) {
      for (int j = a[i] - 1; j <= b[i] - 1; ++j) {
        ++counts[j];
      }
    }

    for (int i = 0; i < counts.length; ++i) {
      if (counts[i] != 1) {
        return "%d %d".formatted(i + 1, counts[i]);
      }
    }

    return "OK";
  }
}