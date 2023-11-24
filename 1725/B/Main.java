import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int D = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P, D));

    sc.close();
  }

  static int solve(int[] P, int D) {
    Arrays.sort(P);

    int result = 0;
    int leftNum = 0;
    for (int i = P.length - 1; i >= leftNum; --i) {
      leftNum += (D + P[i]) / P[i] - 1;
      if (i >= leftNum) {
        ++result;
      }
    }

    return result;
  }
}