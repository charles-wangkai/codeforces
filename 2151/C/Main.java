import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[2 * n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int n = a.length / 2;

    int leftIndex = n - 1;
    long leftSum = IntStream.rangeClosed(0, leftIndex).map(i -> a[i]).asLongStream().sum();

    int rightIndex = n;
    long rightSum = IntStream.range(rightIndex, a.length).map(i -> a[i]).asLongStream().sum();

    long middle = 0;

    long[] result = new long[n];
    result[result.length - 1] = rightSum - leftSum;
    for (int i = result.length - 2; i >= 0; --i) {
      middle = a[leftIndex] - a[rightIndex] - middle;

      leftSum -= a[leftIndex];
      --leftIndex;

      rightSum -= a[rightIndex];
      ++rightIndex;

      result[i] = rightSum - leftSum + middle;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}