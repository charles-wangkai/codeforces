import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] groups = new int[m][];
    for (int i = 0; i < groups.length; ++i) {
      int k = sc.nextInt();
      groups[i] = new int[k];
      for (int j = 0; j < groups[i].length; ++j) {
        groups[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(n, groups) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int n, int[][] groups) {
    return Arrays.stream(groups)
        .anyMatch(
            group ->
                Arrays.stream(group).map(Math::abs).distinct().count()
                    == Arrays.stream(group).distinct().count());
  }
}