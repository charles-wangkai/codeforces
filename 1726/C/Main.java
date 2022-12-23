import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return s.length() / 2
        - (int)
            IntStream.range(0, s.length() - 1)
                .filter(i -> s.substring(i, i + 2).equals(")("))
                .count();
  }
}
