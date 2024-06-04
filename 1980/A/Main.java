import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      String a = sc.next();

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static int solve(String a, int m) {
    return IntStream.rangeClosed('A', 'G')
        .map(d -> Math.max(0, m - (int) a.chars().filter(c -> c == d).count()))
        .sum();
  }
}