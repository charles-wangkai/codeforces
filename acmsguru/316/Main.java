import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] froms = new int[M];
    int[] tos = new int[M];
    for (int i = 0; i < M; ++i) {
      froms[i] = sc.nextInt() - 1;
      tos[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(N, froms, tos));

    sc.close();
  }

  static String solve(int N, int[] froms, int[] tos) {
    int[] hits = new int[N];
    Arrays.fill(hits, 100);
    int[] scores = new int[N];
    for (int i = 0; i < froms.length; ++i) {
      if (hits[tos[i]] > 0) {
        scores[froms[i]] += 3;
      }

      hits[tos[i]] -= 8;
    }

    for (int i = 0; i < N; ++i) {
      if (hits[i] > 0) {
        scores[i] += hits[i] / 2;
      }
    }

    return IntStream.range(0, N)
        .mapToObj(i -> String.format("%d %d", hits[i], scores[i]))
        .collect(Collectors.joining("\n"));
  }
}