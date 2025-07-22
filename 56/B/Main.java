import java.util.Arrays;
import java.util.Scanner;
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
    int[] diffIndices = IntStream.range(0, a.length).filter(i -> a[i] != i + 1).toArray();
    if (diffIndices.length < 2) {
      return "0 0";
    }

    int[] values = IntStream.rangeClosed(1, a.length).toArray();
    for (int leftIndex = diffIndices[0], rightIndex = diffIndices[diffIndices.length - 1];
        leftIndex < rightIndex;
        ++leftIndex, --rightIndex) {
      int temp = values[leftIndex];
      values[leftIndex] = values[rightIndex];
      values[rightIndex] = temp;
    }

    return Arrays.equals(values, a)
        ? "%d %d".formatted(diffIndices[0] + 1, diffIndices[diffIndices.length - 1] + 1)
        : "0 0";
  }
}