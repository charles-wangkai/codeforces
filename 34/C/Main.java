import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int[] pages = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).sorted().toArray();

    List<Range> ranges = new ArrayList<>();
    for (int page : pages) {
      if (ranges.isEmpty() || page > ranges.getLast().right + 1) {
        ranges.add(new Range(page, page));
      } else {
        ranges.getLast().right = page;
      }
    }

    return ranges.stream()
        .map(
            range ->
                (range.left == range.right)
                    ? String.valueOf(range.left)
                    : "%d-%d".formatted(range.left, range.right))
        .collect(Collectors.joining(","));
  }
}

class Range {
  int left;
  int right;

  Range(int left, int right) {
    this.left = left;
    this.right = right;
  }
}