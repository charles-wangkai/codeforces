import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[n][];
      for (int i = 0; i < a.length; ++i) {
        int m = sc.nextInt();
        a[i] = new int[m];
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[][] a) {
    for (int[] ai : a) {
      Arrays.sort(ai);
    }

    return Arrays.stream(a).mapToInt(ai -> ai[1]).asLongStream().sum()
        - Arrays.stream(a).mapToInt(ai -> ai[1]).min().getAsInt()
        + Arrays.stream(a).mapToInt(ai -> ai[0]).min().getAsInt();
  }
}
