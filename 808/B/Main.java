import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(a, k)));

    sc.close();
  }

  static double solve(int[] a, int k) {
    List<Long> sums = new ArrayList<>();
    long sum = IntStream.range(0, k - 1).map(i -> a[i]).asLongStream().sum();
    for (int i = k - 1; i < a.length; ++i) {
      sum += a[i];
      sums.add(sum);
      sum -= a[i - k + 1];
    }

    return sums.stream().mapToLong(Long::longValue).average().getAsDouble();
  }
}