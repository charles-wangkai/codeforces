import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h));
    }

    sc.close();
  }

  static String solve(int[] h) {
    Arrays.sort(h);

    int[] arrangement = new int[h.length];
    int leftIndex = 0;
    int rightIndex = arrangement.length - 1;
    boolean leftOrRight = true;
    int visibleCount = 0;
    for (int hi : h) {
      if (leftOrRight) {
        if (leftIndex == 0 || hi != arrangement[leftIndex - 1]) {
          ++visibleCount;
        }

        arrangement[leftIndex] = hi;
        ++leftIndex;
      } else {
        if (rightIndex == arrangement.length - 1 || hi != arrangement[rightIndex + 1]) {
          ++visibleCount;
        }

        arrangement[rightIndex] = hi;
        --rightIndex;
      }

      leftOrRight ^= true;
    }

    return "%d\n%s"
        .formatted(
            visibleCount,
            Arrays.stream(arrangement).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}