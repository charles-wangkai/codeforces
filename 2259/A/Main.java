import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    return (int)
        IntStream.range(0, s.length() / k)
            .filter(i -> IntStream.range(i * k, i * k + k).allMatch(j -> s.charAt(j) == '1'))
            .count();
  }
}