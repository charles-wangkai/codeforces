import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int[] digits = String.valueOf(n).chars().map(c -> c - '0').toArray();

    return (digits.length == 2) ? digits[1] : Arrays.stream(digits).min().getAsInt();
  }
}