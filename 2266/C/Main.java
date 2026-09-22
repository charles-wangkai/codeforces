import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int n = s.length();

    int[] leftOneCounts = new int[n];
    for (int i = 0; i < leftOneCounts.length; ++i) {
      leftOneCounts[i] = ((i == 0) ? 0 : leftOneCounts[i - 1]) + ((s.charAt(i) == '1') ? 1 : 0);
    }

    int[] rightZeroCounts = new int[n];
    for (int i = rightZeroCounts.length - 1; i >= 0; --i) {
      rightZeroCounts[i] =
          ((i == rightZeroCounts.length - 1) ? 0 : rightZeroCounts[i + 1])
              + ((s.charAt(i) == '0') ? 1 : 0);
    }

    int firstOneIndex = s.indexOf('1');
    if (firstOneIndex == -1) {
      return 0;
    }
    if (firstOneIndex == 0) {
      return rightZeroCounts[0];
    }

    return IntStream.rangeClosed(firstOneIndex, n)
        .map(i -> leftOneCounts[i - 1] + ((i == n) ? 0 : rightZeroCounts[i]))
        .min()
        .getAsInt();
  }
}