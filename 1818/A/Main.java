import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.next();
      }

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String[] s) {
    return 1 + (int) IntStream.range(1, s.length).filter(i -> s[i].equals(s[0])).count();
  }
}
