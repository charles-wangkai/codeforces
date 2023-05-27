import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] x = new int[m];
      int[] y = new int[m];
      for (int i = 0; i < m; ++i) {
        x[i] = sc.nextInt() - 1;
        y[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(n, x, y));
    }

    sc.close();
  }

  static long solve(int n, int[] x, int[] y) {
    int[] maxFriends = new int[n];
    Arrays.fill(maxFriends, n - 1);
    for (int i = 0; i < x.length; ++i) {
      int lower = Math.min(x[i], y[i]);
      int upper = Math.max(x[i], y[i]);
      maxFriends[lower] = Math.min(maxFriends[lower], upper - 1);
    }

    long result = 0;
    SortedMap<Integer, Integer> maxFriendToCount = new TreeMap<>();
    updateMap(maxFriendToCount, n - 1, 1);
    int rightIndex = -1;
    for (int i = 0; i < n; ++i) {
      while (rightIndex + 1 != n && rightIndex + 1 <= maxFriendToCount.firstKey()) {
        ++rightIndex;
        updateMap(maxFriendToCount, maxFriends[rightIndex], 1);
      }

      result += rightIndex - i + 1;

      updateMap(maxFriendToCount, maxFriends[i], -1);
    }

    return result;
  }

  static void updateMap(SortedMap<Integer, Integer> maxFriendToCount, int maxFriend, int delta) {
    maxFriendToCount.put(maxFriend, maxFriendToCount.getOrDefault(maxFriend, 0) + delta);
    maxFriendToCount.remove(maxFriend, 0);
  }
}
