import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    reverse(p, 0, p.length - 1);

    if (p.length != 1) {
      int leftMaxIndex =
          IntStream.range(0, p.length - 1).boxed().max(Comparator.comparing(i -> p[i])).get();

      int rightBeginIndex;
      if (leftMaxIndex == 0) {
        rightBeginIndex = 1;
      } else {
        reverse(p, 0, leftMaxIndex);

        rightBeginIndex = leftMaxIndex + 2;
      }

      if (rightBeginIndex <= p.length - 1) {
        int firstIndex =
            IntStream.range(rightBeginIndex, p.length)
                .filter(i -> p[i] <= p[p.length - 1])
                .findFirst()
                .getAsInt();
        reverse(p, firstIndex, p.length - 1);
      }
    }

    return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void reverse(int[] p, int beginIndex, int endIndex) {
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      int temp = p[i];
      p[i] = p[j];
      p[j] = temp;
    }
  }
}
