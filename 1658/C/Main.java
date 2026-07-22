import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] c) {
    int[] oneIndices = IntStream.range(0, c.length).filter(i -> c[i] == 1).toArray();
    if (oneIndices.length != 1) {
      return false;
    }

    int[] rotated =
        IntStream.range(0, c.length).map(i -> c[(oneIndices[0] + i) % c.length]).toArray();

    return IntStream.range(1, rotated.length).allMatch(i -> rotated[i] <= rotated[i - 1] + 1);
  }
}