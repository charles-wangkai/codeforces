import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
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
      int[] l = new int[n];
      for (int i = 0; i < l.length; ++i) {
        l[i] = sc.nextInt();
      }

      System.out.println(solve(a, l));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l) {
    int[] unlockedIndices = IntStream.range(0, l.length).filter(i -> l[i] == 0).toArray();
    int[] sortedUnlockedValues =
        IntStream.range(0, l.length)
            .filter(i -> l[i] == 0)
            .map(i -> a[i])
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(x -> x)
            .toArray();
    for (int i = 0; i < unlockedIndices.length; ++i) {
      a[unlockedIndices[i]] = sortedUnlockedValues[i];
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
