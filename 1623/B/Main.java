import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int[] l, int[] r) {
    Set<Range> ranges =
        IntStream.range(0, l.length)
            .mapToObj(i -> new Range(l[i], r[i]))
            .collect(Collectors.toSet());

    return IntStream.range(0, l.length)
        .mapToObj(
            i -> {
              for (int d = l[i]; ; ++d) {
                if ((d == l[i] || ranges.contains(new Range(l[i], d - 1)))
                    && (d == r[i] || ranges.contains(new Range(d + 1, r[i])))) {
                  return String.format("%d %d %d", l[i], r[i], d);
                }
              }
            })
        .collect(Collectors.joining("\n"));
  }
}

class Range {
  int left;
  int right;

  Range(int left, int right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public boolean equals(Object obj) {
    Range other = (Range) obj;

    return left == other.left && right == other.right;
  }
}