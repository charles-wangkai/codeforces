import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int p = sc.nextInt();

      System.out.println(solve(n, p));
    }
  }

  static int solve(int n, int p) {
    for (int i = 1; ; ++i) {
      int diff = n - p * i;
      if (diff < i) {
        return -1;
      }
      if (Integer.bitCount(diff) <= i) {
        return i;
      }
    }
  }
}