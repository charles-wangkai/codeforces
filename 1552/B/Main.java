import java.util.Scanner;

public class Main {
  static final int RANK_NUM = 5;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] r = new int[n][RANK_NUM];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < RANK_NUM; ++j) {
          r[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(r));
    }

    sc.close();
  }

  static int solve(int[][] r) {
    int candidateIndex = -1;
    for (int i = 0; i < r.length; ++i) {
      if (candidateIndex == -1) {
        candidateIndex = i;
      } else {
        int cmp = compare(r[i], r[candidateIndex]);
        if (cmp == 1) {
          candidateIndex = i;
        } else if (cmp == 0) {
          candidateIndex = -1;
        }
      }
    }

    if (candidateIndex != -1) {
      for (int i = 0; i < r.length; ++i) {
        if (i != candidateIndex && compare(r[candidateIndex], r[i]) != 1) {
          candidateIndex = -1;

          break;
        }
      }
    }

    return (candidateIndex == -1) ? -1 : (candidateIndex + 1);
  }

  static int compare(int[] r1, int[] r2) {
    int score1 = 0;
    int score2 = 0;
    for (int i = 0; i < r1.length; ++i) {
      if (r1[i] < r2[i]) {
        ++score1;
      } else {
        ++score2;
      }
    }

    if (score1 >= 3) {
      return 1;
    } else if (score2 >= 3) {
      return -1;
    }

    return 0;
  }
}
