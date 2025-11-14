import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int na = sc.nextInt();
    int ma = sc.nextInt();
    char[][] tableA = new char[na][ma];
    for (int r = 0; r < na; ++r) {
      String line = sc.next();
      for (int c = 0; c < ma; ++c) {
        tableA[r][c] = line.charAt(c);
      }
    }
    int nb = sc.nextInt();
    int mb = sc.nextInt();
    char[][] tableB = new char[nb][mb];
    for (int r = 0; r < nb; ++r) {
      String line = sc.next();
      for (int c = 0; c < mb; ++c) {
        tableB[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(tableA, tableB));

    sc.close();
  }

  static String solve(char[][] tableA, char[][] tableB) {
    int na = tableA.length;
    int ma = tableA[0].length;
    int nb = tableB.length;
    int mb = tableB[0].length;

    int bestX = Integer.MIN_VALUE;
    int bestY = Integer.MIN_VALUE;
    int maxOverlap = -1;
    for (int x = -Math.max(na, nb); x <= Math.max(na, nb); ++x) {
      for (int y = -Math.max(ma, mb); y <= Math.max(ma, mb); ++y) {
        int overlap = 0;
        for (int ra = 0; ra < na; ++ra) {
          for (int ca = 0; ca < ma; ++ca) {
            int rb = ra + x;
            int cb = ca + y;
            if (rb >= 0
                && rb < nb
                && cb >= 0
                && cb < mb
                && tableA[ra][ca] == '1'
                && tableB[rb][cb] == '1') {
              ++overlap;
            }
          }
        }

        if (overlap > maxOverlap) {
          maxOverlap = overlap;
          bestX = x;
          bestY = y;
        }
      }
    }

    return "%d %d".formatted(bestX, bestY);
  }
}