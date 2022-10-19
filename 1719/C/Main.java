import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] indices = new int[q];
      int[] k = new int[q];
      for (int i = 0; i < q; ++i) {
        indices[i] = sc.nextInt() - 1;
        k[i] = sc.nextInt();
      }

      System.out.println(solve(a, indices, k));
    }

    sc.close();
  }

  static String solve(int[] a, int[] indices, int[] k) {
    int n = a.length;

    int[] result = new int[indices.length];
    int[] queryIndices =
        IntStream.range(0, indices.length)
            .boxed()
            .sorted(Comparator.comparing(i -> k[i]))
            .mapToInt(x -> x)
            .toArray();
    Deque<Integer> athletes = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      athletes.offerLast(i);
    }
    int[] winCounts = new int[n];
    int round = 0;
    int bestAthlete =
        IntStream.range(0, a.length).boxed().max(Comparator.comparing(i -> a[i])).get();
    for (int queryIndex : queryIndices) {
      while (round < Math.min(k[queryIndex], n)) {
        int athlete1 = athletes.pollFirst();
        int athlete2 = athletes.pollFirst();
        if (a[athlete1] > a[athlete2]) {
          ++winCounts[athlete1];
          athletes.offerFirst(athlete1);
          athletes.offerLast(athlete2);
        } else {
          ++winCounts[athlete2];
          athletes.offerFirst(athlete2);
          athletes.offerLast(athlete1);
        }

        ++round;
      }

      result[queryIndex] = winCounts[indices[queryIndex]];
      if (indices[queryIndex] == bestAthlete) {
        result[queryIndex] += k[queryIndex] - round;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}
