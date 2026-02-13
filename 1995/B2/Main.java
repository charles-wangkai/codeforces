import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long m = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, c, m));
    }

    sc.close();
  }

  static long solve(int[] a, int[] c, long m) {
    Map<Integer, Integer> petalNumToCount =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> c[i]));

    return petalNumToCount.keySet().stream()
        .mapToLong(
            lower -> {
              int lowerChosen = (int) Math.min(petalNumToCount.get(lower), m / lower);

              int upper = lower + 1;
              int upperCount = petalNumToCount.getOrDefault(upper, 0);
              int upperChosen =
                  (int) Math.min(upperCount, (m - (long) lower * lowerChosen) / upper);

              int delta =
                  (int)
                      Math.min(
                          Math.min(lowerChosen, upperCount - upperChosen),
                          m - (long) lower * lowerChosen - (long) upper * upperChosen);

              return (long) lower * (lowerChosen - delta) + (long) upper * (upperChosen + delta);
            })
        .max()
        .getAsLong();
  }
}