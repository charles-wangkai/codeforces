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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int result = a.length;
    int aIndex = a.length - 1;
    for (int i = b.length - 1; i >= 0; --i) {
      while (aIndex != -1 && a[aIndex] > b[i]) {
        --aIndex;
      }

      if (aIndex != -1) {
        --result;
        --aIndex;
      }
    }

    return result;
  }
}