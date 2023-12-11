import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
    int uniqueNum = (int) Arrays.stream(a).distinct().count();
    if (k < uniqueNum && k == 1) {
      return -1;
    }
    if (k >= uniqueNum) {
      return 1;
    }

    return (uniqueNum - 1 + (k - 2)) / (k - 1);
  }
}