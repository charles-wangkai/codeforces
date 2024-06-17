import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int[] s = new int[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.nextInt();
    }

    System.out.println(solve(s, A, B));

    sc.close();
  }

  static int solve(int[] s, int A, int B) {
    int[] sortedSizes =
        IntStream.range(1, s.length)
            .map(i -> s[i])
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    int S = Arrays.stream(s).sum();

    int result = 0;
    while (A * s[0] / S < B) {
      S -= sortedSizes[result];
      ++result;
    }

    return result;
  }
}