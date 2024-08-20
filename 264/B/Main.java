import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 100000;

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
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i));

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[a.length];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }

    for (int i = 2; i <= LIMIT; ++i) {
      int prevIndex = -1;
      for (int j = i; j <= LIMIT; j += i) {
        if (valueToIndex.containsKey(j)) {
          if (prevIndex != -1) {
            adjLists[prevIndex].add(valueToIndex.get(j));
          }

          prevIndex = valueToIndex.get(j);
        }
      }
    }

    int[] dp = new int[a.length];
    Arrays.fill(dp, 1);
    for (int i = 0; i < dp.length; ++i) {
      for (int adj : adjLists[i]) {
        dp[adj] = Math.max(dp[adj], dp[i] + 1);
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }
}