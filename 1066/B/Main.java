import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int r = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, r));

    sc.close();
  }

  static int solve(int[] a, int r) {
    int result = 0;
    int index = 0;
    while (index < a.length) {
      OptionalInt heaterIndex =
          IntStream.rangeClosed(index - r + 1, index + r - 1)
              .filter(i -> i >= 0 && i < a.length && a[i] == 1)
              .max();
      if (heaterIndex.isEmpty()) {
        return -1;
      }

      ++result;
      index = heaterIndex.getAsInt() + r;
    }

    return result;
  }
}