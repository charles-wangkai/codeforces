import java.util.Scanner;

public class Main {
  static final int DAY_NUM = 5;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] survey = new int[n][DAY_NUM];
      for (int i = 0; i < survey.length; ++i) {
        for (int j = 0; j < survey[i].length; ++j) {
          survey[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(survey) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] survey) {
    for (int d1 = 0; d1 < DAY_NUM; ++d1) {
      for (int d2 = d1 + 1; d2 < DAY_NUM; ++d2) {
        int only1 = 0;
        int only2 = 0;
        for (int[] student : survey) {
          if (student[d1] == 0 && student[d2] == 0) {
            only1 = Integer.MAX_VALUE;

            break;
          }
          if (student[d1] == 0) {
            ++only2;
          }
          if (student[d2] == 0) {
            ++only1;
          }
        }

        if (only1 <= survey.length / 2 && only2 <= survey.length / 2) {
          return true;
        }
      }
    }

    return false;
  }
}
