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
    return (int)
        IntStream.concat(
                IntStream.iterate(1, i -> i + 1).map(i -> i * i).takeWhile(x -> x <= n),
                IntStream.iterate(1, i -> i + 1).map(i -> i * i * i).takeWhile(x -> x <= n))
            .distinct()
            .count();
  }
}
