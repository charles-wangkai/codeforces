import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int result = 0;
    int maxEnd = -1;
    for (int index : sortedIndices) {
      if (b[index] > maxEnd) {
        maxEnd = b[index];
      } else {
        ++result;
      }
    }

    return result;
  }
}