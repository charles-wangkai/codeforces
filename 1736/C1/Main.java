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

  static long solve(int[] a) {
    long result = 0;
    int endIndex = -1;
    for (int i = 0; i < a.length; ++i) {
      while (endIndex + 1 != a.length && a[endIndex + 1] >= endIndex + 2 - i) {
        ++endIndex;
      }

      result += endIndex - i + 1;
    }

    return result;
  }
}
