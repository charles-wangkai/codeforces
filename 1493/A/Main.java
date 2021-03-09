import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    boolean[] chosen = new boolean[n + 1];
    Arrays.fill(chosen, true);

    chosen[k] = false;
    for (int i = 1; i * 2 < k; ++i) {
      chosen[i] = false;
    }

    int[] set = IntStream.range(1, chosen.length).filter(i -> chosen[i]).toArray();

    return String.format(
        "%d\n%s",
        set.length, Arrays.stream(set).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
