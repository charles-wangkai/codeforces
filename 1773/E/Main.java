import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] b = new int[n][];
    for (int i = 0; i < b.length; ++i) {
      int k = sc.nextInt();
      b[i] = new int[k];
      for (int j = 0; j < b[i].length; ++j) {
        b[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(b));

    sc.close();
  }

  static String solve(int[][] b) {
    int[] sorted = Arrays.stream(b).flatMapToInt(Arrays::stream).sorted().toArray();
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, sorted.length).boxed().collect(Collectors.toMap(i -> sorted[i], i -> i));

    int splitNum =
        Arrays.stream(b)
            .mapToInt(
                tower ->
                    (int)
                        IntStream.range(0, tower.length - 1)
                            .filter(
                                i ->
                                    valueToIndex.get(tower[i]) + 1
                                        != valueToIndex.get(tower[i + 1]))
                            .count())
            .sum();
    int combineNum = b.length + splitNum - 1;

    return "%d %d".formatted(splitNum, combineNum);
  }
}