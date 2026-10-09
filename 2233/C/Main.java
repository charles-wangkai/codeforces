import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static String solve(String s, int k) {
    int[] leftIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '(').toArray();
    int[] rightIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == ')').toArray();

    String result = null;
    int minCost = Integer.MAX_VALUE;
    for (int leftRemoved = k - Math.min(k, rightIndices.length);
        leftRemoved <= Math.min(k, leftIndices.length);
        ++leftRemoved) {
      int rightRemoved = k - leftRemoved;
      String marked = buildMarked(leftIndices, rightIndices, leftRemoved, rightRemoved);
      int cost = computeCost(s, marked);
      if (cost < minCost) {
        minCost = cost;
        result = marked;
      }
    }

    return result;
  }

  static int computeCost(String s, String marked) {
    int result = 0;
    int leftCount = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (marked.charAt(i) == '0') {
        if (s.charAt(i) == '(') {
          ++leftCount;
        } else if (leftCount != 0) {
          --leftCount;
          result += 2;
        }
      }
    }

    return result;
  }

  static String buildMarked(
      int[] leftIndices, int[] rightIndices, int leftRemoved, int rightRemoved) {
    boolean[] removed = new boolean[leftIndices.length + rightIndices.length];
    for (int i = 0; i < leftRemoved; ++i) {
      removed[leftIndices[i]] = true;
    }
    for (int i = 0; i < rightRemoved; ++i) {
      removed[rightIndices[rightIndices.length - 1 - i]] = true;
    }

    return IntStream.range(0, removed.length)
        .mapToObj(i -> removed[i] ? '1' : '0')
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}