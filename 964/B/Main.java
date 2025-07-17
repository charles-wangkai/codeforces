import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int T = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(t, A, B, C, T));

    sc.close();
  }

  static int solve(int[] t, int A, int B, int C, int T) {
    return A * t.length + Math.max(0, (C - B) * (T * t.length - Arrays.stream(t).sum()));
  }
}