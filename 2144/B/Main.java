import java.util.Arrays;
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

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int[] zeroIndices = IntStream.range(0, p.length).filter(i -> p[i] == 0).toArray();
    if (zeroIndices.length == 1) {
      p[zeroIndices[0]] = IntStream.rangeClosed(1, p.length).sum() - Arrays.stream(p).sum();
    }

    int[] diffIndices = IntStream.range(0, p.length).filter(i -> p[i] != i + 1).toArray();

    return (diffIndices.length == 0)
        ? 0
        : (diffIndices[diffIndices.length - 1] - diffIndices[0] + 1);
  }
}