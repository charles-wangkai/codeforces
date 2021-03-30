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
    char[] c = s.toCharArray();

    int beginIndex = 0;
    while (c[beginIndex] == '.') {
      ++beginIndex;
    }
    c[beginIndex] = 'x';

    int endIndex = c.length - 1;
    while (c[endIndex] == '.') {
      --endIndex;
    }
    c[endIndex] = 'x';

    int index = beginIndex;
    while (index != endIndex) {
      for (int i = index + k; ; --i) {
        if (i < c.length && c[i] != '.') {
          c[i] = 'x';
          index = i;

          break;
        }
      }
    }

    return (int) IntStream.range(0, c.length).filter(i -> c[i] == 'x').count();
  }
}
