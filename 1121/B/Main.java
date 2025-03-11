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

  static int solve(int[] a) {
    Arrays.sort(a);

    int[] sums =
        IntStream.range(0, a.length)
            .flatMap(i -> IntStream.range(i + 1, a.length).map(j -> a[i] + a[j]))
            .distinct()
            .toArray();

    return Arrays.stream(sums).map(sum -> computePairNum(a, sum)).max().getAsInt();
  }

  static int computePairNum(int[] a, int sum) {
    int result = 0;
    int leftIndex = 0;
    int rightIndex = a.length - 1;
    while (leftIndex < rightIndex) {
      if (a[leftIndex] + a[rightIndex] < sum) {
        ++leftIndex;
      } else if (a[leftIndex] + a[rightIndex] > sum) {
        --rightIndex;
      } else {
        ++leftIndex;
        --rightIndex;
        ++result;
      }
    }

    return result;
  }
}