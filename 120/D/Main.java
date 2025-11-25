import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] c = new int[n][m];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        c[i][j] = sc.nextInt();
      }
    }
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    out.println(solve(c, A, B, C));

    out.close();
    sc.close();
  }

  static int solve(int[][] c, int A, int B, int C) {
    return computeDivideNum(
            A, B, C, Arrays.stream(c).mapToInt(line -> Arrays.stream(line).sum()).toArray())
        + computeDivideNum(
            A,
            B,
            C,
            IntStream.range(0, c[0].length)
                .map(j -> IntStream.range(0, c.length).map(i -> c[i][j]).sum())
                .toArray());
  }

  static int computeDivideNum(int A, int B, int C, int[] values) {
    int[] sorted = IntStream.of(A, B, C).sorted().toArray();

    int result = 0;
    for (int length1 = 1; length1 < values.length; ++length1) {
      for (int length2 = 1; length1 + length2 < values.length; ++length2) {
        if (Arrays.equals(
            IntStream.of(
                    IntStream.range(0, length1).map(i -> values[i]).sum(),
                    IntStream.range(length1, length1 + length2).map(i -> values[i]).sum(),
                    IntStream.range(length1 + length2, values.length).map(i -> values[i]).sum())
                .sorted()
                .toArray(),
            sorted)) {
          ++result;
        }
      }
    }

    return result;
  }
}