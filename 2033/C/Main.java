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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    for (int i = 1, j = a.length - 2; i < j; ++i, --j) {
      if (a[i] == a[i - 1] || a[j] == a[j + 1]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }

    return (int) IntStream.range(0, a.length - 1).filter(i -> a[i] == a[i + 1]).count();
  }
}