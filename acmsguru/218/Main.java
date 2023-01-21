import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[][] unsafety = new int[n][n];
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; ++j) {
        unsafety[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(unsafety));
  }

  static String solve(int[][] unsafety) {
    int n = unsafety.length;

    int unsafetyLimit = Integer.MIN_VALUE;
    int[] matchings = new int[n];
    int lower = Integer.MAX_VALUE;
    int upper = Integer.MIN_VALUE;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        lower = Math.min(lower, unsafety[i][j]);
        upper = Math.max(upper, unsafety[i][j]);
      }
    }

    int[] leftMatchings = new int[n];
    int[] rightMatchings = new int[n];
    boolean[] rightVisited = new boolean[n];
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      int matchingCount = 0;
      Arrays.fill(leftMatchings, -1);
      Arrays.fill(rightMatchings, -1);
      for (int i = 0; i < leftMatchings.length; ++i) {
        if (leftMatchings[i] == -1) {
          Arrays.fill(rightVisited, false);
          if (search(unsafety, middle, leftMatchings, rightMatchings, rightVisited, i)) {
            ++matchingCount;
          }
        }
      }

      if (matchingCount == n) {
        unsafetyLimit = middle;
        matchings = leftMatchings.clone();

        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    StringBuilder result = new StringBuilder(String.valueOf(unsafetyLimit));
    for (int i = 0; i < matchings.length; ++i) {
      result.append("\n").append(i + 1).append(" ").append(matchings[i] + 1);
    }

    return result.toString();
  }

  static boolean search(
      int[][] unsafety,
      int limit,
      int[] leftMatchings,
      int[] rightMatchings,
      boolean[] rightVisited,
      int leftIndex) {
    int n = unsafety.length;

    for (int rightIndex = 0; rightIndex < n; ++rightIndex) {
      if (!rightVisited[rightIndex] && unsafety[leftIndex][rightIndex] <= limit) {
        rightVisited[rightIndex] = true;

        if (rightMatchings[rightIndex] == -1
            || search(
                unsafety,
                limit,
                leftMatchings,
                rightMatchings,
                rightVisited,
                rightMatchings[rightIndex])) {
          leftMatchings[leftIndex] = rightIndex;
          rightMatchings[rightIndex] = leftIndex;

          return true;
        }
      }
    }

    return false;
  }
}
