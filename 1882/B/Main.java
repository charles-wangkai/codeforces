import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] S = new int[n][];
      for (int i = 0; i < S.length; ++i) {
        int k = sc.nextInt();
        S[i] = new int[k];
        for (int j = 0; j < S[i].length; ++j) {
          S[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(S));
    }

    sc.close();
  }

  static int solve(int[][] S) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] sets =
        Arrays.stream(S)
            .map(Si -> Arrays.stream(Si).boxed().collect(Collectors.toSet()))
            .toArray(Set[]::new);

    return Arrays.stream(sets).reduce(Set.of(), Main::union).stream()
        .mapToInt(
            x ->
                Arrays.stream(sets)
                    .filter(set -> !set.contains(x))
                    .reduce(Set.of(), Main::union)
                    .size())
        .max()
        .getAsInt();
  }

  static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
    return Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
  }
}
