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
    int[] twoIndices = IntStream.range(0, a.length).filter(i -> a[i] == 2).toArray();
    if (twoIndices.length % 2 == 1) {
      return -1;
    }

    return (twoIndices.length == 0) ? 1 : (twoIndices[twoIndices.length / 2 - 1] + 1);
  }
}
