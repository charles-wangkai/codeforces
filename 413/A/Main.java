import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int min = sc.nextInt();
    int max = sc.nextInt();
    int[] t = new int[m];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(n, t, min, max) ? "Correct" : "Incorrect");

    sc.close();
  }

  static boolean solve(int n, int[] t, int min, int max) {
    int begin = Arrays.stream(t).min().getAsInt();
    int end = Arrays.stream(t).max().getAsInt();

    return begin >= min
        && end <= max
        && ((begin == min) ? 0 : 1) + ((end == max) ? 0 : 1) <= n - t.length;
  }
}