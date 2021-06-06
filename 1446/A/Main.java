import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long W = sc.nextLong();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }

      System.out.println(solve(w, W));
    }

    sc.close();
  }

  static String solve(int[] w, long W) {
    OptionalInt singleIndex =
        IntStream.range(0, w.length).filter(i -> w[i] >= (W + 1) / 2 && w[i] <= W).findAny();
    if (singleIndex.isPresent()) {
      return String.format("1\n%d", singleIndex.getAsInt() + 1);
    }

    int[] candidateIndices = IntStream.range(0, w.length).filter(i -> w[i] < (W + 1) / 2).toArray();
    if (Arrays.stream(candidateIndices).map(i -> w[i]).asLongStream().sum() < (W + 1) / 2) {
      return "-1";
    }

    List<Integer> indices = new ArrayList<>();
    long sum = 0;
    for (int candidateIndex : candidateIndices) {
      indices.add(candidateIndex);
      sum += w[candidateIndex];

      if (sum >= (W + 1) / 2 && sum <= W) {
        break;
      }
    }

    return String.format(
        "%d\n%s",
        indices.size(),
        indices.stream().map(i -> String.valueOf(i + 1)).collect(Collectors.joining(" ")));
  }
}
