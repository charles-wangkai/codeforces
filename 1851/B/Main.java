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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] sorted = new int[a.length];

    int[] evenIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 0).toArray();
    int[] sortedEvenValues = Arrays.stream(evenIndices).map(i -> a[i]).sorted().toArray();
    for (int i = 0; i < evenIndices.length; ++i) {
      sorted[evenIndices[i]] = sortedEvenValues[i];
    }

    int[] oddIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 1).toArray();
    int[] sortedOddValues = Arrays.stream(oddIndices).map(i -> a[i]).sorted().toArray();
    for (int i = 0; i < oddIndices.length; ++i) {
      sorted[oddIndices[i]] = sortedOddValues[i];
    }

    return Arrays.equals(sorted, Arrays.stream(a).sorted().toArray());
  }
}
