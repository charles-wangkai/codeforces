import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int evenCount = (int) Arrays.stream(a).filter(x -> x % 2 == 0).count();
    int oddCount = a.length - evenCount;

    boolean[][][] wins = new boolean[evenCount + 1][oddCount + 1][2];
    for (int i = 0; i <= evenCount + oddCount; ++i) {
      boolean aliceOrBobTurn = (evenCount + oddCount - i) % 2 == 0;
      if (i == 0) {
        wins[0][0][0] = aliceOrBobTurn;
        wins[0][0][1] = !aliceOrBobTurn;
      } else {
        for (int e = 0; e <= evenCount; ++e) {
          int o = i - e;
          if (o >= 0 && o <= oddCount) {
            wins[e][o][0] =
                (e != 0 && !wins[e - 1][o][0])
                    || (o != 0 && !wins[e][o - 1][aliceOrBobTurn ? 1 : 0]);

            wins[e][o][1] =
                (e != 0 && !wins[e - 1][o][1])
                    || (o != 0 && !wins[e][o - 1][aliceOrBobTurn ? 0 : 1]);
          }
        }
      }
    }

    return wins[evenCount][oddCount][0] ? "Alice" : "Bob";
  }
}