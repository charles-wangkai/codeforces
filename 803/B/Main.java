import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int[] leftDistances = buildLeftDistances(a);
    int[] rightDistances = buildRightDistances(a);

    return IntStream.range(0, a.length)
        .map(i -> Math.min(leftDistances[i], rightDistances[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int[] buildLeftDistances(int[] a) {
    int[] result = new int[a.length];
    int zeroIndex = -1;
    for (int i = 0; i < result.length; ++i) {
      if (a[i] == 0) {
        zeroIndex = i;
      }

      result[i] = (zeroIndex == -1) ? Integer.MAX_VALUE : (i - zeroIndex);
    }

    return result;
  }

  static int[] buildRightDistances(int[] a) {
    int[] result = new int[a.length];
    int zeroIndex = -1;
    for (int i = result.length - 1; i >= 0; --i) {
      if (a[i] == 0) {
        zeroIndex = i;
      }

      result[i] = (zeroIndex == -1) ? Integer.MAX_VALUE : (zeroIndex - i);
    }

    return result;
  }
}