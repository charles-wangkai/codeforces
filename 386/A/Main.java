import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

    sc.close();
  }

  static String solve(int[] p) {
    int[] indices =
        IntStream.range(0, p.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> p[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    return String.format("%d %d", indices[0] + 1, p[indices[1]]);
  }
}