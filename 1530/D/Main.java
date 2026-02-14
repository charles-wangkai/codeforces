import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int[] b = new int[a.length];
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < a.length; ++i) {
      if (!seen.contains(a[i])) {
        b[i] = a[i];
        seen.add(a[i]);
      }
    }

    int[] indices = IntStream.range(0, b.length).filter(i -> b[i] == 0).toArray();
    int[] values = IntStream.rangeClosed(1, b.length).filter(x -> !seen.contains(x)).toArray();

    boolean[] used = new boolean[indices.length];
    int pos = -1;
    for (int value : values) {
      pos = findNextPos(used, pos);
      if (value == indices[pos] + 1) {
        pos = findNextPos(used, pos);
      }

      b[indices[pos]] = value;
      used[pos] = true;
    }

    OptionalInt sameIndex = IntStream.range(0, b.length).filter(i -> b[i] == i + 1).findAny();
    if (sameIndex.isPresent()) {
      int otherIndex =
          IntStream.range(0, a.length)
              .filter(i -> i != sameIndex.getAsInt() && a[i] == a[sameIndex.getAsInt()])
              .findAny()
              .getAsInt();

      int temp = b[sameIndex.getAsInt()];
      b[sameIndex.getAsInt()] = b[otherIndex];
      b[otherIndex] = temp;
    }

    return "%d\n%s"
        .formatted(
            IntStream.range(0, b.length).filter(i -> b[i] == a[i]).count(),
            Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int findNextPos(boolean[] used, int pos) {
    while (true) {
      pos = (pos + 1) % used.length;
      if (!used[pos]) {
        return pos;
      }
    }
  }
}