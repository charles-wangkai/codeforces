import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] x = new int[m];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static long solve(int[] a, int[] x) {
    int[] sortedEvenPosValues =
        IntStream.range(0, a.length).filter(i -> i % 2 == 0).map(i -> a[i]).sorted().toArray();
    int evenCount = sortedEvenPosValues.length;

    int[] sortedOddPosValues =
        IntStream.range(0, a.length).filter(i -> i % 2 == 1).map(i -> a[i]).sorted().toArray();
    int oddCount = sortedOddPosValues.length;

    for (int xi : x) {
      if ((xi - 1) % 2 == 0) {
        if (evenCount != 0
            && (evenCount == sortedEvenPosValues.length
                || sortedEvenPosValues[evenCount - 1] > 0)) {
          --evenCount;
        }
      } else if (oddCount != 0
          && (oddCount == sortedOddPosValues.length || sortedOddPosValues[oddCount - 1] > 0)) {
        --oddCount;
      }
    }

    return IntStream.range(0, evenCount).map(i -> sortedEvenPosValues[i]).asLongStream().sum()
        + IntStream.range(0, oddCount).map(i -> sortedOddPosValues[i]).asLongStream().sum();
  }
}