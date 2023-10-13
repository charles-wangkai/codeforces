import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int c) {
    return IntStream.rangeClosed(0, 3)
        .anyMatch(
            cutNum -> {
              if (((long) a + b + c) % (3 + cutNum) != 0) {
                return false;
              }

              int target = (int) (((long) a + b + c) / (3 + cutNum));

              return a % target == 0 && b % target == 0 && c % target == 0;
            });
  }
}
