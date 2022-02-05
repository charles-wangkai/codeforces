import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[n][];
      for (int i = 0; i < a.length; ++i) {
        int k = sc.nextInt();
        a[i] = new int[k];
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int result = 0;
    int[] needed =
        Arrays.stream(a)
            .mapToInt(ai -> IntStream.range(0, ai.length).map(j -> ai[j] - j + 1).max().getAsInt())
            .toArray();
    int[] sortedIndices =
        IntStream.range(0, needed.length)
            .boxed()
            .sorted(Comparator.comparing(i -> needed[i]))
            .mapToInt(x -> x)
            .toArray();
    long power = 0;
    for (int index : sortedIndices) {
      if (power < needed[index]) {
        result += needed[index] - power;
        power = needed[index];
      }

      power += a[index].length;
    }

    return result;
  }
}