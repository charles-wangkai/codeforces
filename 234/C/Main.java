import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int n = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    out.println(solve(t));

    out.close();
    sc.close();
  }

  static int solve(int[] t) {
    int[] leftCounts = new int[t.length];
    for (int i = 0; i < leftCounts.length; ++i) {
      leftCounts[i] = ((i == 0) ? 0 : leftCounts[i - 1]) + ((t[i] >= 0) ? 1 : 0);
    }

    int[] rightCounts = new int[t.length];
    for (int i = rightCounts.length - 1; i >= 0; --i) {
      rightCounts[i] =
          ((i == rightCounts.length - 1) ? 0 : rightCounts[i + 1]) + ((t[i] <= 0) ? 1 : 0);
    }

    return IntStream.range(0, t.length - 1)
        .map(i -> leftCounts[i] + rightCounts[i + 1])
        .min()
        .getAsInt();
  }
}