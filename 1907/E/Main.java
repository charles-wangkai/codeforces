import java.util.Scanner;

public class Main {
  static int[] tripleCounts;

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
    tripleCounts = new int[10];
    for (int i = 0; i <= 9; ++i) {
      for (int j = 0; j <= 9; ++j) {
        for (int k = 0; k <= 9; ++k) {
          int sum = i + j + k;
          if (sum < tripleCounts.length) {
            ++tripleCounts[sum];
          }
        }
      }
    }
  }

  static long solve(int n) {
    return String.valueOf(n)
        .chars()
        .map(c -> tripleCounts[c - '0'])
        .asLongStream()
        .reduce((acc, x) -> acc * x)
        .getAsLong();
  }
}