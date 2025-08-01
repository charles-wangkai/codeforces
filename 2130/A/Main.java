import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] S = new int[n];
      for (int i = 0; i < S.length; ++i) {
        S[i] = sc.nextInt();
      }

      System.out.println(solve(S));
    }

    sc.close();
  }

  static int solve(int[] S) {
    return Arrays.stream(S).map(x -> (x == 0) ? 1 : x).sum();
  }
}