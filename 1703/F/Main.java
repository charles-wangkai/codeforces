import java.util.Arrays;
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

  static long solve(int[] a) {
    int[] candidateIndices = IntStream.range(0, a.length).filter(i -> a[i] < i + 1).toArray();
    int[] sortedValues = Arrays.stream(candidateIndices).map(i -> a[i]).sorted().toArray();

    return Arrays.stream(candidateIndices)
        .map(i -> findGreaterNum(sortedValues, i + 1))
        .asLongStream()
        .sum();
  }

  static int findGreaterNum(int[] sortedValues, int target) {
    int index = sortedValues.length;
    int lower = 0;
    int upper = sortedValues.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (sortedValues[middle] > target) {
        index = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return sortedValues.length - index;
  }
}