import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int g = Arrays.stream(a).reduce(Main::gcd).getAsInt();

    int diffCount = (int) Arrays.stream(a).filter(ai -> ai != g).count();

    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    if (set.contains(g)) {
      return diffCount;
    }

    int result = diffCount - 1;
    while (!set.contains(g)) {
      Set<Integer> set_ = set;
      set =
          Arrays.stream(a)
              .flatMap(ai -> set_.stream().mapToInt(x -> gcd(x, ai)))
              .boxed()
              .collect(Collectors.toSet());

      ++result;
    }

    return result;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}