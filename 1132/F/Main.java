import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    return computeOperationNum(s, new int[s.length()][s.length()], 0, s.length() - 1);
  }

  static int computeOperationNum(String s, int[][] cache, int beginIndex, int endIndex) {
    if (beginIndex > endIndex) {
      return 0;
    }

    if (cache[beginIndex][endIndex] == 0) {
      int result = Integer.MAX_VALUE;
      int left = -1;
      List<Range> ranges = new ArrayList<>();
      List<Integer> dp = new ArrayList<>();
      dp.add(0);
      for (int i = beginIndex; i <= endIndex; ++i) {
        if (s.charAt(i) == s.charAt(beginIndex)) {
          if (left != -1) {
            ranges.add(new Range(left, i - 1));

            int minOperationNum = Integer.MAX_VALUE;
            for (int j = 0; j < ranges.size(); ++j) {
              minOperationNum =
                  Math.min(
                      minOperationNum,
                      dp.get(j) + computeOperationNum(s, cache, ranges.get(j).left(), i - 1));
            }
            dp.add(minOperationNum);

            left = -1;
          }

          result =
              Math.min(
                  result,
                  1 + dp.get(ranges.size()) + computeOperationNum(s, cache, i + 1, endIndex));
        } else if (left == -1) {
          left = i;
        }
      }

      cache[beginIndex][endIndex] = result;
    }

    return cache[beginIndex][endIndex];
  }
}

record Range(int left, int right) {}
