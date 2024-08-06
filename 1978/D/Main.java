import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c));
    }

    sc.close();
  }

  static String solve(int[] a, int c) {
    SortedMap<Integer, Integer> restToCount = new TreeMap<>();
    for (int ai : a) {
      updateMap(restToCount, ai, 1);
    }

    SortedMap<Integer, Integer> excludedToCount = new TreeMap<>();
    long excludedSum = 0;

    long prefixSum = c;

    while (!restToCount.isEmpty() && prefixSum + excludedSum < restToCount.lastKey()) {
      int maxVote = restToCount.lastKey();
      updateMap(restToCount, maxVote, -1);

      updateMap(excludedToCount, maxVote, 1);
      excludedSum += maxVote;
    }

    int[] result = new int[a.length];
    for (int i = 0; i < a.length; ++i) {
      prefixSum += a[i];

      if (restToCount.containsKey(a[i])) {
        updateMap(restToCount, a[i], -1);
      } else {
        updateMap(excludedToCount, a[i], -1);
        excludedSum -= a[i];
      }

      while (!excludedToCount.isEmpty()
          && prefixSum + (excludedSum - excludedToCount.firstKey())
              >= Math.max(
                  restToCount.isEmpty() ? -1 : restToCount.lastKey(), excludedToCount.firstKey())) {
        int vote = excludedToCount.firstKey();

        updateMap(excludedToCount, vote, -1);
        excludedSum -= vote;

        updateMap(restToCount, vote, 1);
      }

      result[i] = i + excludedToCount.size();
    }

    int winner = 0;
    int maxVote = a[0] + c;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] > maxVote) {
        winner = i;
        maxVote = a[i];
      }
    }
    result[winner] = 0;

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void updateMap(SortedMap<Integer, Integer> map, int key, int delta) {
    map.put(key, map.getOrDefault(key, 0) + delta);
    map.remove(key, 0);
  }
}