import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[][] a = new int[k][n];
      for (int i = 0; i < a.length; ++i) {
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] a) {
    if (a.length == 1) {
      return true;
    }

    List<List<Integer>> candidateOrders = buildCandidateOrders(a);

    return candidateOrders.stream()
        .anyMatch(candidateOrder -> Arrays.stream(a).allMatch(ai -> isMatch(candidateOrder, ai)));
  }

  static boolean isMatch(List<Integer> candidateOrder, int[] ai) {
    return Arrays.equals(
        candidateOrder.stream().filter(x -> x != ai[0]).mapToInt(Integer::intValue).toArray(),
        Arrays.stream(ai).filter(x -> x != ai[0]).toArray());
  }

  static List<List<Integer>> buildCandidateOrders(int[][] a) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i <= 2 && i < a.length; ++i) {
      List<Integer> candidateOrder =
          IntStream.range(1, a[0].length).map(j -> a[0][j]).boxed().collect(Collectors.toList());

      int i_ = i;
      int index =
          IntStream.range(0, a[i].length).filter(j -> a[i_][j] == a[0][0]).findAny().getAsInt();

      candidateOrder.add(
          (index == 1)
              ? 0
              : (IntStream.range(0, candidateOrder.size())
                      .filter(j -> candidateOrder.get(j) == a[i_][index - 1])
                      .findAny()
                      .getAsInt()
                  + 1),
          a[0][0]);

      result.add(candidateOrder);
    }

    return result;
  }
}