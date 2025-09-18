import java.util.Comparator;
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
    int[] sortedIndices =
        IntStream.range(0, p.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> p[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int leftIndex = sortedIndices[0];
    int rightIndex = sortedIndices[0];
    for (int i = 1; i < sortedIndices.length; ++i) {
      if (sortedIndices[i] == leftIndex - 1) {
        --leftIndex;
      } else if (sortedIndices[i] == rightIndex + 1) {
        ++rightIndex;
      } else {
        return false;
      }
    }

    return true;
  }
}