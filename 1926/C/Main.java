import java.util.Scanner;

public class Main {
  static final int LIMIT = 200000;

  static int[] solutions = new int[LIMIT + 1];

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static void precompute() {
    for (int i = 1; i < solutions.length; ++i) {
      solutions[i] = solutions[i - 1] + String.valueOf(i).chars().map(c -> c - '0').sum();
    }
  }

  static int solve(int n) {
    return solutions[n];
  }
}