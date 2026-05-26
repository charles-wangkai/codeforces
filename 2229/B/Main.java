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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > b[i]) {
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
      }
    }

    return Arrays.stream(a).max().getAsInt() + Arrays.stream(b).asLongStream().sum();
  }
}