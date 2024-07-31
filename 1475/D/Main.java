import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, m));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int m) {
    int[] regularMemories =
        IntStream.range(0, a.length)
            .filter(i -> b[i] == 1)
            .map(i -> a[i])
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    int[] importantMemories =
        IntStream.range(0, a.length)
            .filter(i -> b[i] == 2)
            .map(i -> a[i])
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int regularCount = 0;
    int regularSum = 0;
    while (regularCount != regularMemories.length && regularSum < m) {
      regularSum += regularMemories[regularCount];
      ++regularCount;
    }

    int result = (regularSum >= m) ? regularCount : Integer.MAX_VALUE;
    long importantSum = 0;
    for (int i = 0; i < importantMemories.length; ++i) {
      importantSum += importantMemories[i];

      while (regularCount != 0
          && regularSum - regularMemories[regularCount - 1] + importantSum >= m) {
        --regularCount;
        regularSum -= regularMemories[regularCount];
      }

      if (regularSum + importantSum >= m) {
        result = Math.min(result, regularCount + (i + 1) * 2);
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }
}