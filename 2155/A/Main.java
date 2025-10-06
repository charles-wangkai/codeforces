import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    return search(n, 0);
  }

  static int search(int winnerNum, int loserNum) {
    if (winnerNum == 1 && loserNum == 1) {
      return 1;
    }

    return winnerNum / 2
        + loserNum / 2
        + search((winnerNum + 1) / 2, (loserNum + 1) / 2 + winnerNum / 2);
  }
}