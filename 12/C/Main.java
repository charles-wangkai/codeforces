import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < prices.length; ++i) {
      prices[i] = sc.nextInt();
    }
    String[] names = new String[m];
    for (int i = 0; i < names.length; ++i) {
      names[i] = sc.next();
    }

    System.out.println(solve(prices, names));

    sc.close();
  }

  static String solve(int[] prices, String[] names) {
    Arrays.sort(prices);

    Map<String, Integer> nameToCount = new HashMap<>();
    for (String name : names) {
      nameToCount.put(name, nameToCount.getOrDefault(name, 0) + 1);
    }
    int[] counts = nameToCount.values().stream().mapToInt(Integer::intValue).sorted().toArray();

    int minSum =
        IntStream.range(0, counts.length).map(i -> counts[i] * prices[counts.length - 1 - i]).sum();
    int maxSum =
        IntStream.range(0, counts.length)
            .map(i -> counts[i] * prices[prices.length - counts.length + i])
            .sum();

    return "%d %d".formatted(minSum, maxSum);
  }
}