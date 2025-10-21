import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }
    int[] id = new int[k];
    for (int i = 0; i < id.length; ++i) {
      id[i] = sc.nextInt();
    }

    System.out.println(solve(c, id));

    sc.close();
  }

  static long solve(int[] c, int[] id) {
    Set<Integer> capitals = Arrays.stream(id).map(x -> x - 1).boxed().collect(Collectors.toSet());

    int s = capitals.stream().mapToInt(capital -> c[capital]).sum();
    long s2 = capitals.stream().mapToInt(capital -> c[capital] * c[capital]).asLongStream().sum();

    return (long) Arrays.stream(c).sum() * capitals.stream().mapToInt(capital -> c[capital]).sum()
        - s2
        - ((long) s * s - s2) / 2
        + IntStream.range(0, c.length)
            .filter(i -> !capitals.contains(i) && !capitals.contains((i + 1) % c.length))
            .map(i -> c[i] * c[(i + 1) % c.length])
            .asLongStream()
            .sum();
  }
}