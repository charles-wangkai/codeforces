import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] a = new int[r - l + 1];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, a));
    }

    sc.close();
  }

  static int solve(int l, int r, int[] a) {
    int twoPower = Integer.lowestOneBit(a.length);

    int[] sorted = Arrays.stream(a).map(ai -> ai / twoPower).sorted().distinct().toArray();

    int index = 0;
    while (index != sorted.length - 1
        && sorted[index] + 1 == sorted[index + 1]
        && sorted[index] % 2 == 0) {
      index += 2;
    }

    return (sorted[index] * twoPower) ^ (a.length - twoPower);
  }
}