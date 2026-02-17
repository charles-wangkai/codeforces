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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    for (int i = 0; i < a.length; ++i) {
      int[] indices =
          IntStream.iterate(i, index -> index < a.length, index -> index * 2 + 1).toArray();
      int[] values = Arrays.stream(indices).map(index -> a[index]).sorted().toArray();
      for (int j = 0; j < indices.length; ++j) {
        a[indices[j]] = values[j];
      }
    }

    return IntStream.range(0, a.length - 1).allMatch(i -> a[i] < a[i + 1]);
  }
}