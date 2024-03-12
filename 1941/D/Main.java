import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int x = sc.nextInt();
      int[] r = new int[m];
      char[] c = new char[m];
      for (int i = 0; i < m; ++i) {
        r[i] = sc.nextInt();
        c[i] = sc.next().charAt(0);
      }

      System.out.println(solve(n, r, c, x));
    }

    sc.close();
  }

  static String solve(int n, int[] r, char[] c, int x) {
    Set<Integer> players = Set.of(x - 1);
    for (int i = 0; i < r.length; ++i) {
      int i_ = i;
      players =
          players.stream()
              .map(
                  player -> {
                    List<Integer> result = new ArrayList<>();
                    if (c[i_] == '0' || c[i_] == '?') {
                      result.add(Math.floorMod(player + r[i_], n));
                    }
                    if (c[i_] == '1' || c[i_] == '?') {
                      result.add(Math.floorMod(player - r[i_], n));
                    }

                    return result;
                  })
              .flatMap(List::stream)
              .collect(Collectors.toSet());
    }

    return String.format(
        "%d\n%s",
        players.size(),
        players.stream()
            .sorted()
            .map(a -> a + 1)
            .map(String::valueOf)
            .collect(Collectors.joining(" ")));
  }
}