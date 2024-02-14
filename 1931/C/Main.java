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
    int n = a.length;

    if (Arrays.stream(a).distinct().count() == 1) {
      return 0;
    }

    int leftLength = 1;
    while (a[leftLength] == a[leftLength - 1]) {
      ++leftLength;
    }

    int rightLength = 1;
    while (a[n - rightLength - 1] == a[n - rightLength]) {
      ++rightLength;
    }

    return n
        - ((a[0] == a[n - 1]) ? (leftLength + rightLength) : Math.max(leftLength, rightLength));
  }
}