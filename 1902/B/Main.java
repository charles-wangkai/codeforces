import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int n = sc.nextInt();
      long P = sc.nextLong();
      int l = sc.nextInt();
      int t = sc.nextInt();

      System.out.println(solve(n, P, l, t));
    }

    sc.close();
  }

  static int solve(int n, long P, int l, int t) {
    int studyNum = 0;
    int taskNum = (n - 1) / 7 + 1;

    long delta = Math.min((P + (l + 2L * t - 1)) / (l + 2L * t), taskNum / 2);
    P = Math.max(0, P - delta * (l + 2L * t));
    studyNum += delta;

    delta = Math.min((P + (l + t - 1)) / (l + t), taskNum % 2);
    P = Math.max(0, P - delta * (l + t));
    studyNum += delta;

    studyNum += (P + (l - 1)) / l;

    return n - studyNum;
  }
}