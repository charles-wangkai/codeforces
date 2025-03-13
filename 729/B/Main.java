import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] plan = new int[n][m];
    for (int r = 0; r < n; ++r) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < m; ++c) {
        plan[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(plan));
  }

  static int solve(int[][] plan) {
    int n = plan.length;
    int m = plan[0].length;

    int result = 0;
    for (int r = 0; r < n; ++r) {
      int leftSum = 0;
      for (int c = 0; c < m; ++c) {
        if (plan[r][c] == 0 && leftSum != 0) {
          ++result;
        }

        leftSum += plan[r][c];
      }

      int rightSum = 0;
      for (int c = m - 1; c >= 0; --c) {
        if (plan[r][c] == 0 && rightSum != 0) {
          ++result;
        }

        rightSum += plan[r][c];
      }
    }
    for (int c = 0; c < m; ++c) {
      int upSum = 0;
      for (int r = 0; r < n; ++r) {
        if (plan[r][c] == 0 && upSum != 0) {
          ++result;
        }

        upSum += plan[r][c];
      }

      int downSum = 0;
      for (int r = n - 1; r >= 0; --r) {
        if (plan[r][c] == 0 && downSum != 0) {
          ++result;
        }

        downSum += plan[r][c];
      }
    }

    return result;
  }
}