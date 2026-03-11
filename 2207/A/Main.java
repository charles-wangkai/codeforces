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

  static String solve(String s) {
    char[] cs = s.toCharArray();
    for (int i = 1; i < cs.length - 1; ++i) {
      if (cs[i - 1] == '1' && cs[i + 1] == '1') {
        cs[i] = '1';
      }
    }
    int maxOneNum = (int) IntStream.range(0, cs.length).filter(i -> cs[i] == '1').count();

    for (int i = 1; i < cs.length - 1; ++i) {
      if (cs[i - 1] == '1' && cs[i + 1] == '1') {
        cs[i] = '0';
      }
    }
    int minOneNum = (int) IntStream.range(0, cs.length).filter(i -> cs[i] == '1').count();

    return "%d %d".formatted(minOneNum, maxOneNum);
  }
}