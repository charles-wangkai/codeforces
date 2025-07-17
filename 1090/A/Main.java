import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] salaries = new int[n][];
    for (int i = 0; i < salaries.length; ++i) {
      int m = sc.nextInt();
      salaries[i] = new int[m];
      for (int j = 0; j < salaries[i].length; ++j) {
        salaries[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(salaries));

    sc.close();
  }

  static long solve(int[][] salaries) {
    int[] maxs =
        Arrays.stream(salaries)
            .mapToInt(company -> Arrays.stream(company).max().getAsInt())
            .toArray();

    int maxMax = Arrays.stream(maxs).max().getAsInt();

    return IntStream.range(0, maxs.length)
        .mapToLong(i -> (long) (maxMax - maxs[i]) * salaries[i].length)
        .sum();
  }
}