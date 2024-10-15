import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int r = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, r));
    }

    sc.close();
  }

  static int solve(int[] a, int r) {
    int fullRow = Arrays.stream(a).map(ai -> ai / 2).sum();
    int restRow = r - fullRow;
    int aloneNum = Arrays.stream(a).map(ai -> ai % 2).sum();

    return fullRow * 2 + ((aloneNum <= restRow) ? aloneNum : (restRow * 2 - aloneNum));
  }
}