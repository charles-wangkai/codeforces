import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    List<Segment> segments = new ArrayList<>();
    int beginIndex = 0;
    while (beginIndex != a.length) {
      int endIndex = beginIndex;
      Set<Integer> seen = new HashSet<>();
      while (endIndex != a.length && !seen.contains(a[endIndex])) {
        seen.add(a[endIndex]);
        ++endIndex;
      }

      if (endIndex == a.length) {
        if (segments.isEmpty()) {
          return "-1";
        }

        segments.getLast().endIndex = a.length - 1;

        break;
      } else {
        segments.add(new Segment(beginIndex, endIndex));
        beginIndex = endIndex + 1;
      }
    }

    return "%d\n%s"
        .formatted(
            segments.size(),
            segments.stream()
                .map(segment -> "%d %d".formatted(segment.beginIndex + 1, segment.endIndex + 1))
                .collect(Collectors.joining("\n")));
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
