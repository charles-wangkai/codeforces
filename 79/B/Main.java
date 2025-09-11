import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String[] PLANTS = {"Carrots", "Kiwis", "Grapes"};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int t = sc.nextInt();
    int[] a = new int[k];
    int[] b = new int[k];
    for (int i = 0; i < k; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    int[] u = new int[t];
    int[] v = new int[t];
    for (int i = 0; i < t; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(n, m, a, b, u, v));

    sc.close();
  }

  static String solve(int n, int m, int[] a, int[] b, int[] u, int[] v) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] wasteSets = new Set[n];
    for (int i = 0; i < wasteSets.length; ++i) {
      wasteSets[i] = new HashSet<>();
    }
    for (int i = 0; i < a.length; ++i) {
      wasteSets[a[i] - 1].add(b[i] - 1);
    }

    return IntStream.range(0, u.length)
        .mapToObj(
            i -> {
              if (wasteSets[u[i] - 1].contains(v[i] - 1)) {
                return "Waste";
              }

              return PLANTS[
                  (IntStream.range(0, u[i] - 1).map(j -> m - wasteSets[j].size()).sum()
                          + (v[i]
                              - 1
                              - (int)
                                  wasteSets[u[i] - 1].stream().filter(x -> x < v[i] - 1).count()))
                      % PLANTS.length];
            })
        .collect(Collectors.joining("\n"));
  }
}