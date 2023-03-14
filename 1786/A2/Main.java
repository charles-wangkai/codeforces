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

  static String solve(int n) {
    int aliceWhite = 0;
    int aliceBlack = 0;
    int bobWhite = 0;
    int bobBlack = 0;
    int total = 0;
    for (int i = 1; n != 0; ++i) {
      int dealNum = Math.min(i, n);
      n -= dealNum;

      if (i % 4 <= 1) {
        aliceWhite += dealNum / 2;
        aliceBlack += dealNum / 2;

        if (dealNum % 2 == 1) {
          if (total % 2 == 0) {
            ++aliceWhite;
          } else {
            ++aliceBlack;
          }
        }
      } else {
        bobWhite += dealNum / 2;
        bobBlack += dealNum / 2;

        if (dealNum % 2 == 1) {
          if (total % 2 == 0) {
            ++bobWhite;
          } else {
            ++bobBlack;
          }
        }
      }

      total += dealNum;
    }

    return String.format("%d %d %d %d", aliceWhite, aliceBlack, bobWhite, bobBlack);
  }
}
