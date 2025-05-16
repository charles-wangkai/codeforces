import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] l = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(l, r) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] l, int[] r) {
    int[] sortedIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(Comparator.comparing(i -> l[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    boolean[] used = new boolean[sortedIndices.length];
    for (int i = 0; i < 2; ++i) {
      int prev = -1;
      for (int j = 0; j < used.length; ++j) {
        if (!used[j] && l[sortedIndices[j]] > prev) {
          used[j] = true;
          prev = r[sortedIndices[j]];
        }
      }
    }

    return IntStream.range(0, used.length).allMatch(i -> used[i]);
  }
}