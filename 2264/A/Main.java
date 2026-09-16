import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] p) {
    int[] diffIndices = IntStream.range(0, p.length).filter(i -> p[i] != i + 1).toArray();
    for (int i = 0, j = diffIndices.length - 1; i < j; ++i, --j) {
      int temp = p[diffIndices[i]];
      p[diffIndices[i]] = p[diffIndices[j]];
      p[diffIndices[j]] = temp;
    }

    return IntStream.range(0, p.length - 1).allMatch(i -> p[i] < p[i + 1]);
  }
}