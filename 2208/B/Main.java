import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int p = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k, p, m));
    }

    sc.close();
  }

  static int solve(int[] a, int k, int p, int m) {
    int result = 0;
    int[] indices = IntStream.range(0, a.length).toArray();
    while (true) {
      int chosen;

      int winIndex = -1;
      for (int i = 0; i < k; ++i) {
        if (indices[i] == p - 1) {
          winIndex = i;

          break;
        }
      }
      if (winIndex == -1) {
        chosen = 0;
        for (int i = 0; i < k; ++i) {
          if (a[indices[i]] < a[indices[chosen]]) {
            chosen = i;
          }
        }
      } else {
        chosen = winIndex;
      }

      if (a[indices[chosen]] > m) {
        break;
      }
      m -= a[indices[chosen]];

      if (winIndex != -1) {
        ++result;
      }

      indices = buildNextIndices(k, indices, chosen);
    }

    return result;
  }

  static int[] buildNextIndices(int k, int[] indices, int chosen) {
    int[] result = new int[indices.length];
    int pos = 0;

    for (int i = 0; i < k; ++i) {
      if (i != chosen) {
        result[pos] = indices[i];
        ++pos;
      }
    }
    for (int i = k; i < indices.length; ++i) {
      result[pos] = indices[i];
      ++pos;
    }

    result[pos] = indices[chosen];
    ++pos;

    return result;
  }
}