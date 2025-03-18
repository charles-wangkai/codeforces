import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] f = new int[n];
    for (int i = 0; i < f.length; ++i) {
      f[i] = sc.nextInt();
    }

    System.out.println(solve(f));

    sc.close();
  }

  static long solve(int[] f) {
    Map<Integer, Integer> fragmentToIndex =
        IntStream.range(0, f.length).boxed().collect(Collectors.toMap(i -> f[i], i -> i));

    return IntStream.range(1, f.length)
        .map(i -> Math.abs(fragmentToIndex.get(i) - fragmentToIndex.get(i + 1)))
        .asLongStream()
        .sum();
  }
}