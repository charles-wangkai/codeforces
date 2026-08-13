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

  static int solve(int[] a) {
    List<Range> ranges = new ArrayList<>();
    int beginIndex = 0;
    for (int i = 1; i <= a.length; ++i) {
      if (i == a.length || a[i] != a[i - 1]) {
        ranges.add(new Range(i - beginIndex, a[i - 1]));

        beginIndex = i;
      }
    }

    int result = ranges.size();
    if (IntStream.range(0, ranges.size() - 1)
        .anyMatch(i -> ranges.get(i).length() >= 2 && ranges.get(i + 1).length() >= 2)) {
      result += 2;
    } else if (IntStream.range(0, ranges.size())
        .anyMatch(
            i ->
                ranges.get(i).length() >= 2
                    && ((i != 0 && (i == 1 || ranges.get(i - 2).color() != ranges.get(i).color()))
                        || (i != ranges.size() - 1
                            && (i == ranges.size() - 2
                                || ranges.get(i + 2).color() != ranges.get(i).color()))))) {
      ++result;
    }

    return result;
  }
}

record Range(int length, int color) {}
