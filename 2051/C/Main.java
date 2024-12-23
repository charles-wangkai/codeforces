import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] q = new int[k];
      for (int i = 0; i < q.length; ++i) {
        q[i] = sc.nextInt();
      }

      System.out.println(solve(n, a, q));
    }

    sc.close();
  }

  static String solve(int n, int[] a, int[] q) {
    if (q.length == n) {
      return "1".repeat(a.length);
    }
    if (q.length != n - 1) {
      return "0".repeat(a.length);
    }

    Set<Integer> questions = Arrays.stream(q).boxed().collect(Collectors.toSet());
    int list = IntStream.rangeClosed(1, n).filter(x -> !questions.contains(x)).findAny().getAsInt();

    return Arrays.stream(a)
        .map(ai -> (ai == list) ? 1 : 0)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
  }
}