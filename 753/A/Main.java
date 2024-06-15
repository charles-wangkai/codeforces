import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    int k = 0;
    int sum = 0;
    while (sum + (k + 1) <= n) {
      ++k;
      sum += k;
    }

    int[] candies = IntStream.range(0, k).map(i -> i + 1).toArray();
    candies[candies.length - 1] += n - sum;

    return String.format(
        "%d\n%s",
        candies.length,
        Arrays.stream(candies).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}