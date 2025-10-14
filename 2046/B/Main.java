import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
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
    int[] offsets = new int[a.length];
    Arrays.fill(offsets, -1);

    int min = Integer.MAX_VALUE;
    for (int i = offsets.length - 1; i >= 0; --i) {
      if (a[i] > min) {
        offsets[i] = 1;
      } else {
        min = a[i];
      }
    }

    OptionalInt minIncreased =
        IntStream.range(0, offsets.length).filter(i -> offsets[i] == 1).map(i -> a[i] + 1).min();

    for (int i = 0; i < offsets.length; ++i) {
      if (offsets[i] == -1) {
        offsets[i] = (minIncreased.isPresent() && a[i] > minIncreased.getAsInt()) ? 1 : 0;
      }
    }

    return IntStream.range(0, a.length)
        .map(i -> a[i] + offsets[i])
        .sorted()
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}