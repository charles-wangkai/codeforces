import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s, c));
    }

    sc.close();
  }

  static long solve(int[] s, int c) {
    int evenCount = (int) Arrays.stream(s).filter(x -> x % 2 == 0).count();
    int oddCount = (int) Arrays.stream(s).filter(x -> x % 2 == 1).count();

    return (c + 2L) * (c + 1) / 2
        - s.length
        - Arrays.stream(s).map(si -> si / 2).asLongStream().sum()
        - Arrays.stream(s).map(si -> c - si).asLongStream().sum()
        + evenCount * (evenCount - 1L) / 2
        + oddCount * (oddCount - 1L) / 2;
  }
}