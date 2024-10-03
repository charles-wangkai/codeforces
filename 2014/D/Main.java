import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int d = sc.nextInt();
      int k = sc.nextInt();
      int[] l = new int[k];
      int[] r = new int[k];
      for (int i = 0; i < k; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(n, d, l, r));
    }

    sc.close();
  }

  static String solve(int n, int d, int[] l, int[] r) {
    int[] sortedIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(Comparator.comparing(i -> l[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] overlapNums = new int[n - d + 1];
    PriorityQueue<Integer> rights = new PriorityQueue<>();
    int index = -1;
    while (index != sortedIndices.length - 1 && l[sortedIndices[index + 1]] - 1 <= d - 1) {
      rights.add(r[sortedIndices[index + 1]] - 1);
      ++index;
    }
    for (int i = 0; i < overlapNums.length; ++i) {
      while (!rights.isEmpty() && rights.peek() == i - 1) {
        rights.poll();
      }
      while (index != sortedIndices.length - 1 && l[sortedIndices[index + 1]] - 1 == i + d - 1) {
        rights.add(r[sortedIndices[index + 1]] - 1);
        ++index;
      }

      overlapNums[i] = rights.size();
    }

    int minOverlapNum = Arrays.stream(overlapNums).min().getAsInt();
    int maxOverlapNum = Arrays.stream(overlapNums).max().getAsInt();

    return "%d %d"
        .formatted(
            IntStream.range(0, overlapNums.length)
                    .filter(i -> overlapNums[i] == maxOverlapNum)
                    .findFirst()
                    .getAsInt()
                + 1,
            IntStream.range(0, overlapNums.length)
                    .filter(i -> overlapNums[i] == minOverlapNum)
                    .findFirst()
                    .getAsInt()
                + 1);
  }
}