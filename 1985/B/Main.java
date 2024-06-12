import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int[] multipleSums = new int[n + 1];
    for (int i = 2; i < multipleSums.length; ++i) {
      multipleSums[i] = computeMultipleSum(n, i);
    }

    return IntStream.rangeClosed(2, n)
        .boxed()
        .max(Comparator.comparing(i -> multipleSums[i]))
        .get();
  }

  static int computeMultipleSum(int n, int x) {
    int result = 0;
    for (int i = 1; i * x <= n; ++i) {
      result += i * x;
    }

    return result;
  }
}