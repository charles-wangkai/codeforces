import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static String solve(int n, int m) {
    int score1 = Math.max(computeScore1(n, m, 0), computeScore1(n, m, 1));
    int score2 = n + m - 1 - score1;

    return "%d %d".formatted(score1, score2);
  }

  static int computeScore1(int n, int m, int index) {
    int[] counts = {n, m};
    if (counts[index] == 0) {
      return -1;
    }
    --counts[index];

    int result = 0;
    for (int i = 1; i < n + m; ++i) {
      if (i % 2 == 0) {
        if (counts[index] == 0) {
          index = 1 - index;
        } else {
          ++result;
        }
      } else if (counts[1 - index] != 0) {
        index = 1 - index;
      } else {
        ++result;
      }

      --counts[index];
    }

    return result;
  }
}