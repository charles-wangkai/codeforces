import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(n, m, s));
    }

    sc.close();
  }

  static String solve(int n, int m, String s) {
    int minDr = 0;
    int maxDr = 0;
    int minDc = 0;
    int maxDc = 0;
    int dr = 0;
    int dc = 0;
    for (char command : s.toCharArray()) {
      if (command == 'L') {
        --dc;
      } else if (command == 'R') {
        ++dc;
      } else if (command == 'D') {
        ++dr;
      } else {
        --dr;
      }

      int nextMinDr = Math.min(minDr, dr);
      int nextMaxDr = Math.max(maxDr, dr);
      int nextMinDc = Math.min(minDc, dc);
      int nextMaxDc = Math.max(maxDc, dc);
      if (nextMaxDr - nextMinDr + 1 > n || nextMaxDc - nextMinDc + 1 > m) {
        break;
      }

      minDr = nextMinDr;
      maxDr = nextMaxDr;
      minDc = nextMinDc;
      maxDc = nextMaxDc;
    }

    return "%d %d".formatted(-minDr + 1, -minDc + 1);
  }
}