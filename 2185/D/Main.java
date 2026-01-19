import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int h = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[m];
      int[] c = new int[m];
      for (int i = 0; i < m; ++i) {
        b[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c, h));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c, int h) {
    Map<Integer, Integer> indexToDelta = new HashMap<>();
    for (int i = 0; i < b.length; ++i) {
      int index = b[i] - 1;

      indexToDelta.put(index, indexToDelta.getOrDefault(index, 0) + c[i]);
      if (a[index] + indexToDelta.get(index) > h) {
        indexToDelta.clear();
      }
    }

    return IntStream.range(0, a.length)
        .map(i -> a[i] + indexToDelta.getOrDefault(i, 0))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}