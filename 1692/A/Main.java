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
      int d = sc.nextInt();

      System.out.println(solve(a, b, c, d));
    }

    sc.close();
  }

  static int solve(int a, int b, int c, int d) {
    return (int) IntStream.of(b, c, d).filter(x -> x >= a).count();
  }
}