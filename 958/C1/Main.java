import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int p = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, p));

    sc.close();
  }

  static int solve(int[] A, int p) {
    int result = -1;
    int leftScore = 0;
    int rightScore = Arrays.stream(A).reduce((acc, x) -> addMod(acc, x, p)).getAsInt();
    for (int i = 0; i < A.length - 1; ++i) {
      leftScore = addMod(leftScore, A[i], p);
      rightScore = addMod(rightScore, -A[i], p);

      result = Math.max(result, leftScore + rightScore);
    }

    return result;
  }

  static int addMod(int x, int y, int m) {
    return Math.floorMod(x + y, m);
  }
}