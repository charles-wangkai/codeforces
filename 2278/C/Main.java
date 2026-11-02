import java.util.Arrays;
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
    int[] indices = IntStream.range(0, a.length).filter(i -> a[i] != 1).toArray();
    if (indices.length == 0) {
      return -1;
    }
    if (Arrays.stream(indices).allMatch(index -> index == 0 || index == a.length - 1)) {
      return a[0] + a[a.length - 1] - 1;
    }

    return Arrays.stream(a).sum() - 1;
  }
}