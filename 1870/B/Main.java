import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int orB = Arrays.stream(b).reduce((acc, x) -> acc | x).getAsInt();

    int minX;
    int maxX;
    if (a.length % 2 == 0) {
      minX = Arrays.stream(a).map(ai -> ai | orB).reduce((acc, x) -> acc ^ x).getAsInt();
      maxX = Arrays.stream(a).reduce((acc, x) -> acc ^ x).getAsInt();
    } else {
      minX = Arrays.stream(a).reduce((acc, x) -> acc ^ x).getAsInt();
      maxX = Arrays.stream(a).map(ai -> ai | orB).reduce((acc, x) -> acc ^ x).getAsInt();
    }

    return String.format("%d %d", minX, maxX);
  }
}
