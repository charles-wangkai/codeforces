import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b, x, y));
    }

    sc.close();
  }

  static long solve(String a, String b, int x, int y) {
    int[] diffIndices =
        IntStream.range(0, a.length()).filter(i -> a.charAt(i) != b.charAt(i)).toArray();
    if (diffIndices.length % 2 != 0) {
      return -1;
    }
    if (diffIndices.length != 2 || diffIndices[0] + 1 != diffIndices[1]) {
      return diffIndices.length / 2L * y;
    }

    return Math.min(x, 2 * y);
  }
}
