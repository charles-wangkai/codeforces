import java.util.Scanner;
import java.util.stream.IntStream;

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
    return IntStream.rangeClosed(1, n)
            .map(
                i -> {
                  if (i <= n / 2) {
                    return -i;
                  }
                  if (i > (n + 1) / 2) {
                    return i;
                  }

                  return 0;
                })
            .sum()
        + 1;
  }
}