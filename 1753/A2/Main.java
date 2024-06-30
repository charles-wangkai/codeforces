import java.util.ArrayList;
import java.util.List;
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

  static String solve(int[] a) {
    int[] indices = IntStream.range(0, a.length).filter(i -> a[i] != 0).toArray();
    if (indices.length % 2 == 1) {
      return "-1";
    }

    List<String> segments = new ArrayList<>();
    if (indices.length == 0) {
      segments.add(String.format("%d %d", 1, a.length));
    } else {
      if (indices[0] != 0) {
        segments.add(String.format("%d %d", 1, indices[0]));
      }
      for (int i = 0; i < indices.length; i += 2) {
        int end = (i + 2 == indices.length) ? a.length : indices[i + 2];

        if (a[indices[i]] == a[indices[i + 1]]) {
          if (indices[i] + 1 == indices[i + 1]) {
            segments.add(String.format("%d %d", indices[i] + 1, end));
          } else {
            segments.add(String.format("%d %d", indices[i] + 1, indices[i + 1] - 1));
            segments.add(String.format("%d %d", indices[i + 1], end));
          }
        } else {
          segments.add(String.format("%d %d", indices[i] + 1, indices[i + 1]));
          segments.add(String.format("%d %d", indices[i + 1] + 1, end));
        }
      }
    }

    return "%d\n%s".formatted(segments.size(), String.join("\n", segments));
  }
}
