import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    int n = p.length;

    Map<Integer, Integer> valueToPos =
        IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> p[i], i -> i + 1));
    int pos1 = valueToPos.get(1);
    int pos2 = valueToPos.get(2);
    int posN = valueToPos.get(n);

    int i;
    int j;
    if (posN == 1) {
      i = 1;
      j = Math.min(pos1, pos2);
    } else if (posN == n) {
      i = n;
      j = Math.max(pos1, pos2);
    } else {
      i = pos2;
      j = (posN < pos1) ? 1 : n;
    }

    return String.format("%d %d", i, j);
  }
}
