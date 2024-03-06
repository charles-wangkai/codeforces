import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int mex = 0;
    while (set.contains(mex)) {
      ++mex;
    }

    List<Segment> segments = new ArrayList<>();
    int beginIndex = 0;
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < a.length; ++i) {
      if (a[i] < mex) {
        seen.add(a[i]);
      }
      if (seen.size() == mex) {
        segments.add(new Segment(beginIndex, i));

        beginIndex = i + 1;
        seen.clear();
      }
    }

    if (!segments.isEmpty()) {
      segments.get(segments.size() - 1).endIndex = a.length - 1;
    }

    return segments.size() > 1
        ? String.format(
            "%d\n%s",
            segments.size(),
            segments.stream()
                .map(
                    segment -> String.format("%d %d", segment.beginIndex + 1, segment.endIndex + 1))
                .collect(Collectors.joining("\n")))
        : "-1";
  }
}

class Segment {
  int beginIndex;
  int endIndex;

  Segment(int beginIndex, int endIndex) {
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
  }
}
